/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elecetroshoppenprojekt;

import Authentication.Token;
import ProductStuff.Product;
import ProductStuff.ProductCategory;
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
    
    public String pay() {
       return this.customer.getOrder().pay();
    }
    
    //MARK: Customer methods
    public void addToViewedProducts(Product p) {
        this.customer.addToViewedProducts(p);
    }
    
    public void addToOrder(Product p, int amount) {
        this.customer.getOrder().addOrderLine(p, amount);
    }
    
    public void removeFromOrder(Product p, int amount) {
        this.customer.getOrder().removeOrderLine(p, amount);
    }
    
    public String showBasket() {
        return this.customer.getOrder().showBasket();
    }
            
    
//    public HashSet<Product> getViewedProducts() {
//        
//    }
    
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


