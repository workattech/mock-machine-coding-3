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
public class Item {
    
    private String id;
    private String name;

    public Item(String name) {
        this.id = IdCreator.getNewId();
        this.name = name;
    }

    public String getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void show(){
        
    }
    public String getPrintableString(){
        return "";
    }
}
