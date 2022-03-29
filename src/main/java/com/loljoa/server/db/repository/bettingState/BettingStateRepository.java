package com.loljoa.server.db.repository.bettingState;

import com.loljoa.server.db.entity.BettingState;
import com.loljoa.server.db.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BettingStateRepository extends CommonRepository<BettingState, Long>, BettingStateRepositoryCustom {
}
