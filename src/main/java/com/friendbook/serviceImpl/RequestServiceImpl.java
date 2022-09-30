package com.friendbook.serviceImpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.friendbook.Repository.RequestRepository;
import com.friendbook.Repository.UserRepository;
import com.friendbook.entity.SendRequest;
import com.friendbook.services.RequestService;
@Service
public class RequestServiceImpl implements RequestService {

	
	@Autowired
    private RequestRepository requestRepo;
	
	public SendRequest saveRequest(SendRequest request) {
		requestRepo.save(request);
		return request;
	}


	public List<SendRequest> getRequests(int recieverid,int acceptid) {
		return this.requestRepo.findByReciverId(recieverid, acceptid);
		
	}


	@Transactional
	public int accept( int id) {
		requestRepo.acceptRequest( id);
		return 1;
	}
	
	
	
	

	
	
}
