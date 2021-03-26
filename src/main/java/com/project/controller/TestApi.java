package com.project.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TestApi {
	@GetMapping("/all")
	public String allAccess() {
		return "public content.";
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return "user Content.";
	}
	
/*	
	@GetMapping("/supervisor")
	@PreAuthorize("hasRole('DISTR_SUPERVISOR')")
	public String moderatorAccess() {
		return "Moderator Board";
	}
*/
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return "Admin Board";
	}
/*	
	@GetMapping("/manager")
	@PreAuthorize("hasRole('ADMIN')")
	public String managerAccess() {
		return "Admin Board";
	}
*/
}
