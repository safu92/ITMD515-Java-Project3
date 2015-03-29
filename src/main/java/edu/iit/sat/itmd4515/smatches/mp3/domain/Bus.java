/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp3.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author ALLAH
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Bus.findByName", query = "select b from Bus b where b.name = :name"),
    @NamedQuery(name = "Bus.findById", query = "select b from Bus b where b.id = :id"),
    @NamedQuery(name = "Bus.findAll", query = "select b from Bus b")})
public class Bus extends BaseEntity implements Serializable{

        private String name;

        
        @OneToMany(mappedBy = "bus")
    private List<Passenger> passengers = new ArrayList<>();
        
        
    @ManyToMany(mappedBy = "buses", cascade = CascadeType.PERSIST)
    private List<Station> stations = new ArrayList<>();

    @OneToOne
    private Driver driver;

    public Driver getDriver() {
        return driver;
    }
    
    public List<Station> getStations() {
        return stations;
    }
    
    //  @OneToMany(mappedBy = "bus")
  //private List<Station> stations = new ArrayList<>();
        
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
 
    
    public List<Passenger> getPassengers() {
        return passengers;
    }
    
    //public List<Station> getStations() {
//        return stations;
  //  }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n\t");
        sb.append("Bus{name=").append(name).append('}');
        return sb.toString();
    }
}
