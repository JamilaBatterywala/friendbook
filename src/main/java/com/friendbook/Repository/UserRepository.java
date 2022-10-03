package com.friendbook.Repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.friendbook.entity.User;


public interface UserRepository extends CrudRepository<User, Integer> {

	public User findByEmailAndPassword(String email,String password);

	public User findByusername(String username);
	
	public User findById(int id);

	
	@Query(value = "select * from user u where u.username like %:username% ",nativeQuery = true)
	public List<User> searchByUsername(@Param("username") String username);
	
}

