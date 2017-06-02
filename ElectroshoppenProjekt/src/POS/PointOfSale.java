/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS;

import DBManager.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class PointOfSale {

    public void pay() {

    }

    /**
     * Method to get info on customer. Takes email as input, and finds profile
     * in db with matching email.
     *
     * @param email Email as string of customer to find.
     * @return Returns a profile as type Profile.
     */
    public String[] getCustomerInfo(String email) {
	String[] foundProfile = new String[5];
	String query = "SELECT full_name, email, phone_number, cvr\n"
		+ "	FROM public.customer\n"
		+ "    WHERE email = '" + email + "';";
	DBConnection dbc = new DBConnection();
	ResultSet select = dbc.runQueryExcecute(query);
	try {
	    if (!select.next()) {
		 
	    } else {
		do {
		    String name = select.getString("full_name");
		    String mail = select.getString("email");
		    String phone = select.getString("phone_number");
		    String cvr = select.getString("cvr");
		    String fName = name.split(";")[0];
                    String lName = name.split(";")[1];
                    foundProfile[0] = fName;
		    foundProfile[1] = lName;
                    foundProfile[2] = mail;
		    foundProfile[3] = phone;
		    foundProfile[4] = cvr;
		} while (select.next());
		select.close();

	    }

	} catch (SQLException ex) {
	    Logger.getLogger(PointOfSale.class.getName()).log(Level.SEVERE, null, ex);
	}
	return foundProfile;
    }
    
    public int getAmountForOrderLine(long orderNumber) {
        int amount = 0;
        String query = "SELECT amount from order_line WHERE order_number = " + orderNumber + ";";
        
        DBConnection dbc = new DBConnection();
	ResultSet select = dbc.runQueryExcecute(query);
        
        try {
            while (select.next()) {
                amount = select.getInt("amount");
            }
        } catch (SQLException ex) {
            Logger.getLogger(PointOfSale.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return amount;
    }
    
    public void editAmountForOrderLine(long orderNumber, long productId, int amount) {
        String query = "UPDATE order_line SET amount = amount + " + amount +  " WHERE order_number = " + orderNumber + " AND product_id = " + productId + ";";
        
        DBConnection dbc = new DBConnection();
	dbc.runQueryUpdate(query);

    }
}
