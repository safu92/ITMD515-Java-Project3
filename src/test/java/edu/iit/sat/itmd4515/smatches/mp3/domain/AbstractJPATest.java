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
        
        //set fields for bus
        Bus bus = new Bus();
        bus.setName("49B");
        
        //set fields for train
        Train train = new Train();
        train.setName("RedLine");
        
        //Bus bus = new Bus();
        //bus.setName("155");
        
        // Set fields for station
        Station station = new Station();
        station.setName("Howard");
        
        Station station1 = new Station();
        station.setName("Western");
        
        // Set fields for Driver
        Driver driver = new Driver();
        driver.setFirstName("Safdar");
        driver.setLastName("Matcheswala");
        driver.setDriverBatch("D0971");
        driver.setBirthDate(new GregorianCalendar(1992, 06, 18).getTime());

        
                Driver driver1 = new Driver();
        driver.setFirstName("James");
        driver.setLastName("Cruz");
        driver.setDriverBatch("D0257");
        driver.setBirthDate(new GregorianCalendar(1968, 11, 24).getTime());
        
        Passenger p1 = new Passenger();
        p1.setFirstName("Bryan");
        p1.setLastName("Saphyr");
        p1.setBirthDate(new GregorianCalendar(1989, 05, 12).getTime());
        Passenger p2 = new Passenger();
        p2.setFirstName("Tommy");
        p2.setLastName("Racine");
        p2.setBirthDate(new GregorianCalendar(1975, 02, 17).getTime());


         // set relationship between bus and station
        //radioStation.getShows().add(show);
        //show.setRadioStation(radioStation);
        
        // set relationship between bus and the passenger
        bus.getPassengers().add(p1);
        p1.setBus(bus);
        train.getPassengers().add(p2);
        p2.setTrain(train);

        // set relationship between the bus and station
        station.getBuses().add(bus);
        bus.getStations().add(station);
        station.getTrains().add(train);
        train.getStations().add(station);

        Ventra v1  = new Ventra();
        v1.setCardNumber("2563985614578516");
        v1.setExpiryDate(new GregorianCalendar(2017, 06, 24).getTime());
        v1.setBalance(25.00);
        
        //Uni Directional One to One
        p1.setVentra(v1);
        
        em.persist(p1);
        em.persist(p2);
        em.persist(train);
        em.persist(bus);
        em.persist(station);
        em.persist(station1);
        em.persist(v1);        
        em.persist(driver);
        em.persist(driver1);
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
