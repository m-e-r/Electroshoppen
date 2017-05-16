/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductStuff;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.TreeMap;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;

/**
 *
 * @author Kasper
 */
public class ProductCatalog {
    private TreeMap<Long, Product> products; 
    private ArrayList<Product> categoryProducts;
    public ArrayList<Product> searchProducts;
    
    public ProductCatalog() {
        this.products = new TreeMap();
        this.fillProducts();
    }

    
    
    /**
     * Fill the Map with all products through a query.
     */
    private void fillProducts() {
        ResultSet rs  = DBManager.DBConnection.runQueryExcecute("SELECT * FROM Product");
        try{
            while(rs.next()){
                long productNum = rs.getInt("product_id");              
                String productName = rs.getString("name");
                int price = rs.getInt("price");
                String productCategory = rs.getString("category");
                
                this.products.put(productNum, new Product(productName, productNum, price, ProductCategory.valueOf(productCategory)));
            }
        } catch (SQLException exception){
            exception.printStackTrace();
        }
            
            
        
    }
    
    public ArrayList<Product> SearchProduct(String in){
            
            for(Product p : products.values()){
                String Searchprice = String.valueOf(p.getPiecePrice());
                if (p.getProductName().equals(in)){
                    this.searchProducts.add(p);
                } else if(p.getProductCategory().equals(in)){
                    this.searchProducts.add(p);
                } else if (Searchprice.equals(in)) {
                    this.searchProducts.add(p);
                } else if(p.getProductName().contains(in)){
                    this.searchProducts.add(p);
                }
            }
       return this.searchProducts;
    }
    
    public Product searchProduct(long prdNum) {
        return this.products.get(prdNum);
    }
    
    
    public ArrayList<Product> getProductsFromCat(ProductCategory prdCat) {
        
        for (Product product : this.products.values()) {
            if (product.getProductCategory().equals(prdCat)) {
                this.categoryProducts.add(product);
            }
        }        
        return this.categoryProducts;
    }
}
