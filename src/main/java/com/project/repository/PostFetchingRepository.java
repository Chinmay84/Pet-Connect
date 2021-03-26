package com.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.project.dto.CreatePost;

@Repository
public interface PostFetchingRepository extends JpaRepository<CreatePost, Long> {
	
	@Query("select t from CreatePost t ")
	public List<CreatePost> getallPost();
	

}
