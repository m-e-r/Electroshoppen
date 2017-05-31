/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Profiles;

import WEBSHOP.Address;
import DBManager.*;

/**
 * Class represents an employee in the POS and PIM systems.
 * @author Jacob
 */
public class EmployeeProfile extends Profile {

    public EmployeeProfile(String name, String phoneNumber, String eMail, Address adress,
	    String passWord) {
	super(name, phoneNumber, eMail, adress, passWord);
        this.saveProfileToDB();
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
    
    @Override
    public void updateProfile(String name, String email, String phone, String cvr) {
        String query = "UPDATE public.customer\n" 
                + "	SET full_name=" + this.getName() + ", email=" 
		+ this.geteMail() + ", phone_number=" + this.getPhoneNumber() + "\n" 
                + "	WHERE email='" + this.geteMail() + "'";
        
        DBConnection dbc = new DBConnection();
	dbc.runQueryUpdate(query);
    }
    
    @Override
    public String[] searchProfile(String email) {
        return null;
    }

}
