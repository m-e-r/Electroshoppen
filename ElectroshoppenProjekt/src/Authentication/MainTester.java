/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

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
        Login test2 = new Login("user", "pass");
        
        Token token = test2.doLogin();
        String tok = token.getToken();
        System.out.println(tok);
        
        try {
            Thread.sleep(6000);
            
        } catch (InterruptedException ex) {
            Logger.getLogger(MainTester.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        String tok2 = token.getToken();
        System.out.println(tok2);
        
        
        
    }
    
}
