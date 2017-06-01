/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package elecetroshoppenprojekt;

import Authentication.Token;
import WEBSHOP.Address;
import WEBSHOP.Product.Product;
import WEBSHOP.Product.ProductCategory;
import WEBSHOP.Profiles.Profile;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Jacob
 */
public class WebshopTest {
    
    public WebshopTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of setLoginForCustomer method, of class Webshop.
     */
    @Test
    public void testSetLoginForCustomer() {
	System.out.println("setLoginForCustomer");
	Token token = null;
	Webshop instance = new Webshop();
	instance.setLoginForCustomer(token);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of pay method, of class Webshop.
     */
    @Test
    public void testPay() {
	System.out.println("pay");
	Webshop instance = new Webshop();
	String expResult = "";
	String result = instance.pay();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of addToViewedProducts method, of class Webshop.
     */
    @Test
    public void testAddToViewedProducts() {
	System.out.println("addToViewedProducts");
	Product p = null;
	Webshop instance = new Webshop();
	instance.addToViewedProducts(p);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of addToOrder method, of class Webshop.
     */
    @Test
    public void testAddToOrder() {
	System.out.println("addToOrder");
	Product p = new Product("Product", 0, 0, "description", ProductCategory.PHONE);
	int amount = 1;
	Webshop instance = new Webshop();
	instance.addToOrder(p, amount);
	
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of removeFromOrder method, of class Webshop.
     */
    @Test
    public void testRemoveFromOrder() {
	System.out.println("removeFromOrder");
	Product p = null;
	int amount = 0;
	Webshop instance = new Webshop();
	instance.removeFromOrder(p, amount);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of showBasket method, of class Webshop.
     */
    @Test
    public void testShowBasket() {
	System.out.println("showBasket");
	Webshop instance = new Webshop();
	String expResult = "";
	String result = instance.showBasket();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of updateProfile method, of class Webshop.
     */
    @Test
    public void testUpdateProfile() {
	System.out.println("updateProfile");
	String name = "";
	String email = "";
	String phone = "";
	String cvr = "";
	Webshop instance = new Webshop();
	instance.updateProfile(name, email, phone, cvr);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of searchProfile method, of class Webshop.
     */
    @Test
    public void testSearchProfile() {
	System.out.println("searchProfile");
	String email = "";
	Webshop instance = new Webshop();
	String[] expResult = null;
	String[] result = instance.searchProfile(email);
	assertArrayEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getAddressArray method, of class Webshop.
     */
    @Test
    public void testGetAddressArray() {
	System.out.println("getAddressArray");
	String email = "";
	Webshop instance = new Webshop();
	String[] expResult = null;
	String[] result = instance.getAddressArray(email);
	assertArrayEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getAddress method, of class Webshop.
     */
    @Test
    public void testGetAddress() {
	System.out.println("getAddress");
	Webshop instance = new Webshop();
	Address expResult = null;
	Address result = instance.getAddress();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of setAddress method, of class Webshop.
     */
    @Test
    public void testSetAddress() {
	System.out.println("setAddress");
	String streetName = "";
	String streetNumber = "";
	String secAddress = "";
	String zipCode = "";
	String city = "";
	Webshop instance = new Webshop();
	instance.setAddress(streetName, streetNumber, secAddress, zipCode, city);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of isValid method, of class Webshop.
     */
    @Test
    public void testIsValid() {
	System.out.println("isValid");
	Webshop instance = new Webshop();
	boolean expResult = false;
	boolean result = instance.isValid();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of setNewCustomer method, of class Webshop.
     */
    @Test
    public void testSetNewCustomer() {
	System.out.println("setNewCustomer");
	Webshop instance = new Webshop();
	instance.setNewCustomer();
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getCustomerProfile method, of class Webshop.
     */
    @Test
    public void testGetCustomerProfile() {
	System.out.println("getCustomerProfile");
	Webshop instance = new Webshop();
	Profile expResult = null;
	Profile result = instance.getCustomerProfile();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

}
