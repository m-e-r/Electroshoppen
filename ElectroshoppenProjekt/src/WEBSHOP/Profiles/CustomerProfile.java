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
    
    private String customerId;
    
    public CustomerProfile(String name, String phoneNumber, String eMail, Adress adress, 
	    Token token, String customerId) {
	super(name, phoneNumber, eMail, adress, token);
	this.customerId = customerId;
    }

    /**
     * @return the customerId
     */
    public String getCustomerId() {
	return customerId;
    }

    @Override
    public void saveProfil() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
