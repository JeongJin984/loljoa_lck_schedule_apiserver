package com.loljoa.server.db.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.loljoa.server.db.entity.GameData;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
public class LeagueScheduleDto {
    String title;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    LocalDateTime startTime;

    @JsonFormat(pattern = "YYYY-MM-dd HH:mm")
    LocalDateTime endTime;

    List<GameDataDto> gameData = new ArrayList<>();

    public LeagueScheduleDto(String title, LocalDateTime startTime, LocalDateTime endTime, List<GameData> gameData) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
        for(GameData gd : gameData) {
            this.gameData.add(new GameDataDto(gd.getGameId(), gd.getTitle()));
        }
    }

    @AllArgsConstructor
    static class GameDataDto {
        Long id;
        String title;
    }
}
