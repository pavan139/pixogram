package com.pixogram.media.entity;

import javax.persistence.Column;

public class NewMedia {
	
	
	private String title;

	private String description;

	private String tags;

	private String type;

	private int userid;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public NewMedia(String title, String description, String tags, String type, int userid) {
		super();
		this.title = title;
		this.description = description;
		this.tags = tags;
		this.type = type;
		this.userid = userid;
	}
	
	
	
}
