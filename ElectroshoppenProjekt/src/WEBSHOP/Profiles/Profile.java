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

    /**
     * Constructor for all kinds of profiles. Creates a profile.
     * @param name Full name of profile user
     * @param phoneNumber Phone number, max 8 character (danish phonenumber)
     * @param eMail E-mail adress
     * @param adress Full adress of user from Adress class in WEBSHOP package
     * @param password Chosen password.
     */
    
    public Profile() {
        
    }
    
    public Profile(String name, String phoneNumber, String eMail){
	this.name = name;
	this.phoneNumber = phoneNumber;
	this.eMail = eMail;
    }

    
    public Profile(String name, String phoneNumber, String eMail, Address adress, String password) {
	this.name = name;
	this.phoneNumber = phoneNumber;
	this.eMail = eMail;
	this.adress = adress;
	this.password = password;
    }

    public abstract void saveProfileToText();

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

    /**
     * @return the adress
     */
    public Address getAddress() {
	return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAddress(Address adress) {
	this.adress = adress;
    }

    /**
     * @return the token
     */
    public String getPassword() {
	return password;
    }

    @Override
    public String toString() {
	return this.name + "\t" + this.eMail + "\t" + this.phoneNumber + "\t"
		+ this.adress.toString() + "\t" + this.password;
    }

}
