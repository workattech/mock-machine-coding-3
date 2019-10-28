package com.soumya.projectManagement;

import java.util.Scanner;

public class DriverApp {

	public static void main(String[] args) {
		ProjectManager pm = new ProjectManager();
		pm.registerUser("User1", "user1@hello.com");
		pm.registerUser("User2", "user2@hello.com");
		pm.registerUser("User3", "user3@hello.com");
		pm.showAllUsers();
		Scanner sc=new Scanner(System.in);
		while(true) {
			pm.handleRequest(sc.nextLine());
		}
	}
}
