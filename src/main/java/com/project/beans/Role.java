package com.project.beans;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import lombok.Data;
@Entity
@Data
public class Role {
	@Id
	@GeneratedValue
	private int roleId;
	@Enumerated(EnumType.STRING)
	private RoleName roleName;
//	@ManyToMany(mappedBy ="roles" )
//	private List<User> users;
	
	
	public Role(RoleName roleName) {
		this.roleName=roleName;
	}
	
	public Role() {
		
	}
}
