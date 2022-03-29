package com.loljoa.server.db.repository.postComment;

import com.loljoa.server.db.entity.PostComment;
import com.loljoa.server.db.repository.CommonRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostCommentRepository extends CommonRepository<PostComment, Long>, PostCommentRepositoryCustom{
}
