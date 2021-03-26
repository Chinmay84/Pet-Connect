package com.project.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.beans.Address;
import com.project.beans.SecurityQuestion;
import com.project.beans.User;
import com.project.dto.EditUser;
import com.project.dto.ForgotPassword;
import com.project.dto.SecurityQuestionData;
import com.project.repository.SecurityQuestionRepository;
import com.project.repository.UserRepository;

@Service
public class UserCRUDServiceImpl implements UserCRUDService{
	
	
	
	@Autowired
	UserRepository userRepository; 
	
	@Autowired
	SecurityQuestionRepository securityQuestionRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	
	User user = new User();

/*
	@Override
	public int updateUser(User user,User u) {
		
		// TODO Auto-generated method stub
		u.setMobileNo(user.getMobileNo());
		u.setName(user.getName());
		
		return userRepository.save(u).getUserId();
	}
*/
	
	

	@Override
	public void deleteUser(User user) {
		
		userRepository.delete(user);
	}




	@Override
	public void updateUser(User user) {

		User u=userRepository.findUserforDelete(user.getEmail());
		u.setEmail(user.getEmail());
		u.setGender(user.getGender());
		u.setMobileNo(user.getMobileNo());
		u.setName(user.getName());
		u.setPassword(user.getPassword());
		u.setProfession(user.getProfession());
		u.setAlternativeMobileNo(user.getAlternativeMobileNo());
//		System.out.println("address is "+user.getAddress());
		Address oldaddr=u.getAddress();
		oldaddr.setCity(user.getAddress().getCity());
		oldaddr.setPincode(user.getAddress().getPincode());
		oldaddr.setState(user.getAddress().getState());
//		u.setAddress(oldaddr);
		userRepository.save(u);
	}
	
	
	



	@Override
	public String forgotPassword(ForgotPassword forgotPassword) {
		Optional<User> user=userRepository.findByEmail(forgotPassword.getEmail());
		if(user.get().getAnswer().equals(forgotPassword.getAnswer()))
		{
			System.out.println("In if");
			user.get().setPassword(passwordEncoder.encode(forgotPassword.getPassword()));
			userRepository.save(user.get());
			return "password updated successfully";
		}
		return "Not matched";
	}




	@Override
	public void update(EditUser editUser) {
		
		
		User user=userRepository.findUserforDelete(editUser.getEmail());
		user.setName(editUser.getName());
		user.setMobileNo(editUser.getMobileNo());
		user.setGender(editUser.getGender());
		user.setProfession(editUser.getProfession());
		
		Address address=user.getAddress();
		address.setCity(editUser.getCity());
		address.setState(editUser.getState());
		address.setPincode(editUser.getPincode());
		
		user.setAddress(address);
		userRepository.save(user);
		
		
	}


/*
	@Override
	public String forgotPassword(ForgotPassword forgotPassword) {
	Optional<User> user=userRepository.findByEmail(forgotPassword.getEmailid());
	
	//userRepository.save(null)	
		
	/*		Optional<User> userData=userRepository.findById(id);
			Optional<SecurityQuestion> sec=securityQuestionRepository.findById(id);
			String newAnswer = sec.get().getAnswer();
			if(newAnswer.equals(data.getAnswer()))
			{
				userData.get().setPassword(data.getPassword());
				userRepository.save(userData.get());
				return "password updated successully";
			}else {
				return "invalid credential";
			}
		
	}
	*/
	
}
