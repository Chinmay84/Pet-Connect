package com.project.configuration;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.beans.RoleName;
import com.project.beans.User;
import com.project.dto.SignUpRequest;

public class CustomUserDetails extends User implements UserDetails {

	@Autowired
	SignUpRequest signUpRequest; 
	
	private static final long serialVersionUID = 8141109612300493862L;
	public CustomUserDetails(final User user) {
		super(
				
				user.getUserId(),
				user.getName(),
				user.getMobileNo(),
				user.getAlternativeMobileNo(),
				user.getGender(),
				user.getEmail(),
				user.getPassword(),
				user.getRoles()
//				user.getFosterHome(),
//				user.getPostsAndBlogs(),
//				user.getSecurityQuestion()
//				user.getDlist()
//				user.getDoc()
			);
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		
		return super.getRoles()
						.stream()
						.map(role -> new SimpleGrantedAuthority("ROLE_"+role.getRoleName()))
						.collect(Collectors.toList());
	}


	@Override
	public String getPassword() {
		return super.getPassword();
	}

	@Override
	public String getUsername() {
		return super.getEmail();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	

}
