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
import WEBSHOP.Profiles.*;

/**
 *
 * @author Kasper
 */
public abstract class Authentication {
    protected String userName;
    public String password;
    protected DBConnection dbCon; //communication with the database
    protected MessageDigest digest; //for encrypting the password
    
    public Authentication(String userName, String password) {
        
        //This should NEVER throw an exception as the "SHA-256" is a valid parameter
        try {
            this.digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException ex) {
            System.out.println("No such Algorithm");
        }
        
        this.userName = userName;
        this.password = this.encryptPassword(password);
    }
    
    /**
     * This method is called in the constructor thereby encrypting the password
     * immediately.
     * @param password
     * @return 
     */
    protected final String encryptPassword(String password) {
        StringBuilder hexString = new StringBuilder(); //used to create to returnString
        
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
     * Query NEEDED!!
     * @return 
     */
    protected final boolean userExists() {
        return true;
    }
       
}
