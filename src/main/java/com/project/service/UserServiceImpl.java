package com.project.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.beans.Address;
import com.project.beans.Docter;
import com.project.beans.FosterHome;
import com.project.beans.Role;
import com.project.beans.RoleName;
import com.project.beans.SecurityQuestion;
import com.project.beans.User;
import com.project.dto.SignUpRequest;
import com.project.dto.SignUpRequestForFoster;
import com.project.dto.SignUpResquestForDoc;
import com.project.repository.DocterRepository;
import com.project.repository.FosterRepository;
import com.project.repository.RoleRepository;
import com.project.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	FosterRepository fosterRepository;
	
	@Autowired
	DocterRepository docterRepository;
	
	@Autowired
	UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public void addUser(SignUpRequest signUpRequest) {
		// create new User's account
		User user = new User();
		user.setName(signUpRequest.getName());
		user.setEmail(signUpRequest.getEmail());
		user.setMobileNo(signUpRequest.getMobileNo());
		user.setGender(signUpRequest.getGender());
		user.setAlternativeMobileNo(signUpRequest.getAlernativeMobileNo());
		user.setAnswer(signUpRequest.getAnswer());
		Address address = new Address();
		address.setCity(signUpRequest.getCity());
		address.setState(signUpRequest.getState());
		address.setPincode(signUpRequest.getPincode());
//		address.setAddress(signUpRequest.getAddress());
		
		user.setAddress(address);
		user.setPassword(passwordEncoder
				.encode(signUpRequest.getPassword()));
		List<Role> roles = new ArrayList<>();
		Role userRole = roleRepository.findByRoleName(RoleName.USER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		user.setRoles(roles);
		user.setProfession(signUpRequest.getProfession());
		userRepository.save(user);
	}

	@Override
	public void addAdmin(SignUpRequest signUpRequest) {
		User user = new User();
		user.setName(signUpRequest.getName());
		user.setEmail(signUpRequest.getEmail());
		user.setMobileNo(signUpRequest.getMobileNo());
		user.setGender(signUpRequest.getGender());
		Address address = new Address();
		address.setCity(signUpRequest.getCity());
		address.setState(signUpRequest.getState());
		address.setPincode(signUpRequest.getPincode());
//		address.setAddress(signUpRequest.getAddress());
		user.setAddress(address);
		user.setPassword(passwordEncoder
				.encode(signUpRequest.getPassword()));
		List<Role> roles = new ArrayList<>();
		Role userRole = roleRepository.findByRoleName(RoleName.ADMIN)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		user.setRoles(roles);
		userRepository.save(user);

	}

	@Override
	public void addDoc(SignUpResquestForDoc signUpRequestForDoc) {

		Docter doc = new Docter();
		doc.setName(signUpRequestForDoc.getName());
		doc.setEmail(signUpRequestForDoc.getEmail());
		doc.setMobileNo(signUpRequestForDoc.getMobileNo());
		doc.setGender(signUpRequestForDoc.getGender());
		doc.setProfession(signUpRequestForDoc.getProfession());
		doc.setAnswer(signUpRequestForDoc.getAnswer());
		Address address = new Address();
		address.setCity(signUpRequestForDoc.getCity());
		address.setState(signUpRequestForDoc.getState());
		address.setPincode(signUpRequestForDoc.getPincode());
		doc.setAddress(address);
		doc.setExperience(signUpRequestForDoc.getExperience());
		doc.setOfficeAddress(signUpRequestForDoc.getOfficeAddress());
		doc.setQualification(signUpRequestForDoc.getQualification());
		
		doc.setPassword(passwordEncoder.encode(signUpRequestForDoc.getPassword()));
		List<Role> roles = new ArrayList<>();
		Role userRole = roleRepository.findByRoleName(RoleName.USER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		doc.setRoles(roles);
		
/*
		doc.setExperience(signUpRequestForDoc.getExperience());
		doc.setOfficeAddress(signUpRequestForDoc.getOfficeAddress());
		doc.setQualification(signUpRequestForDoc.getQualification());
		doc.setRating(signUpRequestForDoc.getRating());

		//user.setDoc(doc);
		user.setAddress(address);
		user.setPassword(passwordEncoder.encode(signUpRequestForDoc.getPassword()));
		List<Role> roles = new ArrayList<>();
		Role userRole = roleRepository.findByRoleName(RoleName.USER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		user.setRoles(roles);
		user.setProfession(signUpRequestForDoc.getProfession());
		doc.setUser(user);
*/
		docterRepository.save(doc);
	}

	@Override
	public void addFoster(SignUpRequestForFoster signUpRequestForFoster) {

		FosterHome fhome=new FosterHome();
		fhome.setName(signUpRequestForFoster.getName());
		fhome.setEmail(signUpRequestForFoster.getEmail());
		fhome.setMobileNo(signUpRequestForFoster.getMobileNo());
		fhome.setGender(signUpRequestForFoster.getGender());
		fhome.setAnswer(signUpRequestForFoster.getAnswer());
		
		Address address = new Address();
		address.setCity(signUpRequestForFoster.getCity());
		address.setState(signUpRequestForFoster.getState());
		address.setPincode(signUpRequestForFoster.getPincode());
		fhome.setAddress(address);
		
		fhome.setDescription(signUpRequestForFoster.getDescription());
		fhome.setProfession(signUpRequestForFoster.getProfession());
		
		fhome.setPassword(passwordEncoder
				.encode(signUpRequestForFoster.getPassword()));
		List<Role> roles = new ArrayList<>();
		Role userRole = roleRepository.findByRoleName(RoleName.USER)
				.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
		roles.add(userRole);
		fhome.setRoles(roles);
		
		fosterRepository.save(fhome);
	}

}

