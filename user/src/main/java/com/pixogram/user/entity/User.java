package com.pixogram.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column
	private String email;
	@Column
	private String password;
	@Column
	private String username;
	@Column
	private String profilepicture;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public User(String email, String username, String password,String profilepicture) {
		super();
		this.email = email;
		this.password = password;
		this.username = username;
		this.profilepicture= profilepicture;
	}
	public User(String email, String username, String password) {
		super();
		this.email = email;
		this.password = password;
		this.username = username;
		
	}
	public User() {
		super();
	}
	
	
	
}
