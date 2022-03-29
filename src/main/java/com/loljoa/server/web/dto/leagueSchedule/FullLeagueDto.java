package com.loljoa.server.web.dto.leagueSchedule;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.loljoa.server.db.entity.GameData;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class FullLeagueDto {
    private String  leagueName;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime startTime;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalDateTime endTime;

    private List<Long> gameDataIds = new ArrayList<>();

    public FullLeagueDto(String leagueName, LocalDateTime startTime, LocalDateTime endTime, List<GameData> gameDatas) {
        this.leagueName = leagueName;
        this.startTime = startTime;
        this.endTime = endTime;
        for(GameData v : gameDatas) {
            gameDataIds.add(v.getGameId());
        }
    }
}
