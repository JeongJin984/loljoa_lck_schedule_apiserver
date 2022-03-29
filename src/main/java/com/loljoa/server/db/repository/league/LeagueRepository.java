package com.loljoa.server.db.repository.league;

import com.loljoa.server.db.entity.League;
import com.loljoa.server.db.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueRepository extends CommonRepository<League, Long>, LeagueRepositoryCustom {
}
