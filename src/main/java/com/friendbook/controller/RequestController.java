package com.friendbook.controller;


import java.util.Iterator;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.friendbook.Repository.RequestRepository;
import com.friendbook.entity.Followers;
import com.friendbook.entity.Following;
import com.friendbook.entity.SendRequest;
import com.friendbook.entity.User;
import com.friendbook.serviceImpl.FollowersServiceImpl;
import com.friendbook.serviceImpl.FollowingServiceImpl;
import com.friendbook.serviceImpl.RequestServiceImpl;


@Controller
public class RequestController {
	@Autowired
	private RequestRepository requestRepo;
	@Autowired
	private RequestServiceImpl requestService;
	@Autowired
	private FollowersServiceImpl followersImpl;
	@Autowired
	private FollowingServiceImpl followingImpl;
	private HttpSession session;
	private int userId;
	
	
	@PostMapping("/search")
	public String sendRequest(SendRequest request , Model model,String username) {
		
		request.setAcceptid(0);
		requestService.saveRequest(request);
		
		if(Objects.nonNull(request))	{
			model.addAttribute("msg", "Request sent");
			
		}
		return "redirect:/search?username="+username;
		//return "redirect:/search";
	}
	
	@RequestMapping("/notification")
	public String notification(SendRequest request,HttpServletRequest req,Model model) {
		this.session= req.getSession();
		this.userId = (int) session.getAttribute("uid");
		int acceptid = 0;
		List<SendRequest> requests = requestService.getRequests(userId, acceptid);
		
		
		model.addAttribute("requests",requests);
		System.out.println(requests);
		Iterator<SendRequest> it = requests.listIterator();
		while (it.hasNext()) {
			
			
            System.out.println(it.next());
        }
		 
		System.out.println(request.getRecieverid());
		
		System.out.println(userId);
		
		
		
		return "notification";
	}
	@PostMapping("/notification")
	public String acceptRequest(@RequestParam("id") int id,Followers followers,Following following, HttpServletRequest req) {
		this.session= req.getSession();
		followersImpl.addFollower(followers);
		followingImpl.addFollowing(following);
		requestService.accept(id );
		return "notification";
	}
	
	@PostMapping("/declinerequest")
	public String deleteRequest(@RequestParam("id") int id,Followers followers,Following following, HttpServletRequest req) {
		this.session= req.getSession();
		requestService.delete(id);
		return "notification";
	}
	
	

}
