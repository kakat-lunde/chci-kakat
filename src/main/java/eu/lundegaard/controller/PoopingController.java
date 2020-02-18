package eu.lundegaard.controller;

import eu.lundegaard.dto.StatisticsDto;
import eu.lundegaard.dto.ToiletDto;
import eu.lundegaard.service.PoopingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PoopingController {

    private final PoopingService poopingService;

    @CrossOrigin
    @GetMapping("/poop")
    public List<ToiletDto> getToilets() {
        return poopingService.getToilets();
    }

    @CrossOrigin
    @GetMapping("/stats")
    public StatisticsDto getStatistics() {
        return poopingService.getStatistics();
    }
}
