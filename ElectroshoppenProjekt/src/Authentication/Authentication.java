/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

import DBManager.DBConnection;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class that holds the common methods for the Create and Login classes like.
 * @author Kasper
 */
public abstract class Authentication implements Authenticateable {
    protected String email;
    protected String password;
    protected MessageDigest digest; //for encrypting the password

    public Authentication(String email, String password) {

	//This should NEVER throw an exception as the "SHA-256" is a valid parameter
	try {
	    this.digest = MessageDigest.getInstance("SHA-256");
	} catch (NoSuchAlgorithmException ex) {
	    System.out.println("No such Algorithm");
	}

	this.email = email;
	this.password = this.encryptPassword(password);
    }
    

    /**
     * This method is called in the constructor thereby encrypting the password
     * immediately.
     * @param password
     * @return Encrypted password.
     */
    protected final String encryptPassword(String password) {
	StringBuilder hexString = new StringBuilder(); //used to create the returnString

	//This is the actual encryption
	byte[] encrypted = this.digest.digest(password.getBytes(StandardCharsets.UTF_8));

	//Building a String from the encrypted byte array
	for (byte b : encrypted) {
	    String hex = Integer.toHexString(0xff & b);
	    hexString.append(hex);
	}

	//Creating the returnString from the encrypted String
	String returnString = new String(hexString);
	return returnString;
    }

    /**
     * Runs a query in the database to check if the Login/Create object exists 
     * in the database.
     * @return True if the username-password combination is found in the database.
     * False if not.
     */
    protected final boolean userExists() {
	DBConnection dbc = new DBConnection();
	String query = "SELECT * FROM customer FULL JOIN employee on customer.email = employee.email\n"
		+ "WHERE (employee.email = '" + this.email + "' OR customer.email = '" + this.email + "')\n"
		+ "AND (employee.password = '" + this.password + "'\n"
		+ "OR customer.password = '" + this.password + "')";
	ResultSet user = dbc.runQueryExcecute(query); 
	try {
	    if (!user.next()) {
		System.out.println("User does not exist."); //Should be removed
		return false;
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(Authentication.class.getName()).log(Level.SEVERE, null, ex);
	}
	System.out.println("User already exist."); //Should be removed
	return true;
    }

}
