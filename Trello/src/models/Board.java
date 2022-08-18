package models;
import java.util.*;

import enums.Access;

public class Board {
	private UUID id;
	private String name;
	private Access privacy;
	private List<User> members;
	private List<BoardList> lists;
	
	public Board(String name)
	{
		this.id = UUID.randomUUID();
		this.name = name;
		this.privacy = Access.PUBLIC;
		this.members = new ArrayList<User>();
		this.lists = new ArrayList<BoardList>();
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
	
	public void setPrivacy(Access privacy) {
		this.privacy = privacy;
	}
	
	public void addUser(User user) {
		this.members.add(user);
	}
	
	public void removeUser(User user) {
		this.members.remove(user);
	}
	
	public void addList(BoardList list) {
		this.lists.add(list);
	}
	
	public void removeList(BoardList list) {
		this.lists.remove(list);
	}
	
	public List<BoardList> getLists() {
		return this.lists;
	}
	
	@Override
	public String toString() {
		int index;
		StringBuilder displayString = new StringBuilder("{ id : "+id+", name: "+name+", privacy : "+privacy);
		if(lists.size()>0)
		{
			displayString.append(", lists : [");
			for(index=0; index<lists.size(); index++) {
				displayString.append(lists.get(index));
				if(index < lists.size()-1)
					displayString.append(", ");
			}
			displayString.append(" ]");
		}
		if(members.size()>0)
		{
			displayString.append(", members : [");
			for(index=0; index<members.size(); index++) {
				displayString.append(members.get(index));
				if(index < members.size()-1)
					displayString.append(", ");
			}
			displayString.append(" ]");
		}
		displayString.append(" }");
		return new String(displayString);
	}
	
	@Override
	public boolean equals(Object board) {
		if(board == this) {
			return true;
		}
		
		if(!(board instanceof Board)) {
			return false;
		}
		
		return this.getId().equals(((Board)board).getId());
	}
	
	@Override
	public int hashCode() {
		return this.id.hashCode();
	}
}
