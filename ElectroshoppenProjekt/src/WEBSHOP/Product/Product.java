/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Product;

/**
 *
 * @author Kasper
 */
public class Product {
    private String productName;
    private long productNumber; //ID in db
    private double piecePrice;
    private String description;
    private ProductCategory prdCat;
    

    public Product(String productName, long productNumber, 
            double piecePrice, String description, ProductCategory prdCat) {
        
        this.productName = productName;
        this.productNumber = productNumber;
        this.piecePrice = piecePrice;
        this.description = description;
        this.prdCat = prdCat;
    }
    
    
    //Getters
    public long getProductNumber() {
        return this.productNumber;
    }
    
    public double getPiecePrice() {
        return this.piecePrice;
    }
        
    public String getProductName() {
        return this.productName;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public ProductCategory getProductCategory() {
        return this.prdCat;
    }
    
    /**
     * Used to send product information to the GUI without it knowing about the
     * Product class.
     * @return Product as a String description.
     */
    @Override
    public String toString() {
        return this.productName + ";" + this.piecePrice + ";" + this.description + ";" + this.prdCat + ";" + this.productNumber;
    }
}
