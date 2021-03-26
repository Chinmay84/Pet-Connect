package com.project.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.project.beans.User;
import com.project.dto.EditUser;

public interface UserRepository extends JpaRepository<User, Integer>{

	Optional<User> findByEmail(String email);
	
	@Query("SELECT u from User u WHERE u.email = ?1")
	User findUserforDelete(String email);
	
	@Query("SELECT u from User u WHERE u.profession LIKE %:profession%")
	List<User> getallDoctorAndFosterList(@Param("profession") String profession);
	
	@Query("SELECT u from User u WHERE u.email = ?1")
	User getUserByMailId(String emailId);
	
	@Query("SELECT u from User u WHERE u.email LIKE %:email%")
	User getUserforMailId(@Param("email") String email);
	
	    @Modifying
	    @Query("UPDATE User c SET c.password = :newpassword WHERE c.email = :emailid")
	    Integer updatePassword(@Param("emailid") String emailid, @Param("newpassword") String newpassword);
}
