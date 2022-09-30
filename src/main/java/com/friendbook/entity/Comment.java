package com.friendbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "comment")
public class Comment {
	@Id
	@Column(name = "id")
	private int id;
	@ManyToOne
	@JoinColumn(name = "post_id")
	private Post postId;
	@Column(name = "post_comment")
	private String postComment;
	@OneToOne
	@JoinColumn(name = "user_id")
	private User userId;
	public Comment(int id, Post postId, String postComment, User userId) {
		super();
		this.id = id;
		this.postId = postId;
		this.postComment = postComment;
		this.userId = userId;
	}
	public Comment() {
		super();
		// TODO Auto-generated constructor stub
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
	public String getPostComment() {
		return postComment;
	}
	public void setPostComment(String postComment) {
		this.postComment = postComment;
	}
	public User getUserId() {
		return userId;
	}
	public void setUserId(User userId) {
		this.userId = userId;
	}
	@Override
	public String toString() {
		return "Comment [id=" + id + ", postId=" + postId + ", postComment=" + postComment + ", userId=" + userId + "]";
	}
	
	

	
	
	
	
}
