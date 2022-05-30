/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mock.machine.coding.pkg3;

/**
 *
 * @author rajeshkumar.yadav
 */
public class Card extends Item{
    
    //Card: Each card should have a id, name, description, assigned user
    private String description;
    private User assigendUser;
    private ListItem litem;

    public Card(String name) {
        super(name);
        //this.assigendUser = assigendUser;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getAssigendUser() {
        return assigendUser;
    }

    public void setAssigendUser(User assigendUser) {
        this.assigendUser = assigendUser;
    }
    
    public void unAssigendUser() {
        this.assigendUser = null;
    }

    public ListItem getLitem() {
        return litem;
    }

    public void setLitem(ListItem litem) {
        this.litem = litem;
    }
    
    public String getPrintableString(){
        String s = " { id: " + getId() + ", name: " + getName() + ", description:  " + getDescription() + ",  AssignedToUser: " + getAssigendUser().getName() + " }";
        return s;
    }
    
    public void show(){
        System.out.println(getPrintableString());    
    }
    
    
}
