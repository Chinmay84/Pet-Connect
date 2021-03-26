package com.project.dto;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="post")
public class CreatePost {
	
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postid;

	@Column(name = "imagetext")
    private String imagetext;

   	
	@Column(name = "name")
	private String name;
	
	
	@Column(name = "type")
	private String type;
	
	
    //image bytes can have large lengths so we specify a value
    //which is more than the default length for picByte column
	@Column(name = "pic_byte")
	private String picByte;
	
	
	@Column(name = "userName")
	private String userName;
	
	@Column(name = "userEmail")
	private String userEmail;
	
	@Column(name = "createdDate")
	private String createdDate;
	
	
	
	
public 	CreatePost(){
		
	}







public Long getPostid() {
	return postid;
}




public void setPostid(Long postid) {
	this.postid = postid;
}




public String getImagetext() {
	return imagetext;
}




public void setImagetext(String imagetext) {
	this.imagetext = imagetext;
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




public String getPicByte() {
	return picByte;
}




public void setPicByte(String picByte) {
	this.picByte = picByte;
}




public String getUserName() {
	return userName;
}




public void setUserName(String userName) {
	this.userName = userName;
}




public String getUserEmail() {
	return userEmail;
}




public void setUserEmail(String userEmail) {
	this.userEmail = userEmail;
}




public String getCreatedDate() {
	return createdDate;
}




public void setCreatedDate(String createdDate) {
	this.createdDate = createdDate;
}




@Override
public String toString() {
	return "CreatePost [postid=" + postid + ", imagetext=" + imagetext + ", name=" + name + ", type=" + type
			+ ", picByte=" + picByte + ", userName=" + userName + ", userEmail=" + userEmail
			+ ", createdDate=" + createdDate + "]";
}




	
	

}
