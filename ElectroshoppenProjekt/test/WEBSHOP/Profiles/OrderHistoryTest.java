/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package WEBSHOP.Profiles;

import java.util.ArrayList;
import java.util.HashMap;
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
public class OrderHistoryTest {
    
    public OrderHistoryTest() {
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
     * Test of getOrderLinesByOrder method, of class OrderHistory.
     */
    @Test
    public void testGetOrderLinesByOrder() {
	System.out.println("getOrderLinesByOrder");
	String customerId = "foo@bar.com";
	OrderHistory instance = new OrderHistory();
	HashMap<String, ArrayList<String>> expResult = new HashMap();
	
	HashMap<String, ArrayList<String>> result = instance.getOrderLinesByOrder(customerId);
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }

    /**
     * Test of toString method, of class OrderHistory.
     */
    @Test
    public void testToString() {
	System.out.println("toString");
	OrderHistory instance = new OrderHistory();
	String expResult = "";
	String result = instance.toString();
	assertEquals(expResult, result);
	// TODO review the generated test code and remove the default call to fail.
	fail("The test case is a prototype.");
    }
    
}
