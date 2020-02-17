package eu.lundegaard.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ToiletScheduler {

    private final PoopingService poopingService;

    @Scheduled(fixedDelay = 5000)
    public void scanToilets() {
        poopingService.checkStates();
    }
}
