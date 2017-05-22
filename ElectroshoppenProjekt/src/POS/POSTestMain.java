/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS;

import WEBSHOP.Profiles.Profile;

/**
 *
 * @author Jacob
 */
public class POSTestMain {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
	//finds customer with email mail2@mail2.dk and print name og number. 
	POS p = new POS();
	Profile pro = p.getCustomerInfo("mail2@mail2.dk");
	System.out.println(pro.getName());
	System.out.println(pro.getPhoneNumber());
	
    }
    
}
