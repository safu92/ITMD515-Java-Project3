/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp3.domain;

import java.util.GregorianCalendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

/**
 *
 * @author spyrisos
 */
public abstract class AbstractJPATest {

    private static EntityManagerFactory emf;
    protected EntityManager em;
    protected EntityTransaction tx;

    @BeforeClass
    public static void setUpClass() {
        emf = Persistence.createEntityManagerFactory("smatchesPU");
    }

    @AfterClass
    public static void tearDownClass() {
        emf.close();
    }

    @Before
    public void setUp() {
        em = emf.createEntityManager();
        tx = em.getTransaction();
        createTestData();
    }

    private void createTestData() {
        tx.begin();
        
        //set fields for station
        Bus bus = new Bus();
        bus.setName("49B");
        
        // Set fields for show
        Station station = new Station();
        station.setName("Howard");
        
        // Set fields for DJ
        Driver driver = new Driver();
        driver.setFirstName("Safdar");
        driver.setLastName("Matcheswala");
        driver.setDriverBatch("D0971");
        driver.setBirthDate(new GregorianCalendar(1992, 06, 18).getTime());
        
        em.persist(driver);
        em.persist(bus);
        em.persist(station);
        tx.commit();
    }

    @After
    public void tearDown() {
        removeTestData();
        em.close();
    }

    private void removeTestData() {
//        TypedQuery<RadioStation> q = em.createQuery("select r from RadioStation r where r.name = ?1", RadioStation.class);
//        q.setParameter(1, "WTTW");
//        RadioStation r = q.getSingleResult();

//        Show s = em.createNamedQuery("Show.findByName", Show.class).setParameter("name", "Daily News").getSingleResult();

        tx.begin();
//        em.remove(r);
//        em.remove(s);
        tx.commit();
    }
}
