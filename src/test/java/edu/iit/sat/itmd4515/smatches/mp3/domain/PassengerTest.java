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
 * @author ALLAH
 */
public class PassengerTest extends AbstractJPATest{
    
    public PassengerTest() {
    }
   
    
    @Test
    public void testCreate() {
        Passenger newOne = new Passenger();
        newOne.setFirstName("Nathan");
        newOne.setLastName("Gomes");
        newOne.setBirthDate(new GregorianCalendar(1970, 03, 02).getTime());
        
        
        tx.begin();
        em.persist(newOne);
        tx.commit();
        
        assertNotNull(newOne.getId());
        
    }

    @Test
    public void testRead() {

        List<Passenger> passengers = em.createNamedQuery("Passenger.findAll", Passenger.class).getResultList();
        assertTrue(passengers.size() >= 1);
        assertFalse(passengers.isEmpty());

        for (Passenger p : passengers) {
            System.out.println(p.toString());

               // System.out.println("\t"+d.getBus().toString());
                //System.out.println("\t"+d.getTrain().toString());

        }
    }

    @Test
    public void testUpdate() {
        Passenger p = em.createNamedQuery("Passenger.findByName", Passenger.class).setParameter("lname", "Gomes").getSingleResult();
        assertNotNull(p.getId());

        String originalName = p.getLastName();
        String newName = "Strick";
        tx.begin();
        p.setLastName(newName);
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
       TypedQuery<Passenger> q = em.createQuery("select p from Passenger p where p.firstName = ?1", Passenger.class);
        q.setParameter(1, "Nathan");
        Passenger p = q.getSingleResult();
        
        assertNotNull(p.getId());

        tx.begin();
        
        em.remove(p.getVentra());
        
        em.remove(p);
        tx.commit();

        
    }

    
}
