package com.friendbook.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.friendbook.entity.Likes;

public interface LikeServices {

	public Likes addLikes(Likes likes);

	public List<Likes> getLikes(int postId);

}
