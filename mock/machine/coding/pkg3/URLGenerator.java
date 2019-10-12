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
public class URLGenerator {
    
    //private static String domainName = trello";
    
    public static String getURL(String sysId){
        return "www.trello." + sysId + ".com";
    }
    
}
