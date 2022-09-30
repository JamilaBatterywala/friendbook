package com.friendbook.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.friendbook.entity.Comment;

@Component
public interface CommentService {
	public Comment addComment(Comment comment);
	
	public List<Comment> getComments(int postId);

}
