/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Profiles;

import WEBSHOP.Adress;
import Authentication.Token;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class EmployeeProfile extends Profile {
    
    public EmployeeProfile(String name, String phoneNumber, String eMail, Adress adress, 
	    Token token, String employeeId, int id) {
	super(name, phoneNumber, eMail, adress, token, id);
    }
    
    public Profile viewProfile(String id){
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void saveProfil() {
	File file = new File("Employee_Profiles.txt");
	PrintWriter output = null;
	System.out.println(file.getAbsolutePath());
	try  {
	    output = new PrintWriter(file);
	    output.print(this.toString());
	} catch (IOException ex) {
	    Logger.getLogger(EmployeeProfile.class.getName()).log(Level.SEVERE, null, ex);
	}
	output.close();
	
	
    }
    
}
