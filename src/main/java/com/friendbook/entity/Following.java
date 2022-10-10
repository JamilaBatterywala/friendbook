package com.friendbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "following")
public class Following {
	@Id
	@Column(name = "id")
	private int id;
	@Column(name = "user_id")
	private int useridfollowing;
	@OneToOne
	@JoinColumn(name = "following_id")
	private User followingid;

	public Following(int id, int useridfollowing, User followingid) {
		super();
		this.id = id;
		this.useridfollowing = useridfollowing;
		this.followingid = followingid;
	}

	public Following() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUseridfollowing() {
		return useridfollowing;
	}

	public void setUseridfollowing(int useridfollowing) {
		this.useridfollowing = useridfollowing;
	}

	public User getFollowingid() {
		return followingid;
	}

	public void setFollowingid(User followingid) {
		this.followingid = followingid;
	}

	@Override
	public String toString() {
		return "Following [id=" + id + ", useridfollowing=" + useridfollowing + ", followingid=" + followingid + "]";
	}

}
