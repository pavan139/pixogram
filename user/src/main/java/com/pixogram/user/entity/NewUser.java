package com.pixogram.user.entity;

import javax.persistence.Column;

public class NewUser {


	private String email;

	private String password;

	private String username;

	private String profilepicture;

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

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getProfilepicture() {
		return profilepicture;
	}

	public void setProfilepicture(String profilepicture) {
		this.profilepicture = profilepicture;
	}

	public NewUser(String email, String password, String username, String profilepicture) {
		super();
		this.email = email;
		this.password = password;
		this.username = username;
		this.profilepicture = profilepicture;
	}
	
	
}
