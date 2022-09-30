package com.friendbook.controller;

import java.io.IOException;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.friendbook.entity.Post;
import com.friendbook.serviceImpl.PostServiceImpl;
@Controller
public class PostController {
	@Autowired
	private PostServiceImpl postImpl;
	private HttpSession session;

	@PostMapping("/UploadPost")
	public String addPhotos(@RequestParam("postpic") MultipartFile imageFile,HttpSession session) throws IOException {
		 postImpl.postUpload(imageFile,session);
		
		return "UploadPost";
		
	}
}
