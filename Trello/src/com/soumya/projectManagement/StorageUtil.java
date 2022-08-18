package com.soumya.projectManagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Utility class, holds all the different storage variables
public class StorageUtil {
	
	// Map of users and the Boards they are assigned to
	public Map<String, Map<User, List<Board>>> users;
	
	// Map  of Boards
	public Map<String, Board> boards;
	
	// Map of Lists and the Board they belong to 
	public Map<String, Map<CList, Board>> lists;
	
	// Map of Cards and the List they belong to 
	public Map<String, Map<Card, CList>> cards;
	
	// Counts no. of registered users
	public int userCount;
	
	public StorageUtil() {
		this.userCount = 0;
		this.users = new HashMap<>();
		this.boards = new HashMap<>();
		this.lists = new HashMap<>();
		this.cards = new HashMap<>();
	}
}
