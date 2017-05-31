/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Product;

import DBManager.DBConnection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.TreeMap;

/**
 * Class responsible for fetching all products from the database and provide
 * search functions to find these.
 * @author Kasper
 */
public class ProductCatalog {
    private TreeMap<Long, Product> products; 
    private ArrayList<Product> categoryProducts;
    public ArrayList<Product> searchProducts;

    
    /**
     * Loads in the products when instantiated.
     */
    public ProductCatalog() {
        this.products = new TreeMap();
        this.fillProducts();
    }

    
    
    /**
     * Takes a query from the database, returning all the the products in the 
     * database and puts them into the TreeMap "products".
     */
    private void fillProducts() {
        DBConnection dbCon = new DBConnection(); //Creates an instance of the databasemanager
        String query = "SELECT * FROM product"; //The query, which the ResultSet will use
        ResultSet rs = dbCon.runQueryExcecute(query); //The ResultSet then uses the query to run
        
        try{
            while(rs.next()){ //Iterates through the ResultSet and matches the variables below with the column attributes.
                long productNum = rs.getInt("product_id");              
                String productName = rs.getString("name");
                double price = rs.getDouble("price");
                String description = rs.getString("description");
                String productCategory = rs.getString("category").toUpperCase();
		ProductCategory pCategory = (ProductCategory.valueOf(productCategory));
                
                if(Arrays.asList(ProductCategory.values()).contains(pCategory)){
                    this.products.put(productNum, new Product(productName, productNum, price, description, pCategory)); //Adds it to the TreeMap
                }else {
                    System.err.println("'" + productCategory + "' is not found in the database");
                }
                
            }
        } catch (SQLException exception){
        }
            
        
    }
    /**
     * Iterates through the list of products, checks if any of the attributes 
     * of the products in that list match with the search text and adds 
     * these to a new arrayList.
     * @param in Takes the search text as an input in the form of a String
     * @return returns a list of products matching the search text
     */
    public ArrayList<Product> searchProductsFromText(String in){
        this.searchProducts = new ArrayList();

            for(Product p : products.values()){
                
                if (p.getProductName().equalsIgnoreCase(in)){ //Equals name
                    this.searchProducts.add(p);
                    
                } else if(p.getProductCategory().toString().equalsIgnoreCase(in)){ //Equals category
                    this.searchProducts.add(p);
                    
                } else if (p.getDescription().toLowerCase().contains(in.toLowerCase())) { //Search String is found in the description
                    this.searchProducts.add(p);
                    
                } else if(p.getProductName().toLowerCase().contains(in.toLowerCase())){ //Name contains search String
                    this.searchProducts.add(p);
                }
                
            }

       return this.searchProducts;
    }
    
    /**
     * Quickly finds a product based on its product id.
     * @param prdNum
     * @return 
     */
    public Product searchProduct(long prdNum) {
        return this.products.get(prdNum);
    }
    
    /**
     * Should be used when sorting products based on their category. 
     * Might not be implemented yet..
     * @param prdCat
     * @return 
     */
    public ArrayList<Product> getProductsFromCat(ProductCategory prdCat) {
        
        for (Product product : this.products.values()) {
            if (product.getProductCategory().equals(prdCat)) { //Replace with switch case
                this.categoryProducts.add(product);
            }
        }        
        return this.categoryProducts;
    }
    
}
