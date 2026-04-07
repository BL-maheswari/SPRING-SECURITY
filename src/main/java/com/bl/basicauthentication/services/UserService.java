package com.bl.basicauthentication.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bl.basicauthentication.models.User;

@Service
public class UserService {
	// Fake Data until application running
	List<User> list = new ArrayList<>();

	public UserService() {
		list.add(new User("abc", "abc", "abc@gmail.com"));

		list.add(new User("xyz", "xyz", "xyz@gmail.com"));

	}

	// Get All Users
	public List<User> getAllUsers() {
		return this.list;
	}

	// Get Single User
	public User getUser(String userName) {
		return this.list.stream().filter(user -> user.getUserName().equals(userName)).findAny().orElse(null);
	}

	// Add New User
	public User addUser(User user) {
		this.list.add(user);
		return user;
	}
}
