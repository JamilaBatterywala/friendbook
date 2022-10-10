package com.friendbook.services;

import java.util.List;

//import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import com.friendbook.entity.User;
@Component
//public interface UserService extends UserDetailsService {
public interface UserService {
	public User login(String email , String password) ;
	
	public User getDetails(String username);
	
	public User Update(int uid,String favSongs , String favBooks , String favPlaces);
	
	public List<User> SearchUser(String username);

}
