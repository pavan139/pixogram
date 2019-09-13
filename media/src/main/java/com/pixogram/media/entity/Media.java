package com.pixogram.media.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Media {


@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int mediaid;
@Column
private String title;
@Column
private String description;
@Column
private String tags;
@Column
private String type;
@Column
private int userid;

public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}

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

public int getUserid() {
	return userid;
}
public void setUserid(int userid) {
	this.userid = userid;
}
public Media(int userid, String title, String description, String tags,String type) {
	super();
	this.userid=userid;
	this.title = title;
	this.description = description;
	this.tags = tags;
    this.type = type;
}
public Media( String title, String description, String tags,String type) {
	super();
	
	this.title = title;
	this.description = description;
	this.tags = tags;
    this.type = type;
}
public Media() {
	super();
}

	
}
