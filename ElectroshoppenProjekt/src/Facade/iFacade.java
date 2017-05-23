/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import ProductStuff.Product;
import ProductStuff.ProductCategory;
import java.util.ArrayList;

/**
 *
 * @author rune_
 */
public interface iFacade {
    String getToken();
    
    long getProductNumber();
    
    double getPiecePrice();
    
    String getProductName();
    
    ProductCategory getProductCategory();
    
    Product searchProduct(long prdNum);
    
    ArrayList<Product> searchProductsFromText(String s);
    
    ArrayList<Product> getProductsFromCat(ProductCategory prdCat);   
    
    int getOrderNumber();
    
    String getStatus();
    
    double getTotalPrice();
    
    int getProductAmount();
    
    void addToOrder(Product p, int amount);
    void removeFromOrder(Product p, int amount);
    String showBasket();
    double getSubTotal();
}
