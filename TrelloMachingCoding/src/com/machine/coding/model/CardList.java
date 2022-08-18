package com.machine.coding.model;

import java.util.ArrayList;
import java.util.List;

public class CardList extends Base {

	
	private String name;
	private List<Card> cards;

	//Keeping reverse association
	private Board board;
	
	public CardList() {
		this.cards = new ArrayList<>();
	}

	public CardList(String name) {
		this();
		this.name = name;
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

	public void addCard(Card card) {
		getCards().add(card);
	}
	
	public void removeCard(Card card) {
		getCards().remove(card);
		
	}

	public Board getBoard() {
		return board;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CardList other = (CardList) obj;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("CardList [id=%s, name=%s, cards=%s]", getId(), name, cards);
	}


}
