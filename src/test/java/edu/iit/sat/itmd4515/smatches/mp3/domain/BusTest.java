/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp3.domain;

import java.util.List;
import javax.persistence.TypedQuery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author ALLAH
 */
public class BusTest extends AbstractJPATest{
    
    public BusTest() {
    }
   
    
    @Test
    public void testCreate() {
        Bus newOne = new Bus();
        newOne.setName("155");
        
        tx.begin();
        em.persist(newOne);
        tx.commit();
        
        assertNotNull(newOne.getId());
        
    }

    @Test
    public void testRead() {

        List<Bus> buses = em.createNamedQuery("Bus.findAll", Bus.class).getResultList();
        assertTrue(buses.size() == 1);
        assertFalse(buses.isEmpty());

        for (Bus b : buses) {
            System.out.println(b.toString());

   //         for (Route r : b.getRou()) {
     //           System.out.println("\t"+r.toString());
       //     }
        }
    }

    @Test
    public void testUpdate() {
  //      RadioStation r = em.createNamedQuery("RadioStation.findByName", RadioStation.class).setParameter("name", "WTTW").getSingleResult();
    //    assertNotNull(r.getId());

      //  String originalName = r.getName();
       // String newName = "WNUR";
        //tx.begin();
        //r.setName(newName);
        //tx.commit();

        //assertNotEquals(originalName, r.getName());
        //assertTrue(newName.equals(r.getName()));

        //tx.begin();
        //r.setName(originalName);
        //tx.commit();
    }

    @Test
    @Ignore
    public void testDelete() {
        TypedQuery<Bus> q = em.createQuery("select b from Bus b where b.name = ?1", Bus.class);
        q.setParameter(1, "49B");
        Bus b = q.getSingleResult();
        
        assertNotNull(b.getId());

        tx.begin();
        for(Passenger p : b.getPassengers()){
            em.remove(p);
      }
        for(Station s : b.getStations()){
            em.remove(s);
        }
        em.remove(b);
        tx.commit();

        Bus postRemove = em.find(Bus.class, 1L);
        assertNull(postRemove);
        
    }

    
}
