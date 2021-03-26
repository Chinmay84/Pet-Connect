package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.beans.User;


@Repository
public interface SearchByNameRepository extends JpaRepository<User, Integer>{

	@Query("SELECT u FROM User u WHERE u.name IN :name")
	List<User> SearchUserName(@Param("name") String name);
	
	@Query("SELECT u FROM User u WHERE u.name IN :address")
	List<User> SearchUserByAddress(@Param("address") String address);
	
}
