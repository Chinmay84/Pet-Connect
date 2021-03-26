package com.project.service;

import com.project.dto.SignUpRequest;
import com.project.dto.SignUpRequestForFoster;
import com.project.dto.SignUpResquestForDoc;

public interface UserService {

	void addUser(SignUpRequest signUpRequest);

	void addAdmin(SignUpRequest signUpRequest);
	
	void addDoc(SignUpResquestForDoc signUpRequestForDoc);
	
	void addFoster(SignUpRequestForFoster signUpRequestForFoster);

}
