/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp3.domain;

import javax.persistence.Entity;

/**
 *
 * @author ALLAH
 */
@Entity
public class Driver extends Person{

        private String driverBatch;

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
    
}
