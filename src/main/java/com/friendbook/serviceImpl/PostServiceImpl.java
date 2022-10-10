package com.friendbook.serviceImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.friendbook.Repository.PostRepository;
import com.friendbook.entity.Post;
import com.friendbook.entity.User;
import com.friendbook.services.PostService;

@Service
public class PostServiceImpl implements PostService {
	@Autowired
	private PostRepository postRepo;

	@Override
	public boolean postUpload(MultipartFile imageFile, HttpSession session) throws IOException {
		String profilePhoto = "";
		if (!imageFile.isEmpty()) {
			profilePhoto = imageFile.getOriginalFilename().trim();
			InputStream is = imageFile.getInputStream();
			String path = "C:\\Users\\Dell\\Documents\\friendbook\\friendbook\\src\\main\\webapp\\images\\posts\\"
					+ profilePhoto;
			int bytes = 0;
			FileOutputStream fs = new FileOutputStream(path);
			while ((bytes = is.read()) != -1)
				fs.write(bytes);
			fs.close();

			int loginUserId = (int) session.getAttribute("uid");
			Post postEntity = new Post();
			User user = new User();
			user.setUid(loginUserId);
			postEntity.setPostpic(profilePhoto);
			postEntity.setUserId(user);
			postRepo.save(postEntity);
			return true;
		}
		return false;

	}

	@Override
	public List<Post> viewPost(int userid) {

		return this.postRepo.findbyUserid(userid);
	}

	@Override
	public List<Post> viewPostofFollowing(int userid) {
		return this.postRepo.findbyFollowerid(userid);
	}

}
