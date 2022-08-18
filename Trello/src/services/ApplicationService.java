package services;
import models.*;
import java.util.*;

import enums.Access;

public class ApplicationService {
	private Application application;
	
	public ApplicationService() {
		this.application = new Application();
	}
	
	public boolean createBoard(String name) {
		Board newBoard = new Board(name);
		application.getBoards().put(newBoard.getId(),newBoard);
		System.out.println("Created board: "+newBoard.getId());
		return true;
	}
	
	public boolean deleteBoard(UUID boardID) {
		if(!application.getBoards().containsKey(boardID)) {
			System.out.println("The board which you are trying to delete doesn't exists");
			return false;
		}
		Board boardToDelete = application.getBoards().get(boardID);
		int index;
		for(index=0; index<boardToDelete.getLists().size(); index++)
			deleteList(boardToDelete.getLists().get(index).getId());
		application.getBoards().remove(boardID);
		return true;
	}
	
	public boolean setBoardName(UUID boardId,String name) {
		if(!application.getBoards().containsKey(boardId)) {
			System.out.println("The board which you are trying to edit doesn't exists");
			return false;
		}

		application.getBoards().get(boardId).setName(name);
		return true;
	}
	
	public boolean changeBoardPrivacy(UUID boardId,String privacy) {
		if(!application.getBoards().containsKey(boardId)) {
			System.out.println("The board which you are trying to edit doesn't exists");
			return false;
		}

		if(privacy.toUpperCase().equals("PRIVATE"))
			application.getBoards().get(boardId).setPrivacy(Access.PRIVATE);
		else
			application.getBoards().get(boardId).setPrivacy(Access.PUBLIC);
		return true;
	}
	
	public boolean addMemberToBoard(UUID boardId,String email) {
		if(!application.getBoards().containsKey(boardId)) {
			System.out.println("The board which you are trying to edit doesn't exists");
			return false;
		}
		if(!application.getUsers().containsKey(email)) {
			System.out.println("The user which you are trying to add doesn't exists");
			return false;
		}
		
		application.getBoards().get(boardId).addUser(application.getUsers().get(email));
		return true;
	}
	
	public boolean removeMemberSubscription(UUID boardId,String email) {
		if(!application.getBoards().containsKey(boardId)) {
			System.out.println("The board which you are trying to edit doesn't exists");
			return false;
		}
		if(!application.getUsers().containsKey(email)) {
			System.out.println("The user which you are trying to add doesn't exists");
			return false;
		}
		
		application.getBoards().get(boardId).removeUser(application.getUsers().get(email));
		return true;
	}
	
	public void showBoard(UUID boardId) {
		if(!application.getBoards().containsKey(boardId)) {
			System.out.println("The board which you are trying to display doesn't exists");
			return ;
		}
		
		System.out.println(application.getBoards().get(boardId));
	}
	
	public boolean createList(UUID boardID,String name) {
		if(!application.getBoards().containsKey(boardID)) {
			System.out.println("The board in which you are trying to create the list doesn't exists");
			return false;
		}
		BoardList newList = new BoardList(name, application.getBoards().get(boardID));
		application.getBoards().get(boardID).addList(newList);
		application.getLists().put(newList.getId(),newList);
		System.out.println("Created list: "+newList.getId());
		return true;
	}
	
	public boolean setListName(UUID listId,String name) {
		if(!application.getLists().containsKey(listId)) {
			System.out.println("The list which you are trying to edit doesn't exists");
			return false;
		}

		application.getLists().get(listId).setName(name);
		return true;
	}
	
	public boolean deleteList(UUID listId) {
		if(!application.getLists().containsKey(listId)) {
			System.out.println("The list which you are trying to delete doesn't exists");
			return false;
		}
		BoardList listToDelete = application.getLists().get(listId);
		int index;
		for(index=0; index < listToDelete.getCards().size(); index++)
			deleteCard(listToDelete.getCards().get(index).getId());
		application.getBoards().get(listToDelete.getBoard().getId()).removeList(listToDelete);
		application.getLists().remove(listId);
		return true;
	}
	
	public void showList(UUID listId) {
		if(!application.getLists().containsKey(listId)) {
			System.out.println("The list which you are trying to display doesn't exists");
			return;
		}
		
		System.out.println(application.getLists().get(listId));
	}
	
	public boolean createCard(UUID listId,String name) {
		if(!application.getLists().containsKey(listId)) {
			System.out.println("The list in which you are trying to create the card doesn't exists");
			return false;
		}
		Card newCard = new Card(name, application.getLists().get(listId));
		application.getLists().get(listId).addCard(newCard);
		application.getCards().put(newCard.getId(), newCard);
		System.out.println("Created card: "+newCard.getId());
		return true;
	}
	
	public boolean deleteCard(UUID cardId) {
		if(!application.getCards().containsKey(cardId)) {
			System.out.println("The card which you are trying to delete doesn't exists");
			return false;
		}
		Card cardToDelete = application.getCards().get(cardId);
		application.getLists().get(cardToDelete.getList().getId()).removeCard(cardToDelete);
		application.getCards().remove(cardId);
		return true;
	}
	
	public boolean assignCardToMember(UUID cardId,String email) {
		if(!application.getCards().containsKey(cardId)) {
			System.out.println("The card which you are trying to assign doesn't exists");
			return false;
		}
		
		application.getCards().get(cardId).setAssignee(application.getUsers().get(email));
		return true;
	}
	
	public boolean unassignCard(UUID cardId) {
		if(!application.getCards().containsKey(cardId)) {
			System.out.println("The card which you are trying to unassign doesn't exists");
			return false;
		}
		
		application.getCards().get(cardId).setAssignee(null);
		return true;
	}
	
	public boolean setCardName(UUID cardId,String name) {
		if(!application.getCards().containsKey(cardId)) {
			System.out.println("The card which you are trying to edit doesn't exists");
			return false;
		}
		
		application.getCards().get(cardId).setName(name);
		return true;
	}
	
	public boolean setCardDescription(UUID cardId,String description) {
		if(!application.getCards().containsKey(cardId)) {
			System.out.println("The card which you are trying to edit doesn't exists");
			return false;
		}
		
		application.getCards().get(cardId).setDescription(description);
		return true;
	}
	
	public boolean moveCardToDifferentList(UUID cardId,UUID listId) {
		if(!application.getCards().containsKey(cardId)) {
			System.out.println("The card which you are trying to move doesn't exists");
			return false;
		}
		if(!application.getLists().containsKey(listId)) {
			System.out.println("The list which you are trying to add this card doesn't exists");
			return false;
		}
		
		application.getCards().get(cardId).setList(application.getLists().get(listId));
		return true;
	}
	
	public void showCard(UUID cardId) {
		if(!application.getCards().containsKey(cardId)) {
			System.out.println("The card which you are trying to display doesn't exists");
			return;
		}
		System.out.println(application.getCards().get(cardId));
	}
	
	public void showAll() {
		if(application.getBoards().isEmpty())
		{
			System.out.println("No boards");
			return ;
		}
		for(Map.Entry<UUID, Board> board: application.getBoards().entrySet()) {
			System.out.println(board.getValue());
		}
	}
	
	public boolean createUser(String id,String name,String email) {
		User user=new User(id,name,email);
		application.getUsers().put(email, user);
		return true;
	}
	
	public boolean deleteUser(String email) {
		if(!application.getUsers().containsKey(email)) {
			System.out.println("User which you are trying to delete doesn't exists");
			return false;
		}
		application.getUsers().remove(email);
		return true;
	}
}
