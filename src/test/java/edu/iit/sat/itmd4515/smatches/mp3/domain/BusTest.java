/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp3.domain;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author ALLAH
 */
public class BusTest extends AbstractJPATest{
    
    public BusTest() {
    }
    
    /**
     * Test of getName method, of class Bus.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        Bus instance = new Bus();
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setName method, of class Bus.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "";
        Bus instance = new Bus();
        instance.setName(name);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
