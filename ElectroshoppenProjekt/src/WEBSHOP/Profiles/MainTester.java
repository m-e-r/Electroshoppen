/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Profiles;

import WEBSHOP.Adress;
import Authentication.*;

/**
 *
 * @author Jacob
 */
public class MainTester {
    public static void main(String[] args) {
	Adress ad = new Adress("5200", "Odense V", "Elmelundsvej", "4", "ST", "3411");
	Profile pf = new EmployeeProfile("Jacob Søgaard", "61703764", "sogaard1995@gmail.com", ad, new Token("tok"), "1", 0);
	//System.out.println(pf.toString());
	pf.saveProfil();
    }
}
