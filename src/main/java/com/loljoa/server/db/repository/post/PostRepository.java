package com.loljoa.server.db.repository.post;

import com.loljoa.server.db.entity.Post;
import com.loljoa.server.db.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CommonRepository<Post, Long>, PostRepositoryCustom {
}
