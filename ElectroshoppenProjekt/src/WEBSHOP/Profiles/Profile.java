/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Profiles;

import Authentication.Token;
import WEBSHOP.Address;
import WEBSHOP.Order.Order;

/**
 *
 * @author Jacob
 */
public abstract class Profile {

    private String name, eMail;
    protected String phoneNumber;
    private Address adress;
    private String password;
    private Order currentOrder;


    public Profile() {        
    }
    

    public Profile(String name, String phoneNumber, String eMail){
	this.name = name;
	this.phoneNumber = phoneNumber;
	this.eMail = eMail;
    }

    /**
     * Constructor for all kinds of profiles. Creates a profile.
     * @param name Full name of profile user
     * @param phoneNumber Phone number, max 8 character (danish phonenumber)
     * @param eMail E-mail adress
     * @param adress Full adress of user from Adress class in WEBSHOP package
     * @param password Chosen password.
     */    
    public Profile(String name, String phoneNumber, String eMail, Address adress, String password) {
	this.name = name;
	this.phoneNumber = phoneNumber;
	this.eMail = eMail;
	this.adress = adress;
	this.password = password;
    }
    
    public abstract String[] searchProfile(String email);
    
    public abstract void updateProfile(String name, String email, String phone, String cvr);

    /**
     * Saves the profile to the database.
     */    
    public abstract void saveProfileToDB();

    /**
     * @return the name
     */
    public String getName() {
	return name;
    }

    /**
     * @return the phoneNumber
     */
    public String getPhoneNumber() {
	return phoneNumber;
    }

    /**
     * @return the eMail
     */
    public String geteMail() {
	return eMail;
    }


    public void setAddress(String streetName, String streetNumber, String secAddress, String zipCode,
            String city) {
        
	this.adress = new Address(streetName, streetNumber, secAddress, zipCode, city);
    }


    public Address getAddress() {
	return this.adress;
    }


    public String getPassword() {
	return password;
    }
    
    public void setEmail(String email){
	this.eMail = email;
    }


}
