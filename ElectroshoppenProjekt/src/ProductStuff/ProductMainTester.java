/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductStuff;

import java.util.ArrayList;

/**
 * Used only to test product related stuff.
 * Everything in here can be deleted.
 * @author Kasper
 */
public class ProductMainTester {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ProductCatalog prdCat;
        
        prdCat = new ProductCatalog();
        
        ArrayList<Product> products = new ArrayList();
        
        products = prdCat.SearchProduct("ook");
        System.out.println(products.size());
        
        for (Product p : products) {
            System.out.println(p.getProductName());
        }
        
    }
    
}
