/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Profiles;

import Authentication.Token;
import DBManager.DBConnection;
import WEBSHOP.Product.Product;
import WEBSHOP.Address;
import WEBSHOP.Order.Order;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class represents a customer on the webshop.
 * @author Jacob
 */
public class CustomerProfile extends Profile {
    private String cvr;
    private Token token;
    private Order currentOrder;
    private OrderHistory orderHistory;
    private HashSet<Product> viewedProducts;
    
    /**
     * Constructor used to initialize the initial object on the Webshop class.
     */
    public CustomerProfile() {
	this.viewedProducts = new HashSet();
	this.currentOrder = new Order();
        this.token = new Token("default");
    }
    
    /**
     * Constructor used when creating a new customer.
     * Also saves the profile to the database through saveProfileToDB().
     * @param name
     * @param phoneNumber
     * @param eMail
     * @param address
     * @param passWord
     * @param cvr 
     */
    public CustomerProfile(String name, String phoneNumber, String eMail, Address address,
	    String passWord, String cvr) {
	super(name, phoneNumber, eMail, address, passWord);
	this.cvr = cvr;
	this.saveProfileToDB();
	currentOrder = new Order();
	currentOrder.setEmail(eMail);
    }
    

    public CustomerProfile(String name, String phoneNumber, String eMail, String cvr) {
	super(name, phoneNumber, eMail);
	this.cvr = cvr;
	this.saveProfileToDB();
	this.currentOrder = new Order();
	this.currentOrder.setEmail(eMail);
    }


    @Override
    public void saveProfileToDB() {

	Address address = this.getAddress();
	String query = "INSERT INTO public.adress(\n"
		+ "	email, street_name, city, postal, street_number, secadress)\n"
		+ "	VALUES ('" + this.geteMail() + "', '" + address.getStreetName() + "', '" + address.getCity() + "', '"
		+ Integer.parseInt(address.getZipCode()) + "', '" + Integer.parseInt(address.getStreetNumber()) + "', '"
		+ address.getSecAddress() + "');\n"
		+ "\n"
		+ "INSERT INTO public.customer(\n"
		+ "	full_name, password, email, phone_number, cvr)\n"
		+ "	VALUES ('" + this.getName() + "', '" + this.getPassword() + "', '"
		+ this.geteMail() + "', '" + this.getPhoneNumber() + "', '" + this.cvr + "');";

	DBConnection dbc = new DBConnection();
	dbc.runQueryUpdate(query);

    } 
    
    /**
     * Finds a profile in the database based on the given email and returns
     * the information as a String array.
     * @param email Email for the wished profile
     * @return full name, password, email and phone number 
     */
    @Override
    public String[] searchProfile(String email) {
	String query = "SELECT full_name, password, email, phone_number, cvr\n"
		+ "FROM public.customer WHERE email = '" + email + "';";
	DBConnection dbc = new DBConnection();
	String[] sArray = new String[4];
	 

	try {
	    ResultSet rs = dbc.runQueryExcecute(query);
	     
	    while (dbc.runQueryExcecute(query).next()) {
		 
		sArray[0] = dbc.runQueryExcecute(query).getString("full_name");
		sArray[1] = dbc.runQueryExcecute(query).getString("password");
		sArray[2] = dbc.runQueryExcecute(query).getString("email");
		sArray[3] = dbc.runQueryExcecute(query).getString("phone_number");
		 
	    }
	} catch (SQLException ex) {
	    Logger.getLogger(CustomerProfile.class.getName()).log(Level.SEVERE, null, ex);
	}
	return sArray;
    }

    @Override
    public void updateProfile(String name, String email, String phone, String cvr) {
        Address address = this.getAddress();
	String query = "UPDATE public.customer\n"
		+ "	SET full_name='" + name + "', email='"
		+ email + "', phone_number='" + phone + "', cvr='" + cvr + "'\n"
		+ "	WHERE email='" + email + "';\n"
		+ "UPDATE public.adress \n"
		+ "SET email='" + email + "', "
                + "street_name='" + address.getStreetName() + "', city='" + address.getCity() + "', "
		+ "postal='" + Integer.parseInt(address.getZipCode()) + "', street_number="
		+ "'" + Integer.parseInt(address.getStreetNumber()) + "', secadress='"
                + address.getSecAddress() + "'"
                + "WHERE email='" + email +"';";
	DBConnection dbc = new DBConnection();
	dbc.runQueryUpdate(query);
    }
    
    public String[] getAddressArray(String email) {
        String[] array = new String[5];
        String query = "SELECT * FROM public.adress \n"
                + "WHERE email='"+email+"'";
        DBConnection dbc = new DBConnection();
        ResultSet rs = dbc.runQueryExcecute(query);
        try {
            while(rs.next()) {
                array[0] = rs.getString("street_name");
                array[1] = rs.getString("street_number");
                array[2] = rs.getString("secadress");
                array[3] = rs.getString("postal");
                array[4] = rs.getString("city");
                
                
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(CustomerProfile.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }

    public String getCvr() {
	return this.cvr;
    }

    public Order getOrder() {
	return this.currentOrder;
    }

    /**
     * Method should be removed as the requirements for the system has changed
     * due to new law regulations.
     * @param product 
     */    
    public void addToViewedProducts(Product product) {
	this.viewedProducts.add(product);
    }

    /**
     * Calls the method on the Token and checks if it is null before returning.
     * @return null if the token is null, else see getToken() in Token class.
     */
    public String getToken() {
        if (this.token != null) {
            
            return this.token.getToken();
            
        } else {
            return null;
        }
    }
    

    public boolean isValid() {
        return this.token.isValid();
    }

    public void setToken(Token token) {
	this.token = token;
    }

}
