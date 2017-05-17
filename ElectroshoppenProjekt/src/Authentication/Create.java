/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

import DBManager.DBConnection;
import WEBSHOP.Adress;
import WEBSHOP.Profiles.CustomerProfile;
import WEBSHOP.Profiles.EmployeeProfile;
import WEBSHOP.Profiles.Profile;

/**
 *
 * @author Kasper
 */
public class Create extends Authentication {

    private Profile profile;
    private String phoneNumber;
    private String eMail;
    private Adress adress;
    private String cvr;

    public Create(String userName, String phoneNumber, String eMail, Adress adress, String password, String cvr) {
	super(userName, password);
	this.phoneNumber = phoneNumber;
	this.eMail = eMail;
	this.adress = adress;
	this.cvr = cvr;
    }

    public Create(String userName, String password) {
	super(userName, password);
    }

    /**
     *
     * @return
     */
    public String createUser(String type) {

	//Create new Profile instance based on given type
	String typeLower = type.toLowerCase();
	if (typeLower.equals("customer")) {
	    this.profile = new CustomerProfile(super.userName, this.phoneNumber,
		    this.eMail, this.adress, super.password, this.cvr);

	} else if (typeLower.equals("employee")) {
	    this.profile = new EmployeeProfile(super.userName, this.phoneNumber,
		    this.eMail, this.adress, super.password);

	} else {
	    return "No such type of profile.";
	}
	//Ask the instance to save itself to the database    

	if (!super.userExists()) {
	    this.profile.saveProfileToDB();
	    return "Should be saved";

	} else {
	    return "Profile already exists";
	}
    }

    public String deleteUser(String type) {
	String typeLower = type.toLowerCase();
	String query = "";
	if (typeLower.equals("customer")){
	    query = "DELETE FROM customer WHERE password = '" 
		    + super.password + "' AND phone_number = '" 
		    + super.userName + "';";
	} else if (typeLower.equals("employee")){
	    query = "DELETE FROM customer WHERE password = '" 
		    + super.password + "' AND phone_number = '" 
		    + super.userName + "';";
	} else {
	    return "No such type of profile";
	}
	
	DBConnection dbc = new DBConnection();
	dbc.runQueryUpdate(query);
	return "Profile deleted succesfully";

    }

}
