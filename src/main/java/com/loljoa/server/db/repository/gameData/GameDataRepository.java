package com.loljoa.server.db.repository.gameData;

import com.loljoa.server.db.entity.GameData;
import com.loljoa.server.db.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameDataRepository extends CommonRepository<GameData, Long>, GameDataRepositoryCustom {
}
