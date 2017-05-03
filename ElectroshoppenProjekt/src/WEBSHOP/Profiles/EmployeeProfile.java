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
public class EmployeeProfile extends Profile {
    
    private String employeeId;
    
    public EmployeeProfile(String name, String phoneNumber, String eMail, Adress adress, 
	    Token token, String employeeId) {
	super(name, phoneNumber, eMail, adress, token);
	this.employeeId = employeeId;
    }

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
	return employeeId;
    }
    
    public Profile viewProfile(String id){
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void saveProfil() {
	throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
