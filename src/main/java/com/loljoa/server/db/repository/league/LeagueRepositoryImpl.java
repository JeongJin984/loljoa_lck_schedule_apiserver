package com.loljoa.server.db.repository.league;

import com.loljoa.server.db.condition.LeagueSearchCondition;
import com.loljoa.server.db.entity.League;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.loljoa.server.db.entity.QGameData.gameData;
import static com.loljoa.server.db.entity.QLeague.league;
import static com.loljoa.server.db.entity.QLeagueCategory.leagueCategory;
import static org.springframework.util.StringUtils.hasText;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class LeagueRepositoryImpl implements LeagueRepositoryCustom {
    private final JPAQueryFactory factory;

    @Override
    public List<League> searchLeagueWithCategoryAndGameData(LeagueSearchCondition condition) {
        List<League> fetch = factory
                .selectFrom(league)
                .join(league.category(), leagueCategory).fetchJoin()
                .distinct()
                .where(
                        leagueCategoryEq(condition.getCategoryName())
                )
                .fetch();
        return fetch;
    }

    BooleanExpression leagueCategoryEq(String categoryName) {
        return hasText(categoryName) ? league.category().name.eq(categoryName) : null;
    }
}