package com.soumya.projectManagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageUtil {
	public Map<String, Map<User, List<Board>>> users;
	public Map<String, Board> boards;
	public Map<String, Map<CList, Board>> lists;
	public Map<String, Map<Card, CList>> cards;
	public int userCount;
	
	public StorageUtil() {
		this.userCount = 0;
		this.users = new HashMap<>();
		this.boards = new HashMap<>();
		this.lists = new HashMap<>();
		this.cards = new HashMap<>();
	}
}
