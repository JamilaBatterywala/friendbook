package com.friendbook.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendbook.Repository.FollwingRepository;
import com.friendbook.entity.Following;
import com.friendbook.services.FollowingService;

@Service
public class FollowingServiceImpl implements FollowingService{
	@Autowired
	private FollwingRepository followingRepo;
	
	public Following addFollowing(Following following) {
		followingRepo.save(following);

		return following;
	}


	public List<Following> getFollowing(int userid) {
		return this.followingRepo.findByuserId(userid);
	}

}
