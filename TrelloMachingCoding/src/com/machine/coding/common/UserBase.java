package com.machine.coding.common;

import java.util.HashMap;
import java.util.Map;

import com.machine.coding.model.User;

public class UserBase {

	static Map<String, User> userMap = new HashMap<String, User>();

	public static User getUser(String userId) {
		return userMap.get(userId);
	}
	
	public static void addUser(User user) {
		userMap.put(user.getUserId(), user);
	}
}
