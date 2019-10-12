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
public class Board extends Item{
    
    //Board: Each board should have a id, name, privacy (PUBLIC/PRIVATE), url, members, lists

    private Privacy privacy;
    private String url;
    private List<User> userList;
    private List<ListItem> list;

    public Board(Privacy privacy, String name) {
        
        super(name);
        this.privacy = privacy;
        url = URLGenerator.getURL(getId());
        userList = new ArrayList<>();
        list = new ArrayList<>();
    }

    public Privacy getPrivacy() {
        return privacy;
    }

    public String getUrl() {
        return url;
    }

    public void setPrivacy(Privacy privacy) {
        this.privacy = privacy;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public void addListItemToBoard(ListItem l){
        list.add(l);
        l.setBoard(this);
    }
    
    public void removeListFromBoard(ListItem l){
        if(list.contains(l))
            list.remove(l);
    }
    
    public void addUserToBoard(User u){
        userList.add(u);
    }
    
    public void removeUserToBoard(User u){
        if(userList.contains(u))
            userList.remove(u);
    }
    
    public String getPrintableString(){
        String s = "{ Id: " + getId() + ", Name:  " + getName() + " privacy: " + getPrivacy() + ", URL:  " + getUrl();
        if(userList.size() > 0){
            s = s + ", Users: [";
            for(int i=0; i<userList.size(); i++){
                s = s + userList.get(i).getPrintableString();
                if(i<userList.size()-1)
                    s = s+", ";
            }
            s = s + "]";
        }
        if(list.size() > 0){
            s = s + ", List: [";
            for(int i=0; i<list.size(); i++){
                s = s + list.get(i).getPrintableString();
                if(i<list.size()-1)
                    s = s+", ";
            }
            s = s + "]";
        }
        s = s + " }";
        return s;
    }
    
    public void show(){
        System.out.println(getPrintableString());
    }

}
