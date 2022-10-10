package com.friendbook.services;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import com.friendbook.entity.Post;

public interface PostService {

	public boolean postUpload(MultipartFile imageFile, HttpSession session) throws IOException;

	public List<Post> viewPost(int userid);

	public List<Post> viewPostofFollowing(int userid);
}
