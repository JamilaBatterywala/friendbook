package com.friendbook.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import com.friendbook.entity.Following;

public interface FollwingRepository extends CrudRepository<Following, Integer>{
	@Query(value = " select * from following where user_id =:user_id",nativeQuery = true)
	public List<Following> findByuserId(@Param("user_id") int user_id);
}
