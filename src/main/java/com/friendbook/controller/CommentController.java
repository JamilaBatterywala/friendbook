package com.friendbook.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

import com.friendbook.entity.Comment;
import com.friendbook.serviceImpl.CommentServiceImpl;

@Controller
public class CommentController {
	@Autowired
	private CommentServiceImpl commentImpl;

	@PostMapping("/home/comment")
	public String commentPost(Comment comment) {
		commentImpl.addComment(comment);
		return "home";
	}

}
