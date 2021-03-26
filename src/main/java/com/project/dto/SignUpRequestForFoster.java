package com.project.dto;

import lombok.Data;

@Data
public class SignUpRequestForFoster {
	private String name;
	private String mobileNo;
	private String alernativeMobileNo;
	private String email;
	private String gender;
	private String password;
	private String city;
	private String state;
//	private String address;
	private long pincode;
	private String profession;
	private String description;
	private String answer;
}
