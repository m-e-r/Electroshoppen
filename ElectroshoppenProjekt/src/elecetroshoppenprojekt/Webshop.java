/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elecetroshoppenprojekt;


import Authentication.Token;
import ProductStuff.Product;
import WEBSHOP.Order.OrderLine;
import WEBSHOP.Profiles.CustomerProfile;
import java.util.HashSet;



/**
 *
 * @author Kasper
 */
public class Webshop {
    private CustomerProfile customer;
    private String customerUserName;
    private OrderLine orderLine;
    
    
    public Webshop() {
        this.customer = new CustomerProfile();
    }
    
    //MARK: Login stuff
    public void setLoginForCustomer(Token token) {
        this.customer.setToken(token);
    }
    
    
    
    //MARK: Customer methods
    public void addToViewedProducts(Product p) {
        this.customer.addToViewedProducts(p);
    }
    
    public void addToOrder(Product p, int amount) {
        this.customer.getOrder().addOrderLine(p, amount);
    }
    
    public void deleteFromOrder(Product p, int amount) {
        this.customer.getOrder().removeOrderLine(p, amount);
    }
    
//    public HashSet<Product> getViewedProducts() {
//        
//    }
}
