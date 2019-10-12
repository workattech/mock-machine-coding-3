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
public class IdCreator {
    
    private static int inc = 0;
    private static IdCreator idCreator = null;
    
    private IdCreator(){
        
    }
    
    public static IdCreator getInstance(){
        if(idCreator == null)
            idCreator = new IdCreator();
        return  idCreator;
    }
    
    public static String getNewId(){
        
        String s = String.valueOf(System.currentTimeMillis()).substring(1,9);
        inc = (inc + 1)%10;
        s = s + inc;
        return s;
    }
    
    
}
