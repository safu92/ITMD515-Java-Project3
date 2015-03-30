/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp3.domain;

import java.util.List;
import javax.persistence.TypedQuery;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author ALLAH
 */
public class TrainTest extends AbstractJPATest{
    
    public TrainTest() {
    }
   
    
    @Test
    public void testCreate() {
        Train newOne = new Train();
        newOne.setName("Brown Line");
        
        Train anotherOne = new Train();
        anotherOne.setName("Green Line");
        
        
        tx.begin();
        em.persist(anotherOne);
        em.persist(newOne);
        tx.commit();
        
        assertNotNull(newOne.getId());
        
    }

    @Test
    public void testRead() {

        List<Train> trains = em.createNamedQuery("Train.findAll", Train.class).getResultList();
        assertTrue(trains.size() >= 1);
        assertFalse(trains.isEmpty());

        for (Train t : trains) {
            System.out.println(t.toString());

            for (Station s : t.getStations()) {
                System.out.println("\t"+s.toString());
          }
            
        }
    }

    @Test
    public void testUpdate() {
        Train t = em.createNamedQuery("Train.findByName", Train.class).setParameter("name", "Green Line").getSingleResult();
        assertNotNull(t.getId());

        String originalName = t.getName();
        String newName = "Blue Line";
        tx.begin();
        t.setName(newName);
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
       TypedQuery<Train> q = em.createQuery("select t from Train t where t.name = ?1", Train.class);
        q.setParameter(1, "Brown Line");
        Train t = q.getSingleResult();
        
        assertNotNull(t.getId());

        tx.begin();
        for(Passenger p : t.getPassengers()){
            em.remove(p);
      }
        for(Station s : t.getStations()){
            em.remove(s);
        }
        
        em.remove(t.getDriver());
        em.remove(t);
        tx.commit();

        Train postRemove = em.find(Train.class, 1L);
        assertNull(postRemove);
        
    }

    
}
