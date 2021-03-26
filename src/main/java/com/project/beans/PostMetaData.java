package com.project.beans;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostMetaData {
	
	private String userName;
	
	private String userEmail;
	
	private String createdDate;
	
	
	private String imagemessage;
	
	
	public PostMetaData() {
		
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


	public String getImagemessage() {
		return imagemessage;
	}


	public void setImagemessage(String imagemessage) {
		this.imagemessage = imagemessage;
	}


	@Override
	public String toString() {
		return "PostMetaData [userName=" + userName + ", userEmail=" + userEmail + ", createdDate=" + createdDate
				+ ", imagemessage=" + imagemessage + "]";
	}

		
}
