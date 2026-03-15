package com.bl.school_management_system.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {

	@GetMapping("/dashboard")
	public String adminDashboard() {
		return "Admin managing the entire school system";
	}

	@GetMapping("/users")
	public String manageUsers() {
		return "Admin managing users";
	}
}
