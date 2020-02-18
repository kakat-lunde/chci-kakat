package eu.lundegaard.service;

import eu.lundegaard.dto.StatisticsDto;
import eu.lundegaard.dto.ToiletDto;
import eu.lundegaard.dto.ToiletStateDto;
import eu.lundegaard.model.Nickname;
import eu.lundegaard.model.PoopingSession;
import eu.lundegaard.model.Toilet;
import eu.lundegaard.repository.NicknameRepository;
import eu.lundegaard.repository.PoopingSessionRepository;
import eu.lundegaard.repository.ToiletRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.PostConstruct;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Slf4j
@RequiredArgsConstructor
public class PoopingService {

    private final RestTemplate restTemplate;
    private final PoopingSessionRepository poopingSessionRepository;
    private final NicknameRepository nicknameRepository;
    private final ToiletRepository toiletRepository;

    private List<Toilet> toilets;
    private List<Nickname> nicknames;

    @PostConstruct
    public void init() {
        toilets = (List) toiletRepository.findAll();
        nicknames = (List) nicknameRepository.findAll();
    }

    public void checkStates() {
        for (Toilet toilet : toilets) {
            //ToiletStateDto toiletStateDto = restTemplate.getForObject(toilet.getIpAddress() + "/state", ToiletStateDto.class);
            //MOCKING RESPONSE - CHANGE BACK TO REST TEMPLATE WHEN CONNECTED TO SENSONRS
            ToiletStateDto toiletStateDto = new ToiletStateDto();
            toiletStateDto.setLocked(new Random().nextBoolean());

            Optional<PoopingSession> poopingSession = poopingSessionRepository.findByToiletAndEndTimeIsNull(toilet);

            log.info(toiletStateDto.isLocked() + "");
            if (toiletStateDto.isLocked()) {
                if (poopingSession.isEmpty()) {
                    createNewSession(toilet);
                } else {
                    // do nothing
                }
            } else {
                if (poopingSession.isEmpty()) {
                    // do nothing
                } else {
                    closeSession(poopingSession);
                }
            }
        }
    }

    private void closeSession(Optional<PoopingSession> poopingSession) {
        PoopingSession currentPoopingSession = poopingSession.get();
        currentPoopingSession.setEndTime(LocalDateTime.now());
        poopingSessionRepository.save(currentPoopingSession);
    }

    private void createNewSession(Toilet toilet) {
        PoopingSession newPoopingSession = new PoopingSession();
        newPoopingSession.setStartTime(LocalDateTime.now());
        newPoopingSession.setToilet(toilet);
        newPoopingSession.setNickname(nicknames.get(new Random().nextInt(nicknames.size())));
        poopingSessionRepository.save(newPoopingSession);
        toilet.setLastSession(newPoopingSession);
        toiletRepository.save(toilet);
    }

    public List<ToiletDto> getToilets() {
        List<ToiletDto> toiletDtos = new ArrayList<>();
        for (Toilet toilet : toiletRepository.findAll()) {
            ToiletDto toiletDto = new ToiletDto();
            toiletDto.setId(toilet.getId());
            if (toilet.getLastSession() != null) {
                toiletDto.setLocked(toilet.getLastSession().getEndTime() == null);
                toiletDto.setEndTime(toilet.getLastSession().getEndTime());
                toiletDto.setStartTime(toilet.getLastSession().getStartTime());
                toiletDto.setNickname(toilet.getLastSession().getNickname().getName());
            }
            toiletDtos.add(toiletDto);
        }
        return toiletDtos;
    }

    public StatisticsDto getStatistics() {
        return null;
    }
}
