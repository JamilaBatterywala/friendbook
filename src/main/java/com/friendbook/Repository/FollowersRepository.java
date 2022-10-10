package com.friendbook.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.friendbook.entity.Followers;

public interface FollowersRepository extends CrudRepository<Followers, Integer> {

	@Query(value = " select * from followers where user_id =:user_id", nativeQuery = true)
	public List<Followers> findByuserId(@Param("user_id") int user_id);

}
