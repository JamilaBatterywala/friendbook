package com.friendbook.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.friendbook.Repository.FollwingRepository;

import com.friendbook.entity.Following;

public interface FollowingService {

	public Following addFollowing(Following following);

	public List<Following> getFollowing(int userid);
}
