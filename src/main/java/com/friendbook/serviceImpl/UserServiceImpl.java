package com.friendbook.serviceImpl;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.friendbook.Repository.UserRepository;
import com.friendbook.entity.User;
import com.friendbook.services.UserService;
@Service
public class UserServiceImpl implements UserService {


	@Autowired
    private UserRepository userRepo;
	
	public User login(String email, String password) {
    User user = userRepo.findByEmailAndPassword(email, password);
		
		return user;
	}
	public User getDetails(String username) {
		return userRepo.findByusername(username);
		
	}	
	public User Update(int uid, String favSongs, String favBooks, String favPlaces) {
		User user = userRepo.findById(uid);
		user.setFavSongs(favSongs);
		user.setFavBooks(favBooks);
		user.setFavPlaces(favPlaces);
		userRepo.save(user);
		return user;
	}	
	public List<User> SearchUser(String username) {
		return userRepo.searchByUsername(username);
	}
	
	
	public boolean profileSave(User u, MultipartFile imageFile, String username) throws IOException {
		String profilePhoto = "";
//		String name = u.getName();
//		String email = u.getEmail();
//		String book = u.getFavBooks();
//		String song = u.getFavSongs();
//		String places = u.getFavPlaces();

//		if (name.isEmpty() || email.isEmpty()) {
//			return false;
//		}
		if (!imageFile.isEmpty()) {
			profilePhoto = imageFile.getOriginalFilename().trim();
			InputStream is = imageFile.getInputStream();
			String path = "C:\\Users\\Dell\\Documents\\friendbook\\friendbook\\src\\main\\webapp\\images\\profilepic\\"
					+ profilePhoto;
			int bytes = 0;
			FileOutputStream fs = new FileOutputStream(path);
			while ((bytes = is.read()) != -1)
				fs.write(bytes);
			fs.close();
		}

		u = userRepo.findByusername(username);

		if (!profilePhoto.isEmpty()) {
			u.setProfilePic(profilePhoto);
		}
//		if (!name.isEmpty()) {
//			u.setName(name);
//		}
//		if (!email.isEmpty()) {
//			u.setEmail(email);
//		}
//		u.setFavBooks(book);
//		u.setFavSongs(song);
//		u.setFavPlaces(places);
		userRepo.save(u);
		return true;
	}
	
	
	

}
