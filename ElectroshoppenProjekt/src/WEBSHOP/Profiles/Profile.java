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
    private String name, phoneNumber, eMail;
    private Adress adress;
    private Token token;
    
    public Profile(String name, String phoneNumber, String eMail, Adress adress, Token token){
	this.name = name;
	this.phoneNumber = phoneNumber;
	this.eMail = eMail;
	this.adress = adress;
	this.token = token;
    }
    
    public abstract void saveProfil();

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
    public Token getToken() {
	return token;
    }
    
    
}
