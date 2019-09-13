package com.pixogram.media.controller;

/*import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;*/

import javax.persistence.*;

@Entity
@Table(name="image_model")
/*
 * @AllArgsConstructor
 * 
 * @Data
 * 
 * @NoArgsConstructor
 * 
 * @ToString
 */
public class ImageModel {
    @Id
    @Column(name = "id")
    @GeneratedValue
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;
    @Column(name = "username")
    private String username;



public ImageModel() {
		super();
	}



public Long getId() {
	return id;
}



public void setId(Long id) {
	this.id = id;
}



public String getName() {
	return name;
}



public void setName(String name) {
	this.name = name;
}



public String getType() {
	return type;
}



public void setType(String type) {
	this.type = type;
}



public String getUsername() {
	return username;
}



public void setUsername(String username) {
	this.username = username;
}



public ImageModel(String name, String type, String username) {
	super();
	this.name = name;
	this.type = type;
	this.username = username;
}


}