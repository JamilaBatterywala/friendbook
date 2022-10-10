package com.friendbook.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendbook.Repository.CommentRepository;
import com.friendbook.entity.Comment;
import com.friendbook.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepository commentRepo;

	@Override
	public Comment addComment(Comment comment) {
		commentRepo.save(comment);
		return comment;
	}

	@Override
	public List<Comment> getComments(int postId) {
		return this.commentRepo.findByPostId(postId);
	}

}
