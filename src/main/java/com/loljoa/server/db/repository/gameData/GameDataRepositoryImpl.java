package com.loljoa.server.db.repository.gameData;

import com.loljoa.server.db.entity.GameData;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class GameDataRepositoryImpl implements GameDataRepositoryCustom {
    private final JPAQueryFactory factory;
}
