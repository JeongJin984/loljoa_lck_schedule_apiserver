package com.loljoa.server.db.repository.rank;

import com.loljoa.server.db.entity.Tier;
import com.loljoa.server.db.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RankRepository extends CommonRepository<Tier, Long>, RankRepositoryCustom {
}
