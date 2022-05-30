/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock.machine.coding.pkg3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author rajeshkumar.yadav



SHOW
SHOW BOARD
SHOW LIST
SHOW CARD
* 
 */
public class MockMachineCoding3 {

    Map<String, Board> boards;
    Map<String, User> users;
    Map<String, ListItem> lists;
    Map<String, Card> cards;

    public MockMachineCoding3() {
        
        boards = new HashMap<>();
        users = new HashMap<>();
        lists = new HashMap<>();
        cards = new HashMap<>();
        
    }
    
    public Board getBoard(String id){
        if(boards.get(id) == null){
            System.out.println("Board Item does not exist");
            return null;
        }
        return  boards.get(id);
    }
    
    public ListItem getListItem(String id){
        if(lists.get(id) == null){
            System.out.println("List Item does not exist");
            return null;
        }
        return  lists.get(id);
    }
    
    public boolean isListPresent(String id){
        
        if(lists.get(id) == null){
            System.out.println("List Item does not exist");
            return false;
        }
        return  true;
        
    }
    
    public boolean isUserPresent(String id){
        if(users.get(id) == null){
            System.out.println("User does not exist");
            return false;
        }
        return  true;
    }
    
    public boolean isBoradPresent(String id){
        if(boards.get(id) == null){
            System.out.println("Board does not exist");
            return false;
        }
        return  true;
    }
    
    public boolean isCardPresent(String sysId){
        if(cards.get(sysId) == null){
            System.out.println("Card does not exist");
            return false;
        }
        return true;
    }
    
    /* BOARD CREATE */
    public String createBoard(String name){
        Board b = new Board(Privacy.privateType, name);
        System.out.println("Board with ID " + b.getId()  + " has crated ");
        boards.put(b.getId(), b);
        return b.getId();
    }
    
    /* BOARD <name/privacy> */
    public void changeBoardAttribute(String id, String attributeName, String val){
        
        if(!isBoradPresent(id)){
            return ;
        }
        Board b = boards.get(id);
        
        if(attributeName.equalsIgnoreCase("name")){
            b.setName(val);
        }else if(attributeName.equalsIgnoreCase("privacy")){
            b.setPrivacy(Privacy.getPrivacy(val));
        }
        
    }
    
    /* BOARD <ADD_MEMBER/REMOVE_MEMBER> */
    public void addBoardMember(String boardId, String userId){
        
        if(!isBoradPresent(boardId)){
            return ;
        }
        Board b = boards.get(boardId);
        if(!isUserPresent(userId)){
            return;
        }
        User u = users.get(userId);
        b.addUserToBoard(u);
    }
    
    /* BOARD <ADD_MEMBER/REMOVE_MEMBER> */
    public void removeBoardMember(String boardId, String userId){
        
        if(!isBoradPresent(boardId)){
            return ;
        }
        Board b = boards.get(boardId);
        if(!isUserPresent(userId)){
            return;
        }
        User u = users.get(userId);
        b.removeUserToBoard(u);
    }
    
    /* BOARD DELETE */
    public void deleteBoard(String id){
        if(!isBoradPresent(id))
            return;
        boards.remove(id);
    }
    
    /* List CREATE */
    public String createList(String boradId, String name){
        
        if(!isBoradPresent(boradId))
            return "";
        
        ListItem l = new ListItem( name);
        System.out.println("List with ID " + l.getId()  + " has crated ");
        lists.put(l.getId(), l);
        
        Board b = boards.get(boradId);
        b.addListItemToBoard(l);
        return l.getId();
        
    }
    
    /* LIST DELETE */
    public void deleteList(String id){
        
        if(!isListPresent(id))
            return;
        
        Board b = lists.get(id).getBoard();
        b.removeListFromBoard(lists.get(id));
   
    }
    
    
    /* CARD CREATE */
    public void createCard(String listId, String name){
        
        if(!isListPresent(listId))
            return;
        
//        if(!isUserPresent(userId))
//            return;
//        
//        User u = users.get(userId);
        ListItem l = lists.get(listId);
        
        Card c = new Card(name);
        //c.setAssigendUser(u);
        System.out.println("Card with ID " + c.getId()  + " has crated ");
        cards.put(c.getId(), c);
        
        l.AddCardToList(c);
        c.setLitem(l);
        
        
    }
    
    /* CARD <name/description> */
    public void changeCardAttribute(String cardId, String attributeName, String val){
        
        if(!isBoradPresent(cardId)){
            return ;
        }
        Card c = cards.get(cardId);
        
        if(attributeName.equalsIgnoreCase("name")){
           c.setName(val);
        }else if(attributeName.equalsIgnoreCase("description")){
            c.setDescription(val);
        }
        
    }
    
