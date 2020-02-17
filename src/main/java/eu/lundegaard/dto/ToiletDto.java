package eu.lundegaard.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ToiletDto {

    private String id;

    private boolean locked;

    private LocalDateTime startTime;

    private LocalDateTime endTime;
}
