/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

import DBManager.DBConnection;
import WEBSHOP.Address;
import WEBSHOP.Profiles.CustomerProfile;
import WEBSHOP.Profiles.EmployeeProfile;
import WEBSHOP.Profiles.Profile;

/**
 * Class that holds responsibility for creating and removing users fromt the database.
 * @author Kasper
 */
public class Create extends Authentication {

    private Profile profile;
    private String phoneNumber;
    private String eMail;
    private Address adress;
    private String cvr;
    private String fullName;
    

    /**
     * Constructor used when creating a new user in the database, and should 
     * therefor take in the same parameters as the Profile class.
     * @param fullName
     * @param eMail
     * @param phoneNumber
     * @param address
     * @param password
     * @param cvr 
     */
    public Create(String fullName, String eMail, String phoneNumber, Address address, String password, String cvr) {
	super(eMail, password);
	this.phoneNumber = phoneNumber;
	this.eMail = eMail;
        this.fullName = fullName;
	this.adress = address;
	this.cvr = cvr;
    }
    
    
    /**
     * Constructer used when a user is wished to be deleted.
     * @param eMail
     * @param password 
     */
    public Create(String eMail, String password) {
	super(eMail, password);
    }

    /**
     * Method checks whether or not the user exists in the database, and saves it
     * there if not.
     * @param type Must be customer or employee, else an IllegalArgumentException is thrown
     * @return True if user succesfullt created and saved to the database.
     * false if user already exists in the database.
     * 
     */
    public boolean createUser(String type) {
	//Create new Profile instance based on given type
	String typeLower = type.toLowerCase();
	if (typeLower.equals("customer")) {
	    this.profile = new CustomerProfile(this.fullName, this.phoneNumber,
		    this.eMail, this.adress, super.password, this.cvr);

	} else if (typeLower.equals("employee")) {
	    this.profile = new EmployeeProfile(this.fullName, this.phoneNumber,
		    this.eMail, this.adress, super.password);

	} else {
	    throw new IllegalArgumentException("Type must be customer or employee");
	}
	
        //Ask the instance to save itself to the database    
	if (!super.userExists()) {
	    this.profile.saveProfileToDB();
	    return true;

	} else {
	    return false;
	}
    }
    
    
    /**
     * Method checks whether or not the user exists in the database, and deletes
     * it if so.
     * @param type Must be customer or employee, else an IllegalArgumentException is thrown
     * @return True if the user is succesfully deleted from the database.
     * false if the user does not exist in the database.
     */
    public boolean deleteUser(String type) {
	String typeLower = type.toLowerCase();
	String query = "";
        
        if (super.userExists()) {
            
            //Delete customer profile query
            if (typeLower.equals("customer")){
                query = "DELETE FROM customer WHERE password = '" 
                        + super.password + "' AND email = '" 
                        + super.email + "';";
                
            //Delete employee profile query  
            } else if (typeLower.equals("employee")){
                query = "DELETE FROM customer WHERE password = '" 
                        + super.password + "' AND email = '" 
                        + super.email + "';";
            } else {
                throw new IllegalArgumentException("Type must be customer or employee");
            }
        } else {
            return false;
        }
	
        //Actually run the query
	DBConnection dbc = new DBConnection();
	dbc.runQueryUpdate(query);
	return true;

    }
    
    
    /**
     * Do not use this method.
     * Meant for Login class.
     * @return false
     */
    @Override
    public boolean doLogin() {
        return false;
    }
    
    /**
     * Do not use this method.
     * Meant for Login class.
     * @return false
     */
    @Override
    public boolean doLogout() {
        return false;
    }

}
