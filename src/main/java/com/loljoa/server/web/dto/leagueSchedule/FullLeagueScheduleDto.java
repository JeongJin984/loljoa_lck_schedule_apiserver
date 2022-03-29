package com.loljoa.server.web.dto.leagueSchedule;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class FullLeagueScheduleDto {
    String categoryName;
    List<FullLeagueDto> leagues = new ArrayList<>();
}
