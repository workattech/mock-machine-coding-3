package com.soumya.projectManagement;

import java.util.UUID;

// Core Functions related to Board Management
public class BoardManager {
	
	// Checks whether BID is valid or not
	public static boolean isValid(String bid, StorageUtil store) {
		return store.boards.containsKey(bid);
	}
	
	// Creates new Board with given name
	public static String createBoard(String name, StorageUtil store) {
		String bid = UUID.randomUUID().toString().replace("-","");
		String url = "/boards/"+bid;
		store.boards.put(bid, new Board(name, bid, url));
		return bid;
	}
	
	// Deletes Board with given BID
	public static void deleteBoard(String bid, StorageUtil store) {
		Board board = store.boards.get(bid);
		for(CList list : board.getLists()) {
			for(Card card : list.getCards())
				store.cards.remove(card.getCid());
			store.lists.remove(list.getLid());
		}
		store.boards.remove(bid);
	}
	
	// Updates Board property
	public static void updateBoard(String bid, String name, String privacy, StorageUtil store) {
		Board board = store.boards.get(bid);
		if(name!=null)
			board.setName(name);
		if(privacy!=null)
			switch(privacy.toUpperCase()) {
			case "PUBLIC":
				board.setPrivacy(Privacy.PUBLIC);
				break;
			case "PRIVATE":
				board.setPrivacy(Privacy.PRIVATE);
				break;
			default:
				System.out.println("ERROR: Wrong Privacy Specification !");
			}
	}
	
	// Add Members to a Board
	public static void addMember(String bid, String uid, StorageUtil store) {
		Board board = store.boards.get(bid);
		User user = (User) store.users.get(uid).keySet().toArray()[0];
		store.users.get(uid).get(user).add(board);
		board.getMembers().add(user);
	}
	
	// Removes Member form a Board
	public static void removeMember(String bid, String uid, StorageUtil store) {
		Board board = store.boards.get(bid);
		User user = (User) store.users.get(uid).keySet().toArray()[0];
		store.users.get(uid).get(user).remove(board);
		board.getMembers().remove(user);
	}
	
	// Displays Particular Board with all sub details
	public static void showBoard(String bid, Board board, StorageUtil store) {
		board = board==null?store.boards.get(bid):board;
		System.out.println("BID : "+bid);
		System.out.println("BOARD NAME : "+board.getName());
		if(board.getPrivacy()==Privacy.PRIVATE)
			System.out.println("BOARD PRIVACY : PRIVATE");
		else
			System.out.println("BOARD PRIVACY : PUBLIC");
		System.out.println("BOARD MEMEBERS :");
		if(board.getMembers().size()>0)
			for(User usr : board.getMembers())
				System.out.println("UID :"+usr.getUid()+" Name : "+usr.getName()+" Email : "+usr.getEmail());
		else
			System.out.println("N/A");
		System.out.println("BOARD LISTS :");
		if(board.getLists().size()>0)
			for(CList list : board.getLists())
				ListManager.showList(list.getLid(),list,store);
		else
			System.out.println("N/A");
		System.out.println();
	}
}
