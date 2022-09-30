package com.friendbook.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.friendbook.entity.Comment;

public interface CommentRepository extends CrudRepository<Comment, Integer> {
	@Query(value = "select * from comment c  where c.post_id = :post_id",nativeQuery = true)
	public List<Comment> findByPostId(@Param("post_id")int post_id);
}
