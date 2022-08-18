package com.machine.coding;

import java.util.Scanner;

import com.machine.coding.common.UserBase;
import com.machine.coding.model.User;

public class Driver {

	public static void main(String[] args) {
		
		CommandExecutor executor = new CommandExecutor();
		Scanner sc = new Scanner(System.in);
		
		createUserBase();
		
		while (sc.hasNext()) {
			String command = sc.nextLine();
			
			executor.execute(command);
			
		}
	}
	
	private static void createUserBase() {
		// Creating dummy users for now , it can be created using some file or
		// some other ways.
		User user1 = new User("user1", "User1", "User1@gmail.com", "123");
		User user2 = new User("user2", "User2", "User2@gmail.com", "1234");
		User user3 = new User("user3", "User3", "User3@gmail.com", "1235");
		User user4 = new User("user4", "User4", "User4@gmail.com", "123455");
		UserBase.addUser(user1);
		UserBase.addUser(user2);
		UserBase.addUser(user3);
		UserBase.addUser(user4);

	}

}
