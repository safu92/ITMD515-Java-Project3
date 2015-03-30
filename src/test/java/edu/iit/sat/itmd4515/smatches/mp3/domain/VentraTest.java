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
public class VentraTest extends AbstractJPATest{
    
    public VentraTest() {
    }
   
    
    @Test
    public void testCreate() {
        Ventra newOne = new Ventra();
        newOne.setBalance(10.00);
        newOne.setCardNumber("3625417895412376");
        newOne.setExpiryDate(new GregorianCalendar(2018, 06, 12).getTime());
        
        
        tx.begin();
        em.persist(newOne);
        tx.commit();
        
        assertNotNull(newOne.getId());
        
    }

    @Test
    public void testRead() {

        List<Ventra> ventra = em.createNamedQuery("Ventra.findAll", Ventra.class).getResultList();
        assertTrue(ventra.size() >= 1);
        assertFalse(ventra.isEmpty());

        for (Ventra v : ventra) {
            System.out.println(v.toString());

        }
    }

    @Test
    public void testUpdate() {
        Ventra v = em.createNamedQuery("Ventra.findByCardNumber", Ventra.class).setParameter("cardNumber", "3625417895412376").getSingleResult();
        assertNotNull(v.getId());

        String originalName = v.getCardNumber();
        String newNumber = "9842365178954123";
        tx.begin();
        v.setCardNumber(newNumber);
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
       TypedQuery<Ventra> q = em.createQuery("select v from Ventra v where v.cardNumber = ?1", Ventra.class);
        q.setParameter(1, "9842365178954123");
        Ventra v = q.getSingleResult();
        
        assertNotNull(v.getId());

        tx.begin();
        em.remove(v);
        tx.commit();

        
    }

    
}
