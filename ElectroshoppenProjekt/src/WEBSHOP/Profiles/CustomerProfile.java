/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Profiles;

import WEBSHOP.Adress;
import Authentication.Token;

/**
 *
 * @author Jacob
 */
public class CustomerProfile extends Profile {
    
    public CustomerProfile(String name, String phoneNumber, String eMail, Adress adress, 
	    String passWord) {
	super(name, phoneNumber, eMail, adress, passWord);
    }

    @Override
    public void saveProfileToText() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void saveProfileToDB() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
