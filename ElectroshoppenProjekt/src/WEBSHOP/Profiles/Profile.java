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
public abstract class Profile {
    private String name, eMail;
    protected String phoneNumber;
    private Adress adress;
    private String password;
    
    /*
    TODO: Ændre phonenumber så det bare er en string. 
    */
    public Profile(String name, String phoneNumber, String eMail, Adress adress, String password){
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
    public Adress getAdress() {
	return adress;
    }

    /**
     * @param adress the adress to set
     */
    public void setAdress(Adress adress) {
	this.adress = adress;
    }

    /**
     * @return the token
     */
    public String getPassword() {
	return password;
    }
    
    @Override
    public String toString(){
	return this.name + "\t" + this.eMail + "\t" + this.phoneNumber + "\t" 
		+ this.adress.toString() + "\t" + this.password;
    }
    
    
}
