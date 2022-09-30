package com.friendbook.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendbook.Repository.LikesRepository;
import com.friendbook.entity.Likes;
import com.friendbook.services.LikeServices;

@Service
public class LikesServiceImpl implements LikeServices{
	@Autowired
	private LikesRepository likeRepo;
	
	@Override
	public Likes addLikes(Likes likes) {
		likeRepo.save(likes);
		return likes;
	}

	@Override
	public List<Likes> getLikes(int postId) {
		return this.likeRepo.findBypostId(postId);
	}

}
