/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package warmen;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Romain
 */
public class GameLevelOneTest {
    
    public GameLevelOneTest() {
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
     * Test of init method, of class GameLevelOne.
     */
    @Test
    public void testInit() {
        System.out.println("init");
        GameLevelOne instance = null;
        instance.init();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initAccessories method, of class GameLevelOne.
     */
    @Test
    public void testInitAccessories() {
        System.out.println("initAccessories");
        int nbShields = 0;
        int nbSwords = 0;
        GameLevelOne instance = null;
        instance.initAccessories(nbShields, nbSwords);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}