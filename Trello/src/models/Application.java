package models;
import java.util.*;

public class Application {
	private Map<UUID,Board> boards;
	private Map<String,User> users;	// Here key would be user-email
	private Map<UUID,BoardList> lists;
	private Map<UUID,Card> cards;
	
	public Application() {
		this.boards = new HashMap<UUID,Board>();
		this.users = new HashMap<String,User>();
		this.lists = new HashMap<UUID,BoardList>();
		this.cards = new HashMap<UUID,Card>();
	}
	
	public Map<UUID,Board> getBoards() {
		return this.boards;
	}
	
	public Map<String,User> getUsers() {
		return this.users;
	}
	
	public Map<UUID,BoardList> getLists() {
		return this.lists;
	}
	
	public Map<UUID,Card> getCards() {
		return this.cards;
	}
}
