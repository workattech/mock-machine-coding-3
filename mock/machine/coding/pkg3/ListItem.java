/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock.machine.coding.pkg3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rajeshkumar.yadav
 */
public class ListItem extends Item{
    
    // List: Each list should have a id, name and cards
    private List<Card> cards;
    private Board board;

    public ListItem(String name) {
        super(name);
        cards = new ArrayList<>();
    }

    public List<Card> getCards() {
        return cards;
    }
    
    //We should also be able to move cards across lists in the same board
    public void AddCardToList(Card c){
        if(c.getLitem() != null && this.getBoard() != c.getLitem().getBoard())
            return;
        cards.add(c);
        c.setLitem(this);
    }
    
    // We should also be able to remove cards from lists 
    public void removeCardFromList(Card c){
        if(c.getLitem() != null)
            return;
        cards.remove(c);
        c.setLitem(null);
    }

    public Board getBoard() {
        return board;
    }

    public void setBoard(Board board) {
        this.board = board;
    }
    
    public String getPrintableString(){
        String s = "{ Id: " + getId() + ", Name:  " + getName();
        if(cards.size() > 0){
            s = s + ", cards: [";
            for(int i=0; i<cards.size(); i++){
                s = s + cards.get(i).getPrintableString();
                if(i<cards.size()-1)
                    s = s+", ";
            }
        }
        return s;
    }
    
    public void show(){
        System.out.println(getPrintableString());
    }
    
}
