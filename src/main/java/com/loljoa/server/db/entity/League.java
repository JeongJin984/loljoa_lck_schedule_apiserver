package com.loljoa.server.db.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class League {
    @Id
    @GeneratedValue
    private Long leagueId;

    private String weekNum;
    private String leagueName;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public League(String weekNum, String leagueName, LocalDateTime startTime, LocalDateTime endTime) {
        this.weekNum = weekNum;
        this.leagueName = leagueName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @ManyToOne(targetEntity = LeagueCategory.class)
    private LeagueCategory category;

    @OneToMany(mappedBy = "league", fetch = FetchType.LAZY)
    private List<GameData> gameData = new ArrayList<>();

    @OneToMany(mappedBy = "league", fetch = FetchType.LAZY)
    private List<LeagueComment> comments = new ArrayList<>();

    public League(String leagueName, LocalDateTime startTime, LocalDateTime endTime, LeagueCategory category) {
        this.leagueName = leagueName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.category = category;
    }
}
