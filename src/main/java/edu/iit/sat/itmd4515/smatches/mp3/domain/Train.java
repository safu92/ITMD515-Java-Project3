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
    @NamedQuery(name = "Train.findByName", query = "select t from Train t where t.name = :name"),
    @NamedQuery(name = "Train.findById", query = "select t from Train t where t.id = :id"),
    @NamedQuery(name = "Train.findAll", query = "select t from Train t")})
public class Train extends BaseEntity implements Serializable{
    
    private String name;

       @OneToMany(mappedBy = "train")
    private List<Passenger> passengers = new ArrayList<>();

       
       @ManyToMany(mappedBy = "trains", cascade = CascadeType.PERSIST)
    private List<Station> stations = new ArrayList<>();

       @OneToOne
    private Driver driver;

    public Driver getDriver() {
        return driver;
    }
       
    public List<Station> getStations() {
        return stations;
    }

    public List<Passenger> getPassengers() {
        return passengers;
    }
      
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

      @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n\t");
        sb.append("Train{name=").append(name).append('}');
        return sb.toString();
    }
}
