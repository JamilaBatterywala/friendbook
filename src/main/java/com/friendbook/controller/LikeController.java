package com.friendbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.friendbook.entity.Likes;
import com.friendbook.serviceImpl.LikesServiceImpl;


@Controller
public class LikeController {
	@Autowired
	private LikesServiceImpl likeImpl;
	
	@PostMapping("/home/like")
	public String likepost(Likes likes)
	{
		likeImpl.addLikes(likes);
		return "home";
	}
	
	

}
