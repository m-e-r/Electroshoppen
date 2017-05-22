/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS;

import DBManager.DBConnection;
import WEBSHOP.Profiles.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class POS {

    public void pay() {

    }

    /**
     * Method to get info on customer. Takes email as input, and finds profile in
     * db with matching email. 
     * @param email Email as string of customer to find.
     * @return Returns a profile as type Profile.
     */
    public Profile getCustomerInfo(String email) {
	Profile foundProfile = null;
	String query = "SELECT full_name, email, phone_number, cvr\n"
		+ "	FROM public.customer\n"
		+ "    WHERE email = '" + email + "';";
	DBConnection dbc = new DBConnection();
	ResultSet select = dbc.runQueryExcecute(query);
	try {
	    if (!select.next()) {
		System.out.println("no user");
	    } else {
		do {
		String name = select.getString("full_name");
		String mail = select.getString("email");
		String phone = select.getString("phone_number");
		String cvr = select.getString("cvr");
		foundProfile = new CustomerProfile(name, phone, mail, cvr);
		} while(select.next());
		select.close();
	    
	    }

	} catch (SQLException ex) {
	    Logger.getLogger(POS.class.getName()).log(Level.SEVERE, null, ex);
	}
	return foundProfile;
    }
}
