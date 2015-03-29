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

/**
 *
 * @author ALLAH
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Bus.findByName", query = "select b from Bus b where b.name = :name"),
    @NamedQuery(name = "Bus.findById", query = "select b from Bus b where b.id = :id"),})
public class Bus extends BaseEntity implements Serializable{

        private String name;

    /**
     * Get the value of name
     *
     * @return the value of name
     */
    public String getName() {
        return name;
    }

    /**
     * Set the value of name
     *
     * @param name new value of name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    public Bus() {
    }
    
}
