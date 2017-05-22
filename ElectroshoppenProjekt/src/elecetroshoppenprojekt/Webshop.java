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
    
    
    Webshop() {
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
    
    /**
     * Adds product and amount to an orderline with a check to see if the product already exists in the orderline.
     * @param p represents the product being added to the orderline
     * @param amount represents the amount of products being added to the product line
     */ 
    public void addToOrder(Product p, int amount) {
        this.orderLine = new OrderLine(p, amount);
        
        //Check if customer has an Order
        if (this.customer.getOrder() == null) {
            this.customer.createOrder(this.orderLine);
            
            
        //Check if the Order has an OrderLine with the product already
        } else if (!this.customer.getOrder().addToOrderLine(p.getProductNumber(), amount)){
           
                         
            this.customer.getOrder().addOrderline(this.orderLine);  
        }
        
        
        
   
    }
    
    public void deleteFromOrder(Product p, int amount) {
        if(!this.customer.getOrder().removeFromOrderLine(p.getProductNumber(), amount)){
            this.orderLine.removeProductAmount(amount);
            
        }
    }
    
//    public HashSet<Product> getViewedProducts() {
//        
//    }
}
