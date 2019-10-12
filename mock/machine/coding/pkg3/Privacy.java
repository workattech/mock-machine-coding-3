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
public enum Privacy {
    
    publicType, privateType;
    
    public static Privacy getPrivacy(String privacyType){
        if(privacyType.equalsIgnoreCase("publicType"))
            return Privacy.publicType;
        else if(privacyType.equalsIgnoreCase("privateType"))
            return  Privacy.privateType;
        return Privacy.privateType;
    }
    
}
