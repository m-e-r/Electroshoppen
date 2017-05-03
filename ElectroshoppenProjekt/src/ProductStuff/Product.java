/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductStuff;

/**
 *
 * @author Kasper
 */
public class Product {
    private String productName;
    private long productNumber;
    private double piecePrice;
    private ProductCategory prdCat;
    
    public Product(String productName, long productNumber, 
            double piecePrice, ProductCategory prdCat) {
        
        this.productName = productName;
        this.productNumber = productNumber;
        this.piecePrice = piecePrice;
        this.prdCat = prdCat;
    }
    
    
    //Getters
    public long getProdcutNumber() {
        return this.productNumber;
    }
    
    public double getPiecePrice() {
        return this.piecePrice;
    }
        
    public String getProductName() {
        return this.productName;
    }
    
    public ProductCategory getProductCategory() {
        return this.prdCat;
    }
}
