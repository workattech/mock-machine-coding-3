package com.soumya.projectManagement;

import java.util.HashMap;
import java.util.UUID;

public class ListManager {
	
	public static boolean isValid(String lid, StorageUtil store) {
		return store.lists.containsKey(lid);
	}

	public static String createList(String bid, String name, StorageUtil store) {
		String lid = UUID.randomUUID().toString().replace("-","");
		Board board = store.boards.get(bid);
		CList list = new CList(lid, name);
		board.getLists().add(list);
		store.lists.put(lid, new HashMap<CList, Board>());
		store.lists.get(lid).put(list, board);
		return lid;
	}
	
	public static void deleteList(String lid, StorageUtil store) {
		CList list = (CList) store.lists.get(lid).keySet().toArray()[0];
		Board board = (Board) store.lists.get(lid).values().toArray()[0];
		for(Card card : list.getCards())
			store.cards.remove(card.getCid());
		store.lists.remove(lid);
		board.getLists().remove(list);
	}
	
	public static void updateList(String lid, String name, StorageUtil store) {
		CList list = (CList) store.lists.get(lid).keySet().toArray()[0];
		list.setName(name);
	}
	
	public static void showList(String lid, CList list, StorageUtil store) {
		list = list==null?(CList) store.lists.get(lid).keySet().toArray()[0]:list;
		System.out.println("LID : "+lid);
		System.out.println("LIST NAME : "+list.getName());
		System.out.println("LIST CARDS :");
		if(list.getCards().size()>0)
			for(Card card : list.getCards())
				CardManager.showCard(card.getCid(),card, store);
		else
			System.out.println("N/A");
		System.out.println();
	}
}
