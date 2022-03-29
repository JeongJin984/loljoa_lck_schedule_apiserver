package com.loljoa.server.web.api;

import com.loljoa.server.web.dto.leagueSchedule.FullLeagueScheduleDto;
import com.loljoa.server.web.dto.leagueSchedule.ScheduleDto;
import com.loljoa.server.web.service.LeagueScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequiredArgsConstructor
public class LeagueScheduleApi {
    private final LeagueScheduleService leagueScheduleService;

    @PostMapping("/schedule/add")
    void addSchedule(
            @RequestBody List<ScheduleDto> schedule
    ) {
        for(ScheduleDto v : schedule) {
            leagueScheduleService.addLeagueSchedule(v.getCategory(), v.getSchedules());
        }
    }

    @GetMapping("/schedule/all")
    List<FullLeagueScheduleDto> getAllSchedule() {
        return leagueScheduleService.getAllLeagueSchedules();
    }


}
