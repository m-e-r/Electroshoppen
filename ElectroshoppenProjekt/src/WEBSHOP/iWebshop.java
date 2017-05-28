/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP;

import ProductStuff.Product;
import WEBSHOP.Profiles.Profile;

/**
 *
 * @author Bruger
 */
public interface iWebshop {
    
    Product searchProduct(long productNumber);
    
    String[] searchProfile(String email);
    
    String pay(double totalPrice);
    
    void updateProfile(String name, String email, String phone, String cvr);
    
}
