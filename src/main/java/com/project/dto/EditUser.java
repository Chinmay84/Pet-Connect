package com.project.dto;

import lombok.Data;

@Data
public class EditUser {

	private String email;
	private String name;
	private String mobileNo;
	private String gender;
	private String city;
	private String state;
	private long pincode;
	private String profession;
	
}
