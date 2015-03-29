/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp3.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author ALLAH
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Stations.findByName", query = "select s from Station s where s.name = :name"),
    @NamedQuery(name = "Stations.findById", query = "select s from Station s where s.id = :id"),
    @NamedQuery(name = "Stations.findAll", query = "select s from Station s")})
public class Station extends BaseEntity implements Serializable{

    public Station() {
    }
    
    private String name;

    
  
    
     @ManyToMany
    @JoinTable(name = "bus_stations",
            joinColumns = @JoinColumn(name = "station_id"),
            inverseJoinColumns = @JoinColumn(name = "bus_id"))
    private List<Bus> buses = new ArrayList<>();

    public List<Bus> getBuses() {
        return buses;
    }

    
    @ManyToMany
    @JoinTable(name = "train_stations",
            joinColumns = @JoinColumn(name = "station_id"),
            inverseJoinColumns = @JoinColumn(name = "train_id"))
    private List<Train> trains = new ArrayList<>();

    public List<Train> getTrains() {
        return trains;
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
        sb.append("Station{name=").append(name).append('}');
        return sb.toString();
    }

}
