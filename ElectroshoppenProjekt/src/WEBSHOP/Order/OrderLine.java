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
    private Product product;
    
    public OrderLine(int productAmount, double amountPrice, Product product) {
        
        this.productAmount = productAmount;
        this.amountPrice = amountPrice;
        this.product = product;
    }
    
    @Override
    public String toString() {
        
        return "Orderline: \t" + getProductAmount() + "\t" + getAmountPrice();
    }

    /**
     * @return the productAmount
     */
    public int getProductAmount() {
        return productAmount;
    }

    /**
     * @return the amountPrice
     */
    public double getAmountPrice() {
        return product.getPiecePrice()*productAmount;
    }
}
