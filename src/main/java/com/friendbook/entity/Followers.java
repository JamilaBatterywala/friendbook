package com.friendbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "followers")
public class Followers {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "user_id")
	private int userid;
	@OneToOne
	@JoinColumn(name = "follower_id")
	private User followerid;

	public Followers() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Followers(int id, int userid, User followerid) {
		super();
		this.id = id;
		this.userid = userid;
		this.followerid = followerid;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public User getFollowerid() {
		return followerid;
	}

	public void setFollowerid(User followerid) {
		this.followerid = followerid;
	}

	@Override
	public String toString() {
		return "Followers [id=" + id + ", userid=" + userid + ", followerid=" + followerid + "]";
	}

}
