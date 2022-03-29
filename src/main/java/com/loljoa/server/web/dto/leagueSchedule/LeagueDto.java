package com.loljoa.server.web.dto.leagueSchedule;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Data

public class LeagueDto {
    private String  leagueName;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime startTime;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime endTime;
}