/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

import DBManager.*;

/**
 * Class responsible for logging users in and out.
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
    @Override
    public Token doLogin() {
	if (super.userExists()) {

	    this.token = new Token(super.email.toUpperCase());
	    DBConnection dbc = new DBConnection();
	    String tokenTok = token.getTok();

	    String query = "do $$\n"
		    + "BEGIN\n"
		    + "IF EXISTS (SELECT * FROM token WHERE tok = '" + tokenTok + "') THEN \n"
		    + "UPDATE token SET millisec = " + token.getCreation() + " WHERE tok = '" + tokenTok + "';\n"
		    + "ELSE \n"
		    + "INSERT INTO token (tok, millisec, email) VALUES ('" + tokenTok + "', " 
		    + token.getCreation() + ", '" + super.email + "');\n"
		    + "END IF;\n"
		    + "END \n"
		    + "$$";
	    dbc.runQueryUpdate(query);
	    return this.token;
	} else {
	    return null;
	}
    }
    
    @Override
    public boolean doLogout(){
	if (super.userExists() && this.token != null) {	    
	    DBConnection dbc = new DBConnection();
	    String query = "DELETE FROM token WHERE tok = '" + token.getTok() + "';";
	    dbc.runQueryUpdate(query);
            this.token = null;
	    return true;
	} else {
	    return false;
	}
    }
    
    
    
    /**
     * Do not use this method.
     * Meant for Create class.
     * @param none
     * @return false
     */
    @Override
    public boolean createUser(String none) {
        return false;
    }
    
    /**
     * Do not use this method.
     * Meant for Create class.
     * @param none
     * @return false
     */
    @Override
    public boolean deleteUser(String none) {
        return false;
    }
}
