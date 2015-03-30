/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp3.domain;

import java.util.GregorianCalendar;
import java.util.List;
import javax.persistence.TypedQuery;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author smatches@hawk.iit.edu
 */
public class DriverTest extends AbstractJPATest{
    
    public DriverTest() {
    }
   
    
    @Test
    public void testCreate() {
        Driver newOne = new Driver();
        newOne.setFirstName("Ayun");
        newOne.setLastName("Brown");
        newOne.setBirthDate(new GregorianCalendar(1985, 03, 15).getTime());
        newOne.setDriverBatch("D0316");
        
        tx.begin();
        em.persist(newOne);
        tx.commit();
        
        assertNotNull(newOne.getId());
        
    }

    @Test
    public void testRead() {

        List<Driver> drivers = em.createNamedQuery("Driver.findAll", Driver.class).getResultList();
        assertTrue(drivers.size() >= 1);
        assertFalse(drivers.isEmpty());

        for (Driver d : drivers) {
            System.out.println(d.toString());

               // System.out.println("\t"+d.getBus().toString());
                //System.out.println("\t"+d.getTrain().toString());

        }
    }

    @Test
    public void testUpdate() {
        Driver d = em.createNamedQuery("Driver.findByName", Driver.class).setParameter("lname", "Brown").getSingleResult();
        assertNotNull(d.getId());

        String originalName = d.getLastName();
        String newName = "Dalton";
        tx.begin();
        d.setLastName(newName);
        tx.commit();

        //assertNotEquals(originalName, b.getName());
        //assertTrue(newName.equals(b.getName()));

        //tx.begin();
        //b.setName(originalName);
        //tx.commit();
    }

    @Test
    @Ignore
    public void testDelete() {
       TypedQuery<Driver> q = em.createQuery("select d from Driver d where d.firstName = ?1", Driver.class);
        q.setParameter(1, "Ayun");
        Driver d = q.getSingleResult();
        
        assertNotNull(d.getId());

        tx.begin();
        em.remove(d.getBus());
        em.remove(d.getTrain());
        
      
        em.remove(d);
        tx.commit();

    }

    
}
