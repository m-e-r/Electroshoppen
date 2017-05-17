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
     * Creates and returns a Token object used to validate a succesfull login
     * for a profile. If userName and password can't be validated this method
     * returns null.
     *
     * @return
     */
    public void doLogin() {
	if (super.userExists()) {
	    this.token = new Token(super.userName.toUpperCase());
	    DBConnection dbc = new DBConnection();
	    String tokenTok = token.getTok();

	    String query = "do $$\n"
		    + "BEGIN\n"
		    + "IF EXISTS (SELECT * FROM token WHERE tok = '" + tokenTok + "') THEN \n"
		    + "UPDATE token SET millisec = " + token.getCreation() + " WHERE tok = '" + tokenTok + "';\n"
		    + "ELSE \n"
		    + "INSERT INTO token (tok, millisec, phone_number) VALUES ('" + tokenTok + "', " 
		    + token.getCreation() + ", " + Integer.parseInt(super.userName) + ");\n"
		    + "END IF;\n"
		    + "END \n"
		    + "$$";
	    dbc.runQueryUpdate(query);
	}
    }
    
    public void doLogout(){
	if (super.userExists()) {
	    this.token = new Token(super.userName.toUpperCase());
	    DBConnection dbc = new DBConnection();
	    String tokenTok = token.getTok();

	    String query = "DELETE FROM token WHERE tok = '" + token.getTok() + "';";
	    dbc.runQueryUpdate(query);
	}
    }
}
