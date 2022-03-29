package com.loljoa.server.web.service;

import com.loljoa.server.db.condition.LeagueSearchCondition;
import com.loljoa.server.db.dto.LeagueScheduleDto;
import com.loljoa.server.db.entity.League;
import com.loljoa.server.db.entity.LeagueCategory;
import com.loljoa.server.db.repository.league.LeagueRepository;
import com.loljoa.server.db.repository.leagueCategory.LeagueCategoryRepository;
import com.loljoa.server.web.api.LeagueScheduleApi;
import com.loljoa.server.web.dto.leagueSchedule.FullLeagueDto;
import com.loljoa.server.web.dto.leagueSchedule.FullLeagueScheduleDto;
import com.loljoa.server.web.dto.leagueSchedule.LeagueDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@Service
@RequiredArgsConstructor
public class LeagueScheduleService {
    private final LeagueRepository leagueRepository;
    private final LeagueCategoryRepository leagueCategoryRepository;

    public List<FullLeagueScheduleDto> getAllLeagueSchedules() {
        LeagueSearchCondition condition = new LeagueSearchCondition();

        List<League> result = leagueRepository.searchLeagueWithCategoryAndGameData(condition);

        ConcurrentHashMap<String, List<FullLeagueDto>> map = new ConcurrentHashMap<>();
        for(League l : result) {
            map.computeIfAbsent(l.getCategory().getName(), k -> new ArrayList<>());
            map.get(l.getCategory().getName()).add(new FullLeagueDto(l.getLeagueName(), l.getStartTime(), l.getEndTime(), l.getGameData()));
        }

        List<FullLeagueScheduleDto> schedules = new ArrayList<>();

        for(String categoryName : map.keySet()) {
            schedules.add(new FullLeagueScheduleDto(categoryName, map.get(categoryName)));
        }

        return schedules;
    }

    @Transactional
    public void addLeagueSchedule(String categoryName, List<LeagueDto> leagues) {
        LeagueCategory leagueCategory = leagueCategoryRepository.getCategoryEntity(categoryName);
        if(leagueCategory == null) {
            leagueCategory = leagueCategoryRepository.save(new LeagueCategory(categoryName));
        }

        for(LeagueDto v : leagues) {
            leagueRepository.save(new League(v.getLeagueName(), v.getStartTime(), v.getEndTime(), leagueCategory));
        }
    }
}
