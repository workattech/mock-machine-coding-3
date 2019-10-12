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
public class User {
    
    //User: Each user should have a userId, name, email.
    
    private String userId;
    private String name;
    private String email;

    public User(String name, String email) {
        this.name = name;
        this.email = email;
        userId = IdCreator.getNewId();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPrintableString(){
        String s = " { id: " + getUserId() + ", name: " + getName() + ",  Email: " + getEmail() + " }";
        return s;
    }
    
    public void show(){
        System.out.println(getPrintableString());
    }

}
