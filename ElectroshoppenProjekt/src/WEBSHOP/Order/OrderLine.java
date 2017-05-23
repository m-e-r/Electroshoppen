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
    
    public String getProductName() {
        return this.productName;
    }
    
    
    
    //Setters, removers and adders
    public void setProductAmount(int amount) {
        this.productAmount = amount;
    }
    
    public void addProductAmount(int amount) {
        this.productAmount += amount;
    }
    
    /**
     * Removes the given amount from the OrderLine.
     * @param amount
     * @return False if the given amount will result in a negative value.
     * True if not.
     */
    public boolean removeProductAmount(int amount) {
        if ((this.productAmount - amount) < 0) {
            return false;
            
        } else {
            this.productAmount -= amount;
            return true;
        }
        
    }

    
    @Override
    public String toString() {
        
        return this.getProductName() + "\t" + this.getProductAmount() + "\t" + this.getSubTotal();
    }
}
