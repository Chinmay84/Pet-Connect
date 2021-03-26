package com.project.beans;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Data
//@Table(name = "Foster")
@PrimaryKeyJoinColumn(name = "userId")
public class FosterHome extends User{
	
	
	
	
	String description;
/*	
	@OneToOne
	@JoinColumn(name = "userid")
	User user;
*/	
	
}
