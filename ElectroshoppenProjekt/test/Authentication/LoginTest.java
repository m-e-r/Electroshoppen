/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Authentication;

import WEBSHOP.Profiles.CustomerProfile;
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
public class LoginTest {
  
    
    public LoginTest() {
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
     * Test of doLogin method, of class Login.
     */
    @Test
    public void testDoLogin() {
	System.out.println("doLogin");
	String eMail = "foo@bar.com";
	String passWord = "password";
	Login instance = new Login(eMail, passWord);
	Token expResult = new Token(eMail.toUpperCase());
	Token result = instance.doLogin();
	assertEquals(expResult.getToken(), result.getToken());
    }

    /**
     * Test of doLogout method, of class Login.
     */
//    @Test
//    public void testDoLogout() {
//	System.out.println("doLogout");
//	Login instance = null;
//	boolean expResult = false;
//	boolean result = instance.doLogout();
//	assertEquals(expResult, result);
//	// TODO review the generated test code and remove the default call to fail.
//	fail("The test case is a prototype.");
//    }

    /**
     * Test of createUser method, of class Login.
     */
//    @Test
//    public void testCreateUser() {
//	System.out.println("createUser");
//	String none = "";
//	Login instance = null;
//	boolean expResult = false;
//	boolean result = instance.createUser(none);
//	assertEquals(expResult, result);
//	// TODO review the generated test code and remove the default call to fail.
//	fail("The test case is a prototype.");
//    }

    /**
     * Test of deleteUser method, of class Login.
     */
//    @Test
//    public void testDeleteUser() {
//	System.out.println("deleteUser");
//	String none = "";
//	Login instance = null;
//	boolean expResult = false;
//	boolean result = instance.deleteUser(none);
//	assertEquals(expResult, result);
//	// TODO review the generated test code and remove the default call to fail.
//	fail("The test case is a prototype.");
//    }
    
}
