package com.friendbook.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.friendbook.entity.Followers;
import com.friendbook.serviceImpl.FollowersServiceImpl;

@Controller
public class FollowerController {
	@Autowired
	private FollowersServiceImpl followersImpl;
	private HttpSession session;
	private int userId;
	
	
//	@RequestMapping("/MyProfile")
//	public String getFollowers(Followers followers,HttpServletRequest req,Model model) {
//		this.userId = (int) session.getAttribute("uid");
//		List<Followers> follower = followersImpl.getFollowers(userId);
//		System.out.println(follower);
//		return "MyProfile";
//	}
	

}
