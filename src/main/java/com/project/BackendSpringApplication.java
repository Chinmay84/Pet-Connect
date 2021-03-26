package com.project;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.project.beans.Role;
import com.project.beans.RoleName;
import com.project.repository.RoleRepository;

@SpringBootApplication
//@EntityScan(basePackages = "com.project")
public class BackendSpringApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(BackendSpringApplication.class, args);
	}

	@Autowired
	RoleRepository roleRepository;
	
	@Override
	public void run(String... args) throws Exception {
		if(!roleRepository.findByRoleName(RoleName.ADMIN).isPresent()) {
			roleRepository.save(new Role(RoleName.ADMIN));
		}
		if(!roleRepository.findByRoleName(RoleName.USER).isPresent()) {
			roleRepository.save(new Role(RoleName.USER));
		}

	}

}
