/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.smatches.mp3.domain;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author smatches@hawk.iit.edu
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Ventra.findByCardNumber", query = "select v from Ventra v where v.cardNumber = :cardNumber"),
    @NamedQuery(name = "Ventra.findById", query = "select v from Ventra v where v.id = :id"),
    @NamedQuery(name = "Ventra.findAll", query = "select v from Ventra v")})
public class Ventra extends BaseEntity implements Serializable{

    private String cardNumber;
    @Temporal(TemporalType.DATE)
    private Date expiryDate;
    
    private Double balance;


    /**
     * Get the value of balance
     *
     * @return the value of balance
     */
    public Double getBalance() {
        return balance;
    }

    /**
     * Set the value of balance
     *
     * @param balance new value of balance
     */
    public void setBalance(Double balance) {
        this.balance = balance;
    }


    /**
     * Get the value of expiryDate
     *
     * @return the value of expiryDate
     */
    public Date getExpiryDate() {
        return expiryDate;
    }

    /**
     * Set the value of expiryDate
     *
     * @param expiryDate new value of expiryDate
     */
    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Get the value of cardNumber
     *
     * @return the value of cardNumber
     */
    public String getCardNumber() {
        return cardNumber;
    }

    /**
     * Set the value of cardNumber
     *
     * @param cardNumber new value of cardNumber
     */
    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }
    
      @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n\t");
        sb.append("Ventra{cardNumber=").append(cardNumber).append('}');
        return sb.toString();
    }

}
