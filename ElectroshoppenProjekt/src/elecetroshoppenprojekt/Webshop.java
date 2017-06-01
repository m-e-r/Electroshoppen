/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elecetroshoppenprojekt;

import Authentication.Token;
import WEBSHOP.Product.Product;
import WEBSHOP.Address;
import WEBSHOP.Order.OrderLine;
import WEBSHOP.Product.ProductCatalog;
import WEBSHOP.Product.ProductCategory;
import WEBSHOP.Profiles.CustomerProfile;
import WEBSHOP.Profiles.Profile;
import java.util.ArrayList;

/**
 * Class functions as a controller for the WEBSHOP package, and its methods
 * are called from the GUI package through the Facade package.
 * @author Kasper
 */
public class Webshop {

    static void main(String[] args) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    private CustomerProfile customer;
    private ProductCatalog pc;

    public Webshop() {
	this.customer = new CustomerProfile();
        this.pc = new ProductCatalog();
    }
    
    /**
     * Method sets the customer's Token.
     * Should be called when when the user logs in.
     * @param token should be the return value from doLogin() in Login class.
     */
    public void setLoginForCustomer(Token token) {
	this.customer.setToken(token);
	this.customer.getOrder().setEmail(this.customer.geteMail());
    }
    
    public String getToken() {
        return this.customer.getToken();
    }
    
    /**
     * Calls the pay method on the customer's Order.
     * @return See pay() method in Order class.
     */
    public String pay() {
	return this.customer.getOrder().pay();
    }

    /**
     * Method should be removed as the requirements for the system has changed
     * due to new law regulations.
     * @param p 
     */
    public void addToViewedProducts(Product p) {
	this.customer.addToViewedProducts(p);
    }
    
    /**
     * Calls the addOrderLine(...) method on the Customer's Order.
     * Also checks if the customer has been logged out to then reset the Order.
     * @param p Product wished to be added
     * @param amount Amount wished to be added
     */
    public void addToOrder(Product p, int amount) {

	if ("Expired".equals(this.customer.getToken())) {
	    this.customer.getOrder().resetOrder();
	}

	this.customer.getOrder().addOrderLine(p, amount);
    }    
    
    /**
     * Calls the removeOrderLine(...) method on the Customer's Order.
     * Also checks if the customer has been logged out to then reset the Order.
     * @param p Product wished to be removed
     * @param amount Amount wished to be removed
     */
    public void removeFromOrder(Product p, int amount) {
	if (this.customer.getToken().equals("Expired")) {
	    this.customer.getOrder().resetOrder();
	}

	this.customer.getOrder().removeOrderLine(p, amount);
    }
    
    /**
     * Calls the showBasket() method on the Customer's Order.
     * Also checks if the customer has been logged out to then reset the Order.
     * @return See showBasket() method in Order class.
     */
    public String showBasket() {
	if (this.customer.getToken().equals("Expired")) {
	    this.customer.getOrder().resetOrder();
	}

	return this.customer.getOrder().showBasket();
    }
    
    
    public void updateProfile(String name, String email, String phone, String cvr) {
	this.customer.updateProfile(name, email, phone, cvr);
    }
    
    public String[] searchProfile(String email) {
	return this.customer.searchProfile(email);
    }

    public String[] getAddressArray(String email) {
	return this.customer.getAddressArray(email);
    }

    public Address getAddress() {
	return this.customer.getAddress();
    }

    public void setAddress(String streetName, String streetNumber, String secAddress, String zipCode,
	    String city) {
	this.customer.setAddress(streetName, streetNumber, secAddress, zipCode, city);
    }

    public boolean isValid() {
	return this.customer.isValid();
    }
    
    /**
     * Sets a new CustomerProfile object after resetting the current Order.
     */
    public void setNewCustomer() {
	this.customer.getOrder().resetOrder();
	this.customer = new CustomerProfile();
    }
    
    public Profile getCustomerProfile(){
	return this.customer;
    }
    
    public Product searchProduct(long prdNum) {
        return this.pc.searchProduct(prdNum);
    }
    
    public ArrayList<Product> searchProductsFromText(String in) {
        return this.pc.searchProductsFromText(in);
    }
    
    public ArrayList<Product> getProductsFromCat(ProductCategory prdCat) {
        return this.pc.getProductsFromCat(prdCat);
    }

}
