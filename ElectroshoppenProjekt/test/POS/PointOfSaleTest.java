/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POS;

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
public class PointOfSaleTest {
    
    public PointOfSaleTest() {
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
     * Test of pay method, of class PointOfSale.
     */
//    @Test
//    public void testPay() {
//	System.out.println("pay");
//	PointOfSale instance = new PointOfSale();
//	instance.pay();
//	// TODO review the generated test code and remove the default call to fail.
//	fail("The test case is a prototype.");
//    }

    /**
     * Test of getCustomerInfo method, of class PointOfSale.
     */
    @Test
    public void testGetCustomerInfo() {
	System.out.println("getCustomerInfo");
	String email = "foo@bar.com";
	PointOfSale instance = new PointOfSale();
	String[] expResult = {"Jacob", "Søgaard", email, "88888888", ""};
	String[] result = instance.getCustomerInfo(email);
	assertArrayEquals(expResult, result);
    }

    /**
     * Test of getAmountForOrderLine method, of class PointOfSale.
     */
//    @Test
//    public void testGetAmountForOrderLine() {
//	System.out.println("getAmountForOrderLine");
//	long orderNumber = 0L;
//	PointOfSale instance = new PointOfSale();
//	int expResult = 0;
//	int result = instance.getAmountForOrderLine(orderNumber);
//	assertEquals(expResult, result);
//	// TODO review the generated test code and remove the default call to fail.
//	fail("The test case is a prototype.");
//    }

    /**
     * Test of editAmountForOrderLine method, of class PointOfSale.
     */
//    @Test
//    public void testEditAmountForOrderLine() {
//	System.out.println("editAmountForOrderLine");
//	long orderNumber = 0L;
//	long productId = 0L;
//	int amount = 0;
//	PointOfSale instance = new PointOfSale();
//	instance.editAmountForOrderLine(orderNumber, productId, amount);
//	// TODO review the generated test code and remove the default call to fail.
//	fail("The test case is a prototype.");
//    }
    
}
