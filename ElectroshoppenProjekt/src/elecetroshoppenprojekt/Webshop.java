/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elecetroshoppenprojekt;

import Authentication.Token;
import ProductStuff.Product;
import ProductStuff.ProductCategory;
import WEBSHOP.Address;
import WEBSHOP.Order.OrderLine;
import WEBSHOP.Profiles.CustomerProfile;
import WEBSHOP.Profiles.Profile;
import WEBSHOP.iWebshopLogin;
import java.util.HashSet;



/**
 *
 * @author Kasper
 */
public class Webshop implements iWebshopLogin{
    private CustomerProfile customer;
    private String customerUserName;
    private OrderLine orderLine;
    
    
    public Webshop() {
        this.customer = new CustomerProfile();
        System.out.println("Customer!");
    }
    
    //MARK: Login stuff
    @Override
    public void setLoginForCustomer(Token token) {
        System.out.println("Webshop " + token.getToken());
        this.customer.setToken(token);
    }
    
    public String pay() {
       return this.customer.getOrder().pay();
    }
    
    //MARK: Customer methods
    public void addToViewedProducts(Product p) {
        this.customer.addToViewedProducts(p);
    }
    
    public void addToOrder(Product p, int amount) {
        
        if ("Expired".equals(this.customer.getToken())) {
            this.customer.getOrder().resetOrder();
        }
        
        this.customer.getOrder().addOrderLine(p, amount);
    }
    
    public void removeFromOrder(Product p, int amount) {
        if (this.customer.getToken().equals("Expired")) {
            this.customer.getOrder().resetOrder();
        }
        
        this.customer.getOrder().removeOrderLine(p, amount);
    }
    
    public String showBasket() {
        if (this.customer.getToken().equals("Expired")) {
            this.customer.getOrder().resetOrder();
        }
        
        return this.customer.getOrder().showBasket();
    }
    
    public void updateProfile(String name, String email, String phone, String cvr) {
        this.customer.updateProfile(name,email,phone,cvr);
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
    
    
    public static void main(String[] args) {
        Webshop webshop = new Webshop();
        
        webshop.addToOrder(new Product("testProdukt1", 12, 1500, "Dette er et test produkt nummer 1.", ProductCategory.COMPUTER), 1);
        webshop.addToOrder(new Product("testProdukt2", 13, 800, "Dette er et test produkt nummer 2.", ProductCategory.COMPUTER), 3);
        System.out.println(webshop.customer.getOrder().toString());
        
        webshop.removeFromOrder(new Product("testProdukt2", 13, 800, "Dette er et test produkt nummer 2.", ProductCategory.COMPUTER), 1);
        System.out.println(webshop.customer.getOrder().toString());
        
        System.out.println(webshop.pay());
        
        System.out.println(webshop.customer.getOrder().showBasket());
        
    }
}


