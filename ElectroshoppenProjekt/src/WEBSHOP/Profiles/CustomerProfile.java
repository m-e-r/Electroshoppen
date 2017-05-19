/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Profiles;

import WEBSHOP.Adress;
import Authentication.Token;
import DBManager.DBConnection;
import ProductStuff.Product;
import WEBSHOP.Order.Order;
import WEBSHOP.Order.OrderLine;
import WEBSHOP.Order.Status;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jacob
 */
public class CustomerProfile extends Profile {
    
    private String cvr;
    private Token token;
    private Order currentOrder;
    private OrderHistory orderHistory;
    private HashSet<Product> viewedProducts;
    
    public CustomerProfile() {
        this.viewedProducts = new HashSet();
    }
    
    public CustomerProfile(String name, String phoneNumber, String eMail, Adress adress, 
	    String passWord, String cvr) {
	super(name, phoneNumber, eMail, adress, passWord);
	this.cvr = cvr;
    }

    @Override
    public void saveProfileToText() {
	File file = new File("Customer_Profiles.txt"); //Put .txt file outside src folder.
	System.out.println(file.getAbsolutePath());
	try (FileWriter fileW = new FileWriter(file, true);
		BufferedWriter bufferedW = new BufferedWriter(fileW);
		PrintWriter output = new PrintWriter(bufferedW)) {
	    output.println(this.toString() + "\n"); //write here what should be inserted
	} catch (IOException ex) {
	    Logger.getLogger(EmployeeProfile.class.getName()).log(Level.SEVERE, null, ex);
	}
    }

    @Override
    public void saveProfileToDB() {
	
	Adress adress = this.getAdress();
	String query = "INSERT INTO public.adress(\n"
		+ "	phone_number, street_name, city, postal, floor, door, street_number)\n"
		+ "	VALUES ('" + this.getPhoneNumber() + "', '" + adress.getStreetName() + "', '" + adress.getCity() + "', '"
		+ adress.getZipCode() + "', '" + adress.getFloor() + "', '" + adress.getDoor() + "', '"
		+ adress.getStreetNumber() + "');\n"
		+ "\n" 
		+ "INSERT INTO public.customer(\n"
		+ "	full_name, password, email, phone_number, cvr)\n"
		+ "	VALUES ('" + this.getName() + "', '" + this.getPassword() + "', '" 
		+ this.geteMail() + "', '" + this.getPhoneNumber() + "', '" + this.cvr +"');";

	DBConnection dbc = new DBConnection();
	dbc.runQueryUpdate(query);
	
    }
    
    public Order getOrder() {
        return this.currentOrder;
    }
    
    public void createOrder(OrderLine orderLine) {
        this.currentOrder = new Order(orderLine);
    }
    
    private void addToOrder(OrderLine orderLine) {
        if (this.currentOrder == null) {
            this.currentOrder = new Order(orderLine);
            
        } else {
            this.currentOrder.addOrderline(orderLine);
        }
    }
    
    public void addToViewedProducts(Product product) {
        this.viewedProducts.add(product);
    }
    
}
