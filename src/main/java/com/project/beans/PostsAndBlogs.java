package com.project.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class PostsAndBlogs {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	String name;
	String email;
	
//	@ManyToOne
//	@JoinColumn(name = "userid")
//	User user;
	
	
}
