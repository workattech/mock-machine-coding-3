package com.soumya.projectManagement;

import java.util.HashMap;
import java.util.UUID;

//Core Functions related to Card Management
public class CardManager {

	// Checks whether CID is valid or not
	public static boolean isValid(String cid, StorageUtil store) {
		return store.cards.containsKey(cid);
	}
	
	// Creates new Card with given name in specified List
	public static String createCard(String lid, String name, StorageUtil store) {
		String cid = UUID.randomUUID().toString().replace("-","");
		CList list = (CList) store.lists.get(lid).keySet().toArray()[0];
		Card card = new Card(cid, name, "");
		list.getCards().add(card);
		store.cards.put(cid, new HashMap<Card, CList>());
		store.cards.get(cid).put(card, list);
		return cid;
	}
	
	// Deletes Card with given CID
	public static void deleteCard(String cid, StorageUtil store) {
		CList list = (CList) store.cards.get(cid).values().toArray()[0];
		Card card = (Card) store.cards.get(cid).keySet().toArray()[0];
		store.cards.remove(cid);
		list.getCards().remove(card);
	}
	
	// Updates Card properties
	public static void updateCard(String cid, String name, String description, StorageUtil store) {
		Card card = (Card) store.cards.get(cid).keySet().toArray()[0];
		if(name!=null)
			card.setName(name);
		if(description!=null)
			card.setDescription(description);
	}

	// Assigns Member to a Card
	public static void assignToCard(String cid, String uid, StorageUtil store) {
		User user = (User) store.users.get(uid).keySet().toArray()[0];
		CList list = (CList) store.cards.get(cid).values().toArray()[0];
		Card card = (Card) store.cards.get(cid).keySet().toArray()[0];
		Board board = (Board) store.lists.get(list.getLid()).values().toArray()[0];
		if(board.getMembers().contains(user))
			card.setAssgndUser(user);
		else
			System.out.println("ERROR: USER DOESN'T BELONG TO CONTAINER BOARD - NAME: "+board.getName()+", BID: "+board.getBid());
	}
	
	// Unassigns Member from a Card
	public static void unassignToCard(String cid, StorageUtil store) {
		Card card = (Card) store.cards.get(cid).keySet().toArray()[0];
		card.setAssgndUser(null);
	}
	
	// Moves Card to another List
	public static void moveCard(String cid, String lid, StorageUtil store) {
		CList newlist = (CList) store.lists.get(lid).keySet().toArray()[0];
		CList oldlist = (CList) store.cards.get(cid).values().toArray()[0];
		Board board = (Board) store.lists.get(lid).values().toArray()[0];
		if(!board.getLists().contains(oldlist)) {
			System.out.println("ERROR: LIST : "+lid+" IS NOT IN THE SAME BOARD AS CARD : "+cid);
			return;
		}
		Card card = (Card) store.cards.get(cid).keySet().toArray()[0];
		oldlist.getCards().remove(card);
		newlist.getCards().add(card);
		store.cards.get(cid).put(card, newlist);
	}
	
	// Displays details of Card
	public static void showCard(String cid, Card card, StorageUtil store) {
		card = card==null?(Card) store.cards.get(cid).keySet().toArray()[0]:card;
		System.out.println("CID : "+cid);
		System.out.println("CARD NAME : "+card.getName());
		if(!card.getDescription().isEmpty())
			System.out.println("CARD DESCRIPTION : "+card.getDescription());
		else
			System.out.println("CARD DESCRIPTION : N/A");
		System.out.print("CARD ASSIGNED USER : ");
		if(card.getAssgndUser()==null)
			System.out.println("N/A");
		else {
			User usr=card.getAssgndUser();
			System.out.println("\nUID :"+usr.getUid()+" Name : "+usr.getName()+" Email : "+usr.getEmail());
		}
	}
}
