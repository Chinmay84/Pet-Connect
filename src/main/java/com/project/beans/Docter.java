package com.project.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
@PrimaryKeyJoinColumn(name = "userId")
public class Docter extends User{

	
	@NotNull
	float experience;
	int rating;
	@Column(nullable = false)
	String officeAddress;
	@Column(nullable = false)
	String qualification;

/*	@ManyToMany(mappedBy = "dlist")
	List<User> ulist;
*/
	

}
