package com.soumya.projectManagement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// Orchestrates all the different functionalities [ Board, List, Card, User ]
public class ProjectManager {
	
	// Stores all the instance data related to users, boards, cards, lists
	private StorageUtil store;
	
	public ProjectManager() {
		store = new StorageUtil();
	}
	
	// Register new User
	public void registerUser(String name, String email) {
		++store.userCount;
		String uid = "user"+store.userCount;
		store.users.put(uid, new HashMap<User, List<Board>>());
		store.users.get(uid).put(new User(name, uid, email), new ArrayList<>());
	}
	
	// Display all Registered Users
	public void showAllUsers() {
		System.out.println("ALL USERS : ");
		for(Map<User,List<Board>> users : store.users.values()) {
			User usr = (User) users.keySet().toArray()[0];
			System.out.println("UID :"+usr.getUid()+" Name : "+usr.getName()+" Email : "+usr.getEmail());
		}
	}
	
	//Display all the Boards and their details
	private void showAll() {
		if(store.boards.size()==0) {
			System.out.println("No Boards");
			return;
		}
		for(Board board : store.boards.values())
			BoardManager.showBoard(board.getBid(), board, store);
	}

	// Parses the Input, validates the data and calls required functions
	public void handleRequest(String request) {
		String req[] = request.split(" ");
		switch(req[0].toUpperCase()) {
			case "BOARD":
				switch(req[1].toUpperCase()) {
					case "CREATE":
						String name=request.substring(request.indexOf(" ", request.indexOf(req[1]))+1);
						System.out.println("Created Board: "+BoardManager.createBoard(name, store));
						break;
					case "DELETE":
						if(!BoardManager.isValid(req[2], store)) {
							System.out.println("ERROR: BOARD - "+req[2]+" DOESN'T EXIST");
							return;
						}
						BoardManager.deleteBoard(req[2], store);
						break;
					default:
						if(!BoardManager.isValid(req[1], store)) {
							System.out.println("ERROR: BOARD - "+req[1]+" DOESN'T EXIST");
							return;
						}
						switch(req[2].toUpperCase()) {
							case "NAME":
								name=request.substring(request.indexOf(" ", request.indexOf(req[2]))+1);
								BoardManager.updateBoard(req[1], name, null,store);
								break;
							case "PRIVACY":
								name=request.substring(request.indexOf(" ", request.indexOf(req[2]))+1);
								BoardManager.updateBoard(req[1], null, name,store);
								break;
							case "ADD_MEMBER":
								name=request.substring(request.indexOf(" ", request.indexOf(req[2]))+1);
								BoardManager.addMember(req[1], name, store);
								break;
							case "REMOVE_MEMBER":
								name=request.substring(request.indexOf(" ", request.indexOf(req[2]))+1);
								BoardManager.removeMember(req[1], name, store);
								break;
							default:
								System.out.println("ERROR: MALFORMED INPUT");
						}
				}
				break;
			case "LIST":
				switch(req[1].toUpperCase()) {
				case "CREATE":
					if(!BoardManager.isValid(req[2], store)) {
						System.out.println("ERROR: BOARD - "+req[2]+" DOESN'T EXIST");
						return;
					}
					String name=request.substring(request.indexOf(" ", request.indexOf(req[2]))+1);
					System.out.println("Created List: "+ListManager.createList(req[2], name, store));
					break;
				case "DELETE":
					if(!ListManager.isValid(req[2], store)) {
						System.out.println("ERROR: LIST - "+req[1]+" DOESN'T EXIST");
						return;
					}
					ListManager.deleteList(req[2], store);
					break;
				default:
					if(!ListManager.isValid(req[1], store)) {
						System.out.println("ERROR: LIST - "+req[1]+" DOESN'T EXIST");
						return;
					}
					switch(req[2].toUpperCase()) {
					case "NAME":
						name=request.substring(request.indexOf(" ", request.indexOf(req[2]))+1);
						ListManager.updateList(req[1], name, store);
						break;
					default:
						System.out.println("ERROR: MALFORMED INPUT");
					}
				}
				break;
			case "CARD":
				switch(req[1].toUpperCase()) {
				case "CREATE":
					if(!ListManager.isValid(req[2], store)) {
						System.out.println("ERROR: LIST - "+req[1]+" DOESN'T EXIST");
						return;
					}
					String name=request.substring(request.indexOf(" ", request.indexOf(req[2]))+1);
					System.out.println("Created Card: "+CardManager.createCard(req[2],name,store));
					break;
				case "DELETE":
					if(!CardManager.isValid(req[2], store)) {
						System.out.println("ERROR: CARD - "+req[2]+" DOESN'T EXIST");
						return;
					}
					CardManager.deleteCard(req[2], store);
					break;
				default:
					if(!CardManager.isValid(req[1], store)) {
						System.out.println("ERROR: CARD - "+req[1]+" DOESN'T EXIST");
						return;
					}
					switch(req[2].toUpperCase()) {
						case "NAME":
							name=request.substring(request.indexOf(" ", request.indexOf(req[2]))+1);
							CardManager.updateCard(req[1], name, null,store);
							break;
						case "DESCRIPTION":
							name=request.substring(request.indexOf(" ", request.indexOf(req[2]))+1);
							CardManager.updateCard(req[1], null, name,store);
							break;
						case "ASSIGN":
							name=request.substring(request.indexOf(" ", request.indexOf(req[2]))+1);
							CardManager.assignToCard(req[1], name, store);
							break;
						case "UNASSIGN":
							CardManager.unassignToCard(req[1], store);
							break;
						case "MOVE":
							if(!ListManager.isValid(req[3], store)) {
								System.out.println("ERROR: LIST - "+req[1]+" DOESN'T EXIST");
								return;
							}
							CardManager.moveCard(req[1], req[3], store);
							break;
						default:
							System.out.println("ERROR: MALFORMED INPUT");
					}
			}
			break;
			case "SHOW":
				if(req.length==1)
					showAll();
				else
					switch(req[1].toUpperCase()) {
						case "BOARD":
							if(!BoardManager.isValid(req[2], store)) {
								System.out.println("ERROR: BOARD - "+req[2]+" DOESN'T EXIST");
								return;
							}
							BoardManager.showBoard(req[2], null, store);
							break;
						case "LIST":
							if(!ListManager.isValid(req[2], store)) {
								System.out.println("ERROR: LIST - "+req[1]+" DOESN'T EXIST");
								return;
							}
							ListManager.showList(req[2], null, store);
							break;
						case "CARD":
							if(!CardManager.isValid(req[2], store)) {
								System.out.println("ERROR: LIST - "+req[1]+" DOESN'T EXIST");
								return;
							}
							CardManager.showCard(req[2], null, store);
							break;
						default:
							System.out.println("ERROR: MALFORMED INPUT");
					}
				break;
			default:
				System.out.println("ERROR: MALFORMED INPUT");
		}
	}
}