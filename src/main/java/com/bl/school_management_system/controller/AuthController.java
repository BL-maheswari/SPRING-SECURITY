package com.bl.school_management_system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

	@PostMapping("/login")
	public String login() {
		return "JWT Token Generated";
	}

	@PostMapping("/register")
	public String register() {
		return "User Registered";
	}

}
