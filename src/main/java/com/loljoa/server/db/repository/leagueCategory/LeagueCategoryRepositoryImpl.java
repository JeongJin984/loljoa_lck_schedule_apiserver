package com.loljoa.server.db.repository.leagueCategory;

import com.loljoa.server.db.entity.LeagueCategory;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.loljoa.server.db.entity.QLeagueCategory.leagueCategory;

@Repository
@RequiredArgsConstructor
public class LeagueCategoryRepositoryImpl implements LeagueCategoryRepositoryCustom {
    private final JPAQueryFactory factory;

    @Override
    public LeagueCategory getCategoryEntity(String categoryName) {
        return factory
                .selectFrom(leagueCategory)
                .where(leagueCategory.name.eq(categoryName))
                .fetchOne();
    }

}
