package com.loljoa.server.db.repository.leagueCategory;

import com.loljoa.server.db.entity.LeagueCategory;

public interface LeagueCategoryRepositoryCustom {

    LeagueCategory getCategoryEntity(String categoryName);
}
