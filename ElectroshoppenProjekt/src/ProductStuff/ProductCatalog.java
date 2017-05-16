/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductStuff;

import DBManager.DBConnection;
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
        DBConnection dbCon = new DBConnection();
        String query = "SELECT * FROM products";
        ResultSet rs = dbCon.runQueryExcecute(query);

        try{
            while(rs.next()){
                long productNum = rs.getInt("product_id");              
                String productName = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String productCategory = rs.getString("category");
                
                this.products.put(productNum, new Product(productName, productNum, price, description, ProductCategory.valueOf(productCategory)));
            }
        } catch (SQLException exception){
            exception.printStackTrace();
        }
            
        
    }
    
    public ArrayList<Product> SearchProduct(String in){
        this.searchProducts = new ArrayList();
        
            
            for(Product p : products.values()){
                String searchPrice = String.valueOf(p.getPiecePrice()); //Price as String
                
                if (p.getProductName().equalsIgnoreCase(in)){ //Equals name
                    this.searchProducts.add(p);
                    
                } else if(p.getProductCategory().toString().equalsIgnoreCase(in)){ //Equals category
                    this.searchProducts.add(p);
                    
                } else if (searchPrice.equals(in)) { //Equals price
                    this.searchProducts.add(p);
                    
                } else if(p.getProductName().contains(in)){ //Name contains search word NEEDS TO IGNORE CASE
                    this.searchProducts.add(p);
                }
                
            }
       return this.searchProducts;
    }
    

    public Product searchProduct(long prdNum) {
        return this.products.get(prdNum);
    }
    
    /**
     * Used when
     * @param prdCat
     * @return 
     */
    public ArrayList<Product> getProductsFromCat(ProductCategory prdCat) {
        
        for (Product product : this.products.values()) {
            if (product.getProductCategory().equals(prdCat)) {
                this.categoryProducts.add(product);
            }
        }        
        return this.categoryProducts;
    }
    
}
