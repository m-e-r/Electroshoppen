/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductStuff;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author Kasper
 */
public class ProductCatalog {
    private TreeMap<Long, Product> products; 
    private ArrayList<Product> categoryProducts;
    
    public ProductCatalog() {
        this.products = new TreeMap();
        this.fillProducts();
    }
    
    /**
     * Fill the Map with all products through a query.
     */
    private void fillProducts() {
        
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
