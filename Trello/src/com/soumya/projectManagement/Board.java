package com.soumya.projectManagement;

import java.util.ArrayList;
import java.util.List;

// Model for Board
public class Board {

	private String name, bid, url;
	private Privacy privacy;
	private List<CList> lists; 
	private List<User> members;
	
	public Board(String name, String bid, String url) {
		this.name = name;
		this.bid = bid;
		this.privacy = Privacy.PUBLIC;
		this.url = url;
		this.lists = new ArrayList<>();
		this.members = new ArrayList<>();;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBid() {
		return bid;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Privacy getPrivacy() {
		return privacy;
	}

	public void setPrivacy(Privacy privacy) {
		this.privacy = privacy;
	}

	public List<CList> getLists() {
		return lists;
	}

	public void setLists(List<CList> lists) {
		this.lists = lists;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}
	
}
