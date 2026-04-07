package com.bl.basicauthentication.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bl.basicauthentication.models.User;
import com.bl.basicauthentication.services.UserService;

@RestController
@RequestMapping("/secure/users")
public class UserController {
	@Autowired
	private UserService userService;

	// All users
	@GetMapping("/")
	public List<User> getAllUsers() {
		return this.userService.getAllUsers();
	}

	// Single User
	@GetMapping("/{userName}")
	public User getUser(@PathVariable String userName) {
		return this.userService.getUser(userName);
	}

	// Add User
	@PostMapping("/")
	public User addUser(@RequestBody User user) {
		return this.userService.addUser(user);
	}
}
