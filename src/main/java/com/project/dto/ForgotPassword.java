package com.project.dto;

public class ForgotPassword {

	public String email;
	public String password;
	public String answer;
	
	public  ForgotPassword() {
		
	}

	public String getEmail() {
		return email;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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

	@Override
	public String toString() {
		return "ForgotPassword [emailid=" + email + ", password=" + password + "]";
	}
	
}
