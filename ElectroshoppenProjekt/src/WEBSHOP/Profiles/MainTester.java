/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Profiles;

import WEBSHOP.Adress;
import Authentication.*;
import java.util.*;

/**
 *
 * @author Jacob
 */
public class MainTester {
    public static void main(String[] args) {
	
	Scanner console = new Scanner(System.in);
	System.out.print("Full name: ");
	String name = console.nextLine();
	System.out.print("Email: ");
	String email = console.nextLine();
	System.out.print("Phonenumber: ");
	String number = console.nextLine();
	System.out.print("Streetname : ");
	String streetname = console.nextLine();
	System.out.print("House number: ");
	String houseNumber = console.nextLine();
	System.out.print("Floor: ");
	String floor = console.nextLine();
	System.out.print("Door Number: ");
	String doornumber = console.nextLine();
	System.out.print("City: ");
	String city = console.nextLine();
	System.out.print("Zip code: ");
	String zip = console.nextLine();
	System.out.print("password: ");
	String token = console.nextLine();
	
	Adress ad = new Adress(zip, city, streetname, houseNumber, floor, doornumber);
	Profile pf = new EmployeeProfile(name, number, email, ad, new Token(token), Integer.parseInt(number));
	pf.saveProfil();
	
    }
}
