/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

import DBManager.*;

/**
 *
 * @author Kasper
 */
public class Login extends Authentication {

    private Token token;

    public Login(String userName, String password) {
	super(userName, password);

    }

    /**
     * If the user exists, the method creates and saves a Token to the databse
     * confirming a succesfull login and returns true.
     * Else it returns false.
     * @return
     */
    public boolean doLogin() {
	if (super.userExists()) {
	    this.token = new Token(super.userName.toUpperCase());
	    DBConnection dbc = new DBConnection();
	    String query = "INSERT INTO public.token(\n"
		    + "	tok, millisec, phone_number)\n"
		    + "	VALUES ('" + token.getTok() + "', " + token.getCreation() + ", " 
		    + Integer.parseInt(super.userName) + ");";
	    
	    dbc.runQueryUpdate(query);
            return true;
            
	} else {
            return false;
        }
    }
}
