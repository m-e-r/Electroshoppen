/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Order;

import ProductStuff.Product;

/**
 *
 * @author Bruger
 */
public class OrderLine {
    
    private int productAmount;
    private double amountPrice;
    private String productName;
    private long productNumber;
    
    
    
    public OrderLine(Product product, int amount) {
        this.productName = product.getProductName();
        this.productNumber = product.getProductNumber();
        this.productAmount += amount;
        this.amountPrice = product.getPiecePrice();
    }
    
    

    //Getters
    public int getProductAmount() {
        return productAmount;
    }

    public double getSubTotal() {
        return this.amountPrice * this.productAmount;
    }
    
    public long getProductNumber() {
        return this.productNumber;
    }
    
    
    
    //Setters and adders
    public void setProductAmount(int amount) {
        this.productAmount = amount;
    }
    
    public void addProductAmount(int amount) {
        this.productAmount += amount;
    }
    
    public void removeProductAmount(int amount) {
        this.productAmount -= amount;
    }

    
    
    
    @Override
    public String toString() {
        
        return "Orderline: \t" + getProductAmount() + "\t" + getSubTotal();
    }
}
