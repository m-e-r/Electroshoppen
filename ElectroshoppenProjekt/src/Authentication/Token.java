/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

import java.util.Date;

/**
 * Token class used for authenticating an already logged in user instead of 
 * sending their password.
 * The token will expire after a set amount of time.
 * @author Kasper
 */
public class Token {
    private String tok; //actual token used for comparison
    private long creation; //time for creation of the object in millisecs since 1970
    private long goTime; //time this token is allowed to be valid in milisecs
    private Date date; //used to generate the millisecs
    
    public Token(String tok) {
        this.date = new Date();
        this.tok = tok;
        this.creation = this.date.getTime();
        this.goTime = 5000; //abitrary amount..
    }
    
    /**
     * If token is still valid, this methoad returns the string for comparison
     * and updates the tokens creation time.
     * If not valid, it returns the String "Expired".
     * @return 
     */
    public String getToken() {
        this.date = new Date();

        if ((this.getCreation() + this.getGoTime()) > this.getDate().getTime()) {
	    this.setCreation(this.getDate().getTime());
            return this.getTok();
            
        } else {
            return "Expired";
        }
    }

    /**
     * @return the tok
     */
    public String getTok() {
	return tok;
    }

    /**
     * @return the creation
     */
    public long getCreation() {
	return creation;
    }

    /**
     * @param creation the creation to set
     */
    public void setCreation(long creation) {
	this.creation = creation;
    }

    /**
     * @return the goTime
     */
    public long getGoTime() {
	return goTime;
    }

    /**
     * @return the date
     */
    public Date getDate() {
	return date;
    }
}
