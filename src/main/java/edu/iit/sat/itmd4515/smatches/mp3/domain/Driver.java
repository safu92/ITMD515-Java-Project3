/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp3.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author ALLAH
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Driver.findByName", query = "select d from Driver d where d.lastName = :lname"),
    @NamedQuery(name = "Driver.findById", query = "select d from Driver d where d.id = :id"),
    @NamedQuery(name = "Driver.findAll", query = "select d from Driver d")})
public class Driver extends Person implements Serializable{

        private String driverBatch;

        
        @OneToOne(mappedBy = "driver")
        private Bus bus;
        
          @OneToOne(mappedBy = "driver")
        private Train train;

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }

    public void setTrain(Train train) {
        this.train = train;
    }

    public Train getTrain() {
        return train;
    }
    /**
     * Get the value of driverBatch
     *
     * @return the value of driverBatch
     */
    public String getDriverBatch() {
        return driverBatch;
    }

    /**
     * Set the value of driverBatch
     *
     * @param driverBatch new value of driverBatch
     */
    public void setDriverBatch(String driverBatch) {
        this.driverBatch = driverBatch;
    }

    
    public Driver() {
    }
    
      @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n\t");
        sb.append("Driver{batch=").append(driverBatch).append('}');
        return sb.toString();
    }
    
}
