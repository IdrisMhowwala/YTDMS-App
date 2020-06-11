package com.yash.ytdms.domain;

public class User {

	String name;
	int id;
	String email;
	int role;

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getGroupDropDown() {
		return groupDropDown;
	}

	public void setGroupDropDown(int groupDropDown) {
		this.groupDropDown = groupDropDown;
	}

	private int groupDropDown;

}
