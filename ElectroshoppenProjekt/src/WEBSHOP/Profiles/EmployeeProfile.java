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
	    Token token, int id) {
	super(name, phoneNumber, eMail, adress, token, id);
    }

    public Profile viewProfile(String id) {
	throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void saveProfil() {
	File file = new File("Employee_Profiles.txt"); //Put .txt file outside src folder.
	System.out.println(file.getAbsolutePath());
	try (FileWriter fileW = new FileWriter(file, true);
		BufferedWriter bufferedW = new BufferedWriter(fileW);
		PrintWriter output = new PrintWriter(bufferedW)) {
	    output.println(this.toString() + "\n"); //write here what should be inserted
	} catch (IOException ex) {
	    Logger.getLogger(EmployeeProfile.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

}
