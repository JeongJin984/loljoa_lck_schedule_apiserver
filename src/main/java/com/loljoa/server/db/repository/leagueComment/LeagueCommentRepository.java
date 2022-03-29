package com.loljoa.server.db.repository.leagueComment;

import com.loljoa.server.db.entity.LeagueComment;
import com.loljoa.server.db.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeagueCommentRepository extends CommonRepository<LeagueComment, Long>, LeagueCommentRepositoryCustom {
}
