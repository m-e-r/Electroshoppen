/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP;
import WEBSHOP.Profiles.*;
import Authentication.*;
import elecetroshoppenprojekt.Webshop;
/**
 *
 * @author Jacob
 */
public class WebshopMain {
    /**
     * @param args the command line arguments
     */
    private static Login login;
    private static Login login2;
    private static Webshop webshop;
    
    public static void main(String[] args) {
	login = new Login("61703764", "pass");
	login2 = new Login("61703765", "f56f9ee88fbda5d5ee4b947fa35e3eda9a9f706de4c7fb49f13ea1455ca486");
	login.doLogin();
	login2.doLogin();

        
        
    }
    
    
    
    
    
    
}
