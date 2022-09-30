package com.friendbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name = "post")
public class Post {
	@Id
	@Column(name="post_id")
	private int postId;
	@Column(name = "post_pic")
	private String postpic;
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User userId;

	
	
	
	public Post(int postId, String postpic, User userId) {
		super();
		this.postId = postId;
		this.postpic = postpic;
		this.userId = userId;
	
	}
	public Post() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getPostId() {
		return postId;
	}
	public void setPostId(int postId) {
		this.postId = postId;
	}
	
	public String getPostpic() {
		return postpic;
	}
	public void setPostpic(String postpic) {
		this.postpic = postpic;
	}
	
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Post [postId=" + postId + ", postpic=" + postpic + ", userId=" + userId + "]";
	}
	
	
	
	

}
