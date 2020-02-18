package eu.lundegaard.dto;

import eu.lundegaard.model.PoopingSession;
import lombok.Data;

import java.util.List;

@Data
public class StatisticsDto {

    double averagePoopingTime;

    List<PoopingSession> allTimeTop10;

    List<PoopingSession> todayTop10;
}
