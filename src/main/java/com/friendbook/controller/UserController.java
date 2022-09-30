package com.friendbook.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.hibernate.internal.build.AllowSysOut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.friendbook.Repository.RequestRepository;
import com.friendbook.Repository.UserRepository;
import com.friendbook.entity.Comment;
import com.friendbook.entity.Followers;
import com.friendbook.entity.Following;
import com.friendbook.entity.Likes;
import com.friendbook.entity.Post;
import com.friendbook.entity.SendRequest;
import com.friendbook.entity.User;
import com.friendbook.serviceImpl.CommentServiceImpl;
import com.friendbook.serviceImpl.FollowersServiceImpl;
import com.friendbook.serviceImpl.FollowingServiceImpl;
import com.friendbook.serviceImpl.LikesServiceImpl;
import com.friendbook.serviceImpl.PostServiceImpl;
import com.friendbook.serviceImpl.RequestServiceImpl;
import com.friendbook.serviceImpl.UserServiceImpl;
//import com.friendbook.services.UserServices;
@Controller
public class UserController {
	@Autowired
    private UserRepository userRepo;
	@Autowired
	private UserServiceImpl userService;
	@Autowired
	private RequestRepository requestRepo;
	@Autowired
	private RequestServiceImpl requestService;
	@Autowired
	private FollowersServiceImpl followersImpl;
	@Autowired
	private FollowingServiceImpl followingImpl;
	@Autowired
	private PostServiceImpl postImpl;
	@Autowired
	private LikesServiceImpl likeImpl;
	@Autowired
	private CommentServiceImpl commentImpl;
	private HttpSession session;
	private int userId;
	private List<Likes> likes;
	@GetMapping("/Registration")
	public String Registration(Model model) {
		model.addAttribute("user",new User());
		
		System.out.println("registration page called");
		return "Registration";
		
		
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	@RequestMapping("/home")
	public String home(HttpSession session,Followers followers ,HttpServletRequest req,Model model,Following following,Post post, @ModelAttribute("like")Likes like,
			@ModelAttribute("comments")Comment Comment)
			 {
		//System.out.println(post.getPostId());
		this.userId = (int) session.getAttribute("uid");
		List<Post> Allposts = postImpl.viewPostofFollowing(userId);
		List<Integer> collect = Allposts.stream().map(postId -> postId.getPostId()).collect(Collectors.toList());
		List<Likes> likes = new ArrayList<>();
		List<Comment> comments = new ArrayList<>();

		System.out.println(collect);
		for (int i = 0; i < collect.size(); i++) {
			 
           int postId = collect.get(i);
           if(likeImpl.getLikes(postId) ==null) {
        	   model.addAttribute("Allposts",Allposts);   
           }
           else {
          likes.addAll(i, likeImpl.getLikes(postId));
          comments.addAll(i,commentImpl.getComments(postId));
//          model.addAttribute("Likes",likes);
//  		model.addAttribute("Comments",comments);
           }
        }
		
		model.addAttribute("Likes",likes);
		model.addAttribute("Comments",comments);
           System.out.println(comments);
           System.out.println(likes);
		System.out.println(Allposts);
		
		model.addAttribute("Allposts",Allposts);
	
		return "home";
	}
	
	@PostMapping("/Registersuccess")
	public String processRegister(User user) { 
		String username1 =user.getName();
		String username2 = username1.substring(0, 5);
		Random rand = new Random();
	    int randomNum = rand.nextInt((999 - 100) + 1) + 100;
		String username = username2+randomNum;
		System.out.println(username);
		user.setUsername(username);
	    userRepo.save(user);     
	    return "Registersuccess";
	}
	

	@PostMapping("/home")
	public String LoginUser(@ModelAttribute("user") User user ,HttpSession session) {

	User authuser = userService.login(user.getEmail(), user.getPassword());
	
	System.out.println(authuser);
	if(Objects.nonNull(authuser))
	{
		session.setAttribute("username", authuser.getUsername());
		session.setAttribute("uid", authuser.getUid());
		session.setAttribute("name", authuser.getName());
		session.setAttribute("favBooks", authuser.getFavBooks());
		session.setAttribute("favPlaces", authuser.getFavPlaces());
		session.setAttribute("favSongs", authuser.getFavSongs());
		session.setAttribute("profilepic",authuser.getProfilePic());
		System.out.println(authuser.getProfilePic());
		System.out.println(user);
		return "home";
	
	}
	else {
		return "login";
	}
	
  }
	
	@RequestMapping("/MyProfile")
	public String ProfilePage(HttpSession session,Followers followers ,HttpServletRequest req,Model model,Following following,Post post) {
		this.userId = (int) session.getAttribute("uid");
		//System.out.println(userId);
		List<Followers> follower = followersImpl.getFollower(userId);
		List<Following> followings = followingImpl.getFollowing(userId);
		List<Post> posts = postImpl.viewPost(userId);
		System.out.println(follower);
		System.out.println(followings);
		System.out.println(posts);
		model.addAttribute("follower",follower);
		model.addAttribute("followings",followings);
		model.addAttribute("posts",posts);
		return "MyProfile";
	}
	
	@PostMapping("/MyProfile")
	public String Update(@ModelAttribute("user") User user,HttpSession session ,@RequestParam("profile_pic") MultipartFile imageFile)
			 throws IOException{
		userService.Update(user.getUid(), user.getFavSongs(), user.getFavBooks(), user.getFavPlaces());
		userService.profileSave(user, imageFile ,(String)session.getAttribute("username"));
		System.out.println(user);
		session.setAttribute("profilepic",user.getProfilePic());
		session.setAttribute("favBooks", user.getFavBooks());
		session.setAttribute("favPlaces", user.getFavPlaces());
		session.setAttribute("favSongs", user.getFavSongs());
		System.out.println(user);
		return "MyProfile";
	}
	
	@GetMapping("/search")
	public String Search(User user,Model model , String username,HttpSession session) {
		if(username!=null) {
		
			List<User> list = userService.SearchUser(username);
			
			model.addAttribute("list",list); 
		}else {
			model.addAttribute("message","No Users Found..");
			
		}
		return "search";
	}
	

//	@PostMapping("/MyProfile/uploadImage")
//	public String uploadImage(@ModelAttribute User u, @RequestParam("profile_pic") MultipartFile imageFile,
//			HttpSession session) throws IOException {
//	userService.profileSave(u, imageFile ,(String)session.getAttribute("username"));
//		session.setAttribute("profilepic",u.getProfilePic());
//		return "MyProfile";
//	}
//	

	

	
	


}