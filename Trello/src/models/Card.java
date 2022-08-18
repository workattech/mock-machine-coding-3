package models;
import java.util.*;


public class Card {
	private UUID id;
	private String name;
	private String description;
	private User assignee;
	private BoardList list;
	
	public Card(String name,BoardList list)
	{
		this.id = UUID.randomUUID();
		this.name = name;
		this.list = list;
	}
	
	public UUID getId() {
		return this.id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	public BoardList getList() {
		return this.list;
	}
	
	public void setList(BoardList newList)
	{
		if(list!=null && !list.getBoard().getId().equals(newList.getBoard().getId())) {
			System.out.println("The list can't be moved to different board.");
			return ;
		}
		this.list.getCards().remove(this.getId());
		newList.addCard(this);
		this.list = newList;
	}
	
	public void setAssignee(User assignee) {
		this.assignee = assignee;
	}
	
	@Override
	public String toString() {
		StringBuilder displayString = new StringBuilder("{ id : "+id+", name: "+name);
		if(description!=null && description.length()>0) 
			displayString.append(", description: "+description);
		if(assignee!=null)
			displayString.append(", assignedTo: "+assignee.getEmail());
		displayString.append('}');
		return new String(displayString);
	}
	
	@Override
	public boolean equals(Object card) {
		if(card == this) {
			return true;
		}
		
		if(!(card instanceof Card)) {
			return false;
		}
		
		return this.getId().equals(((Card)card).getId());
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
}
