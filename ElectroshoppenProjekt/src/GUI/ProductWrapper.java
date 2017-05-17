/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import ProductStuff.Product;
import ProductStuff.ProductCategory;

/**
 *
 * @author MER
 */
public class ProductWrapper {
    private Product product;
    
    public ProductWrapper (Product product) {
        this.product = product;
    }
    
    public long getProductNumber() {
        return this.product.getProductNumber();
    }
    
    public double getPiecePrice() {
        return this.product.getPiecePrice();
    }
        
    public String getProductName() {
        return this.product.getProductName();
    }
    
    public String getDescription() {
        return this.product.getDescription();
    }
    
    public ProductCategory getProductCategory() {
        return this.product.getProductCategory();
    }
            
}
