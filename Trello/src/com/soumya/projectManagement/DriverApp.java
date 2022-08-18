package com.soumya.projectManagement;

import java.util.Scanner;

// Main Driver Class
public class DriverApp {

	public static void main(String[] args) {
		
		// Initialize ProjectManager instance
		ProjectManager pm = new ProjectManager();
		
		// Hard coded registered users
		pm.registerUser("User1", "user1@hello.com");
		pm.registerUser("User2", "user2@hello.com");
		pm.registerUser("User3", "user3@hello.com");
		
		// Display details of registered users with their UID
		pm.showAllUsers();
		
		// User Command Input
		Scanner sc=new Scanner(System.in);
		while(true) {
			// Execute Command
			pm.handleRequest(sc.nextLine());
		}
	}
}
