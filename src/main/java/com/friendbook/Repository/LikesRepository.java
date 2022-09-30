package com.friendbook.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.friendbook.entity.Likes;


public interface LikesRepository extends CrudRepository<Likes, Integer> {
	@Query(value = "select * from likes l where l.post_id = :post_id",nativeQuery = true)
	public List<Likes> findBypostId(@Param("post_id") int post_id);
}
