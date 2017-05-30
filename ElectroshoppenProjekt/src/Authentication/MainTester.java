/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;


import Facade.Facade;
import Facade.iFacade;
import WEBSHOP.Address;
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
//        iFacade facade = new Facade();
//        ArrayList<?> products = new ArrayList();
//        
//        products = facade.searchProductsFromText("o");
//        
//        for (int i = 0; i < products.size(); i++) {
//             
//        }

	    Address ad = new Address("StreetName1", "3", "Sec", "2234", "city2");
	    Create c = new Create("TestPerson2", "mail2@mail2.dk", "88888888", ad, "pass", "2323232");
	    c.createUser("customer");
    }
    
}
