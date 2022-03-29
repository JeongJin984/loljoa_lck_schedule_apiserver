package com.loljoa.server.db.repository.leagueCategory;

import com.loljoa.server.db.entity.LeagueCategory;
import com.loljoa.server.db.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueCategoryRepository extends CommonRepository<LeagueCategory, Long>, LeagueCategoryRepositoryCustom {
}
