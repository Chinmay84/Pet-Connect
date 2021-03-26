package com.project.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	@Id
	@GeneratedValue
	private int locationId;
//	private String address;
	private String state;
	private String city;
	private long pincode;
//	@OneToMany(mappedBy="address",cascade=CascadeType.ALL)
//	private List<User> users=new ArrayList<>();
}