    /* CARD ASSIGN */
    public void cardAssign(String cardId, String userId){
        
        if(!isCardPresent(cardId)){
            return;
        }
        Card c = cards.get(cardId);
        if(!isUserPresent(userId)){
            return;
        }
        User u = users.get(userId);
        c.setAssigendUser(u);
    }
    
    /* CARD UNASSIGN */
    public void cardUnAssign(String cardId){
        
        if(!isCardPresent(cardId)){
            return;
        }
        Card c = cards.get(cardId);
        c.unAssigendUser();
        
    }
    
    /* CARD MOVE */
    public void cardMove(String cardId, String listId){
        
        if(!isCardPresent(cardId)){
            return ;
        }
        Card c = cards.get(cardId);
        if(!isListPresent(listId)){
            return;
        }
        ListItem l = lists.get(listId);
        l.AddCardToList(c);
    }
    
    /* CARD DELETE */
    public void deleteCard(String id){
        if(!isCardPresent(id))
            return;
        Card c = cards.get(id);
        ListItem l = c.getLitem();
        l.removeCardFromList(c);
        cards.remove(c);
    }
    
    public void show(){
        for(Board b : boards.values()){
            b.show();
        }
    }
    
    public void show(Item item){
        if(item != null)
            item.show();
    }
    
    public static void main(String[] args) {
        
        MockMachineCoding3 mmc3 = new MockMachineCoding3();
        
        User u1 = new User("Rajesh Yadav", "rky@gmail.com");
        User u2 = new User("Suresh Prabhu", "srp@gmail.com");
        User u3 = new User("SRK", "srk@gmail.com");
        User u4 = new User("Rishabh", "rishi@gmail.com");
        mmc3.users.put(u1.getUserId(), u1);
        mmc3.users.put(u2.getUserId(), u2);
        mmc3.users.put(u3.getUserId(), u3);
        mmc3.users.put(u4.getUserId(), u4);
        String id1, id;
        mmc3.show();
        id1 = mmc3.createBoard("work@tech");
        mmc3.show(mmc3.getBoard(id1));
        mmc3.show();
        mmc3.changeBoardAttribute(id1, "name", "workat.tech");
        mmc3.changeBoardAttribute(id1, "privacy", "privateType");
        mmc3.show(mmc3.getBoard(id1));
        
        id = mmc3.createBoard("workat");
        mmc3.show();
        mmc3.addBoardMember(id, u1.getUserId());
        mmc3.addBoardMember(id, u2.getUserId());
        mmc3.addBoardMember(id, u3.getUserId());
        //BOARD 5da1583ec25d2a7e246b0375 REMOVE_MEMBER user2
        mmc3.removeBoardMember(id, u2.getUserId());
        //SHOW BOARD 5da1583ec25d2a7e246b0375
        mmc3.show(mmc3.getBoard(id));
        //BOARD DELETE 5da1586caaaad00d9b2d7aa6
        mmc3.deleteBoard(id);
        //SHOW BOARD 5da1586caaaad00d9b2d7aa6
        mmc3.show(mmc3.getBoard(id));
        //SHOW
        mmc3.show();
        //LIST CREATE 5da1583ec25d2a7e246b0375 
        String id2 = mmc3.createList(id1, "Mock Interviews");
        mmc3.show(mmc3.getListItem(id2));
        
        /*






SHOW LIST 5da1583547c78c15a1408df2
LIST 5da1583547c78c15a1408df2 name Mock Interviews - Applied
SHOW LIST 5da1583547c78c15a1408df2
LIST CREATE 5da1583ec25d2a7e246b0375 Mock Interviews - Scheduled
SHOW BOARD 5da1583ec25d2a7e246b0375
CARD CREATE 5da1583547c78c15a1408df2 abcd@gmail.com
CARD CREATE 5da1583547c78c15a1408df2 abcda@gmail.com
SHOW LIST 5da1583547c78c15a1408df2
CARD 5da1583547c78c15a14kj78g name abcde@gmail.com
CARD 5da1583547c78c15a14kj78g description At 7PM
SHOW LIST 5da1583547c78c15a1408df2
CARD 5da1583547c78c15a14kjsd8 ASSIGN gaurav@workat.tech
SHOW CARD 5da1583547c78c15a14kjsd8
CARD 5da1583547c78c15a14kjsd8 MOVE 5da1583547c78c15a143hj34
SHOW LIST 5da1583547c78c15a1408df2
SHOW LIST 5da1583547c78c15a143hj34
CARD 5da1583547c78c15a14kjsd8 UNASSIGN
SHOW CARD 5da1583547c78c15a14kjsd8
SHOW*/
        
    }
    
}
