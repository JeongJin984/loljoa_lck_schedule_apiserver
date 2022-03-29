package com.loljoa.server.web.api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.loljoa.server.db.dto.LeagueScheduleDto;
import com.loljoa.server.web.service.GameDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GameDataApi {
}
