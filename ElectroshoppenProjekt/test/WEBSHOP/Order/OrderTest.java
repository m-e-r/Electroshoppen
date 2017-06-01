/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Order;

import WEBSHOP.Product.Product;
import WEBSHOP.Product.ProductCategory;
import WEBSHOP.Profiles.OrderHistory;
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
public class OrderTest {
    
    public OrderTest() {
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
     * Test of getId method, of class Order.
     */
    @Test
    public void testGetId() {
	System.out.println("getId");
	Order instance = new Order();
	Long expResult = null;
	Long result = instance.getId();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getDate method, of class Order.
     */
    @Test
    public void testGetDate() {
	System.out.println("getDate");
	Order instance = new Order();
	String expResult = "";
	String result = instance.getDate();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of pay method, of class Order.
     */
    @Test
    public void testPay() {
	System.out.println("pay");
	Order instance = new Order();
	String expResult = "";
	String result = instance.pay();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of addOrderLine method, of class Order.
     */
    @Test
    public void testAddOrderLine() {
	System.out.println("addOrderLine");
	Product p = new Product("Name", 1, 1, "Description", ProductCategory.PHONE);
	int amount = 2;
	Order instance = new Order();
	instance.addOrderLine(p, amount);
	assertEquals(instance.showBasket(), "name\n1\nDescription\nphone\n");
	// TODO review the generated test code and remove the default call to fail.
	//fail("The test case is a prototype.");
    }

    /**
     * Test of removeOrderLine method, of class Order.
     */
    @Test
    public void testRemoveOrderLine() {
	System.out.println("removeOrderLine");
	Product p = null;
	int amount = 0;
	Order instance = new Order();
	instance.removeOrderLine(p, amount);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of setStatus method, of class Order.
     */
    @Test
    public void testSetStatus() {
	System.out.println("setStatus");
	Status status = null;
	Order instance = new Order();
	instance.setStatus(status);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getOrderNumber method, of class Order.
     */
    @Test
    public void testGetOrderNumber() {
	System.out.println("getOrderNumber");
	Order instance = new Order();
	Long expResult = null;
	Long result = instance.getOrderNumber();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getStatus method, of class Order.
     */
    @Test
    public void testGetStatus() {
	System.out.println("getStatus");
	Order instance = new Order();
	String expResult = "";
	String result = instance.getStatus();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalPrice method, of class Order.
     */
    @Test
    public void testGetTotalPrice() {
	System.out.println("getTotalPrice");
	Order instance = new Order();
	double expResult = 0.0;
	double result = instance.getTotalPrice();
	assertEquals(expResult, result, 0.0);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of setEmail method, of class Order.
     */
    @Test
    public void testSetEmail() {
	System.out.println("setEmail");
	String email = "";
	Order instance = new Order();
	instance.setEmail(email);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of showBasket method, of class Order.
     */
    @Test
    public void testShowBasket() {
	System.out.println("showBasket");
	Order instance = new Order();
	String expResult = "";
	String result = instance.showBasket();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class Order.
     */
    @Test
    public void testToString() {
	System.out.println("toString");
	Order instance = new Order();
	String expResult = "";
	String result = instance.toString();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of resetOrder method, of class Order.
     */
    @Test
    public void testResetOrder() {
	System.out.println("resetOrder");
	Order instance = new Order();
	instance.resetOrder();
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }
    
}
