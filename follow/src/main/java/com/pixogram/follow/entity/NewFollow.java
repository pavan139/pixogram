package com.pixogram.follow.entity;

import javax.persistence.Column;

public class NewFollow {
	private int followid;

	private int followerid;

	private String status;

	public int getFollowid() {
		return followid;
	}

	public void setFollowid(int followid) {
		this.followid = followid;
	}

	public int getFollowerid() {
		return followerid;
	}

	public void setFollowerid(int followerid) {
		this.followerid = followerid;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public NewFollow(int followid, int followerid, String status) {
		super();
		this.followid = followid;
		this.followerid = followerid;
		this.status = status;
	}
	
	
	
}
