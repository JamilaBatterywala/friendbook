package com.friendbook.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendbook.Repository.FollowersRepository;
import com.friendbook.entity.Followers;
import com.friendbook.services.FollowerService;

@Service
public class FollowersServiceImpl implements FollowerService {
	@Autowired
	private FollowersRepository followersRepo;
	
	public Followers addFollower(Followers followers) {
		followersRepo.save(followers);
		return followers;
	}


	public List<Followers> getFollower(int userid) {
		return this.followersRepo.findByuserId(userid);
	}
	

}
