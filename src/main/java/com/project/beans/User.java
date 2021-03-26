package com.project.beans;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

	@Id
	@GeneratedValue
	private int userId;
	/*
	 * @NotNull
	 * 
	 * @Size(min = 2, message = "First name must be grater than two charecter")
	 * 
	 * @Size(max = 20, message = "First name must be less than twenty charector")
	 * 
	 * @Pattern(regexp = "^[A-Z].[a-z]{2,20}$", message =
	 * "only charectors are allowed")
	 */
	private String name;

	//@NotNull
	/*
	 * @Size(min = 2, message = "Last name must be grater than two charector")
	 * 
	 * @Size(max = 20, message = "Last name must be less than twenty charector")
	 * 
	 * @Pattern(regexp = "^[A-Z].[a-z] {2,20}$", message =
	 * "only charectors are allowed")
	 */

	/*
	 * @NotNull
	 * 
	 * @Size(max = 10, message = "Mobile no should be 10 character")
	 */
	@Column(nullable = false)
	private String mobileNo;
	
	private String alternativeMobileNo;

	
	private String gender;
	
	private String profession;

	/*
	 * @NotNull
	 * 
	 * @Email(message = "Please enter valid email")
	 */
	@Column(nullable = false,unique = true)
	private String email;
	/*
	 * @NotNull
	 * 
	 * @Pattern(regexp =
	 * "^(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[@#$%^&-+=()])(?=\\\\S+$).{8,20}$",
	 * message = "Minimum eight characters, at least one letter and one number")
	 */
	@Column(nullable = false,unique = true)
	private String password;
	
	

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn
	private Address address;
	
//	private String role;

	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "user_roles",
	joinColumns = @JoinColumn(name = "user_id"),
	inverseJoinColumns = @JoinColumn(name = "role_id"))
	private List<Role> roles = new ArrayList<>();
	
	
/*	
	@ManyToMany
	@JoinTable(name = "user_doctor",joinColumns = {@JoinColumn(name="fk_userid")},inverseJoinColumns = {@JoinColumn(name="fk_docid")})
	List<Docter> dlist;
*/

/*	
	@OneToOne(mappedBy = "user")
	Docter doc;
*/	
	
//	@OneToOne(cascade = CascadeType.ALL)
//	SecurityQuestion securityQuestion; 

	
	
	
	
	@OneToMany
	List<PostsAndBlogs> postsAndBlogs=new ArrayList();

	
	private String answer;
	
	
/*	public User(int userId, String name, String mobileNo, String alternativeMobileNo, String gender, String email,
			String password) {
		super();
		this.userId = userId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.alternativeMobileNo = alternativeMobileNo;
		this.gender = gender;
		this.email = email;
		this.password = password;
	}
*/
	
	public User()
	{
		
	}

	public User(int userId, String name, String mobileNo, String alternativeMobileNo, String gender, String email,
			String password, List<Role> roles /*List<PostsAndBlogs> postsAndBlogs,*/
			) {
									/* (insert above List<Docter> dlist )  */
		this.userId = userId;
		this.name = name;
		this.mobileNo = mobileNo;
		this.alternativeMobileNo = alternativeMobileNo;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.roles=roles;
//		this.fosterHome=fosterHome;
//		this.postsAndBlogs=postsAndBlogs;
//		this.securityQuestion=securityQuestion;
//		this.dlist=dlist;
//		this.doc=doc;
	}
	
	
/*	Not null	Email
	Unique+not
	null	Address
	Not null	Pincode
	Not null	Phone
	Not null+unique	Alter native phone number	Gender
	Not null	Password
	Not null	Docore	Froster	user	Registration
	Date/FS
	Not null
*/

	
}
