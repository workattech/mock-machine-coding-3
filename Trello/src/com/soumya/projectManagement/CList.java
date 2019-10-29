package com.soumya.projectManagement;

import java.util.ArrayList;
import java.util.List;

// Model for List
public class CList {

	private String lid, name;
	private List<Card> cards;
	
	public CList(String lid, String name) {
		this.lid = lid;
		this.name = name;
		this.cards = new ArrayList<>();
	}

	public String getLid() {
		return lid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards(List<Card> cards) {
		this.cards = cards;
	}
	
	
}
