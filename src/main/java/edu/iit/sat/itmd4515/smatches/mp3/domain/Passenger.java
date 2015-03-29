/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp3.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author ALLAH
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Passenger.findByName", query = "select p from Passenger p where p.lastName = :lname"),
    @NamedQuery(name = "Passenger.findById", query = "select p from Passenger p where p.id = :id"),
    @NamedQuery(name = "Passenger.findAll", query = "select p from Passenger p")})
public class Passenger extends Person implements Serializable{
    
   @ManyToOne
   @JoinColumn(name = "BUS_ID")
   private Bus bus;

    public Passenger() {
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
    
}
