package com.friendbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "likes")
public class Likes {
	@Id
	@Column(name = "id")
	private int id;
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post postId;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User userId;

	public Likes() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Likes(int id, Post postId, User userId) {
		super();
		this.id = id;
		this.postId = postId;
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Post getPostId() {
		return postId;
	}

	public void setPostId(Post postId) {
		this.postId = postId;
	}

	public User getUserId() {
		return userId;
	}

	public void setUserId(User userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Likes [id=" + id + ", postId=" + postId + ", userId=" + userId + "]";
	}

}
