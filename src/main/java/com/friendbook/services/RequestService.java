package com.friendbook.services;

import java.util.List;

import org.springframework.stereotype.Component;

import com.friendbook.entity.SendRequest;

@Component
public interface RequestService {

	public SendRequest saveRequest(SendRequest request);
	
	public List<SendRequest> getRequests(int recieverid,int acceptid);
	
	public int accept(int id);
	

	
	
}
