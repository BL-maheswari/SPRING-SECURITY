package com.bl.basicauthentication.models;

public class User {
	String userName;
	String password;
	String email;

	public User() {
	}

	public User(String password, String userName, String email) {
		this.password = password;
		this.userName = userName;
		this.email = email;
	}

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getEmail() {
		return email;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
