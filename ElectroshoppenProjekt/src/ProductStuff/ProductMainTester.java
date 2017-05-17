/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProductStuff;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

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
        Date date = new Date();
        ArrayList<Product> products = new ArrayList();
        Scanner sc = new Scanner(System.in);
        
        prdCat = new ProductCatalog(); 
        
        //Search products through the console!  
        String searchWord;
        do {
            System.out.println("Type a search word!");
            searchWord = sc.next();
            products = prdCat.SearchProduct(searchWord); 
            
            if (products.isEmpty()) {
                System.out.println("\nNo results found. Type 0 to exit.");
                
            } else {
                System.out.println("\n" + products.size() + " Results found:");
            }
            
            for (Product p : products) {
                System.out.println(p.getProductName());
            }
            
            System.out.println("\n");
            
            
        } while (!searchWord.equals("0"));
                   

        
        


    }
    
}
