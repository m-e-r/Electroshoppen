/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Profiles;

import WEBSHOP.Address;
import Authentication.Token;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import DBManager.*;

/**
 *
 * @author Jacob
 */
public class EmployeeProfile extends Profile {

    public EmployeeProfile(String name, String phoneNumber, String eMail, Address adress,
	    String passWord) {
	super(name, phoneNumber, eMail, adress, passWord);
        this.saveProfileToDB();
    }

    public void viewProfile(String id) {
	try (Scanner console = new Scanner(new File("Employee_Profiles.txt"))) {
	    while (console.hasNextLine()) {

	    }
	} catch (FileNotFoundException ex) {
	    Logger.getLogger(EmployeeProfile.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    @Override
    public void saveProfileToText() {
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

    @Override
    public void saveProfileToDB() {
	Address address = this.getAddress();
	String query = "INSERT INTO public.adress(\n"
		+ "	email, street_name, city, postal, secAdress, street_number)\n"
		+ "	VALUES ('" + this.geteMail() + "', '" + address.getStreetName() + "', '" + address.getCity() + "', '"
		+ address.getZipCode() + "', '" + address.getSecAddress() + "', '"
		+ address.getStreetNumber() + "');\n"
		+ "\n" 
		+ "INSERT INTO public.employee(\n"
		+ "	full_name, email, phone_number, password)\n"
		+ "	VALUES ('" + this.getName() + "', '" + this.geteMail() + "', '" 
		+ this.getPhoneNumber() + "', '" + this.getPassword() + "');";

	DBConnection dbc = new DBConnection();
	dbc.runQueryUpdate(query);
    }

}
