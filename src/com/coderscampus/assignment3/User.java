package com.coderscampus.assignment3;

public class User {

	// Instance Variables
	private String username;
	private String password;
	private String name;

	public User(String[] userStringArray) {
		this.setUsername(userStringArray[0]);
		this.setPassword(userStringArray[1]);
		this.setName(userStringArray[2]);
	}

	// Getters and Setters
	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}
}
