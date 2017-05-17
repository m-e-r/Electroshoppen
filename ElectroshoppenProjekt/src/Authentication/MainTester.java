/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

import WEBSHOP.Adress;
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
//	Adress a = new Adress("2", "3", "3", "3", "3", "3");
//	Create c = new Create("test", "2468", "e@e.dk", a, "test", "");
//	c.createUser("customer");
	
	
	Create c = new Create("2468", "test");
	c.deleteUser("customer");
	
        
        
       
        
        
    }
    
}
