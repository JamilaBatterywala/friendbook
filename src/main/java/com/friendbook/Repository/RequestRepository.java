package com.friendbook.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.friendbook.entity.SendRequest;

public interface RequestRepository extends CrudRepository<SendRequest, Integer> {


	@Query(value = " select * from requests where reciever_id =:reciever_id and accept_id =:accept_id",nativeQuery = true)
	public List<SendRequest> findByReciverId(@Param("reciever_id") int reciever_id,@Param("accept_id") int accept_id);
	
	@Modifying
	@Query(value = "update requests set accept_id = 1 where id =:id",nativeQuery = true)
	public void acceptRequest( @Param("id") int id);
	
}

