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

        if ((this.creation + this.goTime) > this.date.getTime()) {
            this.creation = this.date.getTime();
            return this.tok;
            
        } else {
            return "Expired";
        }
    }
}
