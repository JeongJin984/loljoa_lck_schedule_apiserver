package com.loljoa.server.web.dto.leagueSchedule;

import lombok.Data;


import java.util.ArrayList;
import java.util.List;

@Data
public class ScheduleDto {
    String category;
    List<LeagueDto> schedules = new ArrayList<>();
}

