/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facade;
import elecetroshoppenprojekt.*;
import ProductStuff.Product;
import ProductStuff.ProductCategory;
import Authentication.*;
import DBManager.*;
import PIM.ProductEditing;
import ProductStuff.*;
import WEBSHOP.*;
import WEBSHOP.Order.*;
import WEBSHOP.Profiles.*;
import java.util.ArrayList;
import java.util.Date;



/**
 *
 * @author rune_
 */
public class Facade implements iFacade{
    private Authentication authentication;
    private Token token;
    private DBConnection dbConnection;
    private Product product;
    private ProductCatalog productCatalog;
    private ProductCategory productCategory;
    private Address adress;
    private Order order;
    private OrderLine orderLine;
    private Payment payment;
    private CustomerProfile customerProfile;
    private EmployeeProfile employeeProfile;
    private OrderHistory orderHistory;
    private Profile profile;
    private Webshop webshop;
    private ProductEditing pimEdit;
    
    public Facade() {
        this.productCatalog = new ProductCatalog();
        this.webshop = new Webshop();
        this.pimEdit = new ProductEditing();
    }


    @Override
    public String getToken(){
	return token.getToken();
    }
    
    @Override
    public long getProductNumber(){
	return product.getProductNumber();
    }
    
    @Override
    public double getPiecePrice() {
        return product.getPiecePrice();
    }
        
    @Override
    public String getProductName() {
        return product.getProductName();
    }
    
    @Override
    public ProductCategory getProductCategory(){
        return product.getProductCategory();
    }
    
    @Override
    public Product searchProduct(long prdNum){
	return productCatalog.searchProduct(prdNum);
    }
    
    @Override
    public ArrayList<Product> searchProductsFromText (String in) {
        return productCatalog.searchProductsFromText(in);
    }
    
    
    @Override
    public ArrayList<Product> getProductsFromCat(ProductCategory prdCat){
	return productCatalog.getProductsFromCat(prdCat);
    }
    @Override
    public Long getOrderNumber(){
	return order.getId();
    }
    @Override
    public String getStatus(){
	return order.getStatus();
    }
    @Override
    public double getTotalPrice(){
	return order.getTotalPrice();
    }
    @Override
    public int getProductAmount(){
	return orderLine.getProductAmount();
    }
    @Override
    public double getSubTotal(){
	return orderLine.getSubTotal();
    }
    @Override
    public void addToOrder(Product p, int amount) {
        this.webshop.addToOrder(p, amount);
    }
    @Override
    public void removeFromOrder(Product p, int amount) {
        this.webshop.removeFromOrder(p, amount);
    }
    @Override
    public String showBasket() {
        return this.webshop.showBasket();
    }
    
    
    //PIM
    @Override
    public void editName(long id, String newName) {
        this.pimEdit.editName(id, newName);
    }

    @Override
    public void editPrice(long id, double newPrice) {
        this.pimEdit.editPrice(id, newPrice);
    }

    @Override
    public void editDescription(long id, String newDescription) {
        this.pimEdit.editDescription(id, newDescription);
    }

    @Override
    public void editCategory(long id, String newCategory) {
        this.pimEdit.editCategory(id, productCategory);
    }

}
