/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp3.domain;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import sun.util.calendar.Gregorian;

/**
 *
 * @author ALLAH
 */
@MappedSuperclass
public class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastUpdated;
    
    @PreUpdate
    @PrePersist
    private void setLastUpdated(){
        lastUpdated = GregorianCalendar.getInstance().getTime();
    }

    /**
     * Get the value of lastUpdated
     *
     * @return the value of lastUpdated
     */
    public Date getLastUpdated() {
        return lastUpdated;
    }

    public Long getId() {
        return id;
    }

}
