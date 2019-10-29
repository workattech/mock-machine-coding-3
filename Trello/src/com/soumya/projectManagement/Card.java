package com.soumya.projectManagement;

// Model for Card
public class Card {
	
	private String cid, name, description;
	private User assgndUser;
	
	public Card(String cid, String name, String description) {
		this.cid = cid;
		this.name = name;
		this.description = description;
		this.assgndUser = null;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public User getAssgndUser() {
		return assgndUser;
	}

	public void setAssgndUser(User assgndUser) {
		this.assgndUser = assgndUser;
	}

	public String getCid() {
		return cid;
	}
}
