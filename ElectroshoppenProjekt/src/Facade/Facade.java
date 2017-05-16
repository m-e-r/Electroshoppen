/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;
import authentication.*;
import dbmanager.*;
import productStuff.*;
import webshop.*;
import webshop.order.*;
import webshop.profiles.*;
import elecetroshoppenprojekt.*;
import java.util.ArrayList;
import java.util.Date;



/**
 *
 * @author rune_
 */
public class Facade {
    private Authentication authentication;
    private Token token;
    private DBConnection dbConnection;
    private Product product;
    private ProductCatalog productCatalog;
    private ProductCategory productCategory;
    private Adress adress;
    private Order order;
    private OrderLine orderLine;
    private Payment payment;
    private CustomerProfile customerProfile;
    private EmployeeProfile employeeProfile;
    private OrderHistory orderHistory;
    private Profile profile;
    private Authenticateable authenticateable;
    private Webshop webshop;


    public boolean userExists(){
	authentication.userExists();
	return authentication;
    }
    public String getToken(){
	token.getToken();
	return token;
    }
    public long getProductNumber(){
	product.getProductNumber();
	return product;
    }
    public double getPiecePrice() {
        product.getPiecePrice();
	return product;
    }
        
    public String getProductName() {
        product.getProductName();
	return product;
    }
    
    public ProductCategory getProductCategory(){
        product.getProductCategory();
	return product;
    }
    public Product searchProduct(){
	productCatalog.searchProduct();
	return productCatalog;
    }
    public ArrayList<Product> getProductsFromCat(ProductCategory prdCat){
	productCatalog.getProductsFromCat();
	return productCatalog;
    }
    @Override
    public String toString(){
	adress.toString();
	return adress;
    }
    public int getOrderNumber(){
	order.getOrderNumber();
	return order;
    }
    public String getStatus(){
	order.getStatus();
	return order;
    }
    public double getTotalPrice(){
	order.getTotalPrice();
	return order;
    }
    public Date getDate(){
	order.getDate();
	return order;
    }
    public int getProductAmount(){
	orderLine.getProductAmount();
	return orderLine;
    }
    public double getAmountPrice(){
	orderLine.getAmountPrice();
	return orderLine;
    }
    public void saveProfileToText(){
	profile.saveProfileToText();
    }
    public void saveProfileToDB(){
	profile.saveProfileToDB();
    }
    public void viewProfile(String id){
	employeeProfile.viewProfile();
    }
    public boolean doLogin(){
	authenticateable.doLogin();
	return authenticateable;
    }
}
