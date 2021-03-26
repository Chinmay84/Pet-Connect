package com.project.service;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.beans.User;
import com.project.dto.EditUser;
import com.project.dto.ForgotPassword;
import com.project.dto.SecurityQuestionData;


public interface UserCRUDService {

	
	void deleteUser(User user);
	
	void update(EditUser editUser);
	
	void updateUser(User user);

	String forgotPassword(ForgotPassword forgotPassword);
	
}
