/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;

import Authentication.Token;
import ProductStuff.Product;
import ProductStuff.ProductCategory;
import java.util.ArrayList;
import PIM.*;
import WEBSHOP.Profiles.CustomerProfile;
import WEBSHOP.Profiles.OrderHistory;
import WEBSHOP.Profiles.Profile;
import java.util.HashMap;

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
    
    Long getOrderNumber();
    
    String getStatus();
    
    double getTotalPrice();
    
    int getProductAmount();
    
    void addToOrder(Product p, int amount);
    void removeFromOrder(Product p, int amount);
    String showBasket();
    double getSubTotal();
    
    //Webshop
    void setLoginForCustomer(Token token);
    
    
    //PIM
    void editName(long id, String newName);
    void editPrice(long id, double newPrice);
    void editDescription(long id, String newDescription);
    void editCategory(long id, String newCategory);
    void newProduct(String name, long number, double price, String description, ProductCategory category);
    boolean addProductToDatabase();
    void removeProduct(Product p);
    
    //POS
    String[] getCustomerInfo(String email);
    OrderHistory getOrderHistory(String email);
    HashMap<String, ArrayList<String>> getOrderLinesByOrder(String email);
    int getAmountForOrderLine(long orderNumber);
    void editAmountForOrderLine(long orderNumber, long productId, int amount);
    
}
