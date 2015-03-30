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
 * @author smatches@hawk.iit.edu
 */
public class StationTest extends AbstractJPATest{
    
    public StationTest() {
    }
   
    
    @Test
    public void testCreate() {
        Station newOne = new Station();
        newOne.setName("Bronzeville");
        
        Station anotherOne = new Station();
        anotherOne.setName("Lake");
        
        
        tx.begin();
        em.persist(anotherOne);
        em.persist(newOne);
        tx.commit();
        
        assertNotNull(newOne.getId());
        
    }

    @Test
    public void testRead() {

        List<Station> stations = em.createNamedQuery("Station.findAll", Station.class).getResultList();
        assertTrue(stations.size() >= 1);
        assertFalse(stations.isEmpty());

        for (Station s : stations) {
            System.out.println(s.toString());

            for (Bus b : s.getBuses()) {
                System.out.println("\t"+b.toString());
          }
            for (Train t : s.getTrains()) {
                System.out.println("\t"+t.toString());
          }
        }
    }

    @Test
    public void testUpdate() {
        Station s = em.createNamedQuery("Station.findByName", Station.class).setParameter("name", "Lake").getSingleResult();
        assertNotNull(s.getId());

        String originalName = s.getName();
        String newName = "State";
        tx.begin();
        s.setName(newName);
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
       TypedQuery<Station> q = em.createQuery("select s from Station s where s.name = ?1", Station.class);
        q.setParameter(1, "Bronzeville");
        Station s = q.getSingleResult();
        
        assertNotNull(s.getId());

        tx.begin();
        
        for(Bus b: s.getBuses()){
            em.remove(b);
        }
        
        for(Train t: s.getTrains()){
            em.remove(t);
        }
        
        em.remove(s);
        tx.commit();

        
        
    }

    
}
