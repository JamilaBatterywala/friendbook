package com.friendbook.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.friendbook.entity.Followers;

public interface FollowerService {

	public Followers addFollower(Followers followers);

	public List<Followers> getFollower(int userid);

}
