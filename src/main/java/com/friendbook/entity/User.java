package com.friendbook.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "uid")
	private int uid;
	@Column(name = "username")
	private String username;
	@Column(name = "email")
	private String email;
	@Column(name = "name")
	private String name;
	@Column(name = "password")
	private String password;
	@Column(name = "profile_pic")
	private String profilePic = "default.jpg";
	@Column(name = "fav_songs")
	private String favSongs;
	@Column(name = "fav_books")
	private String favBooks;
	@Column(name = "fav_places")
	private String favPlaces;

	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public User(int uid, String username, String email, String name, String password, String profilePic,
			String favSongs, String favBooks, String favPlaces) {
		super();
		this.uid = uid;
		
		this.username = username;
		this.email = email;
		this.name = name;
		this.password = password;
		this.profilePic = profilePic;
		this.favSongs = favSongs;
		this.favBooks = favBooks;
		this.favPlaces = favPlaces;
	}


	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public String getFavSongs() {
		return favSongs;
	}
	public void setFavSongs(String favSongs) {
		this.favSongs = favSongs;
	}
	public String getFavBooks() {
		return favBooks;
	}
	public void setFavBooks(String favBooks) {
		this.favBooks = favBooks;
	}
	public String getFavPlaces() {
		return favPlaces;
	}
	public void setFavPlaces(String favPlaces) {
		this.favPlaces = favPlaces;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "User [uid=" + uid + ", username=" + username + ", email=" + email + ", name=" + name + ", password="
				+ password + ", profilePic=" + profilePic + ", favSongs=" + favSongs + ", favBooks=" + favBooks
				+ ", favPlaces=" + favPlaces + "]";
	}

	
	
	
	
	

}
