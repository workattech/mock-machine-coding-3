package com.soumya.projectManagement;

// Model for the User
public class User {

	private String name, uid, email;

	public User(String name, String uid, String email) {
		this.name = name;
		this.uid = uid;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUid() {
		return uid;
	}
	
}
