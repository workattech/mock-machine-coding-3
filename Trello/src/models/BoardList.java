package models;
import java.util.*;

public class BoardList {
	private UUID userId;
	private String name;
	private List<Card> cards;
	private Board board;
	
	public BoardList(String name,Board board)
	{
		this.userId = UUID.randomUUID();
		this.name = name;
		this.board = board;
		this.cards = new ArrayList<Card>();
	}
	
	public UUID getId() {
		return this.userId;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void addCard(Card card) {
		this.cards.add(card);
	}
	
	public void removeCard(Card card) {
		this.cards.remove(card);
	}
	
	public List<Card> getCards() {
		return this.cards;
	}
	
	public Board getBoard() {
		return this.board;
	}
	
	@Override
	public String toString() {
		StringBuilder displayString = new StringBuilder("{ id : "+userId+", name: "+name);
		if(cards.size()>0)
		{
			displayString.append(", cards : [");
			for(int index=0; index<cards.size(); index++) {
				displayString.append(cards.get(index));
				if(index < cards.size()-1)
					displayString.append(", ");
			}
			displayString.append(" ]");
		}
		displayString.append(" }");
		return new String(displayString);
	}
	
	@Override
	public boolean equals(Object list) {
		if(list == this) {
			return true;
		}
		
		if(!(list instanceof BoardList)) {
			return false;
		}
		
		return this.getId().equals(((BoardList)list).getId());
	}
	
	@Override
	public int hashCode() {
		return this.userId.hashCode();
	}
}
