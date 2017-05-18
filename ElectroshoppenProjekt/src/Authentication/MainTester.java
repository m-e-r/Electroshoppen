/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;


import Facade.Facade;
import Facade.iFacade;
import WEBSHOP.Adress;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 * For testing authentication only, should be removed.
 * @author Kasper
 */
public class MainTester {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        iFacade facade = new Facade();
        ArrayList<?> products = new ArrayList();
        
        products = facade.searchProductsFromText("o");
        
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString());
        }
    }
    
}
