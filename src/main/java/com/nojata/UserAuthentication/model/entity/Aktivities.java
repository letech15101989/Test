/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.model.entity;

/**
 *
 * @author Shamsher
 */
import javax.persistence.*;

@Entity
@Table(name = "activities")
public class Aktivities {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;  // Assuming you want an auto-generated ID

    @Column(name = "name", nullable = false, length = 255)
    private String name;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid", nullable = false)
    private User user;  // Assuming there's a Users entity

    @Column(name = "shift_plan")
    private String shiftPlan;

    public void setId(int id) {
        this.id = id;
    }

    public String getShiftPlan() {
        return shiftPlan;
    }

    public void setShiftPlan(String shiftPlan) {
        this.shiftPlan = shiftPlan;
    }

    // Constructors
    public Aktivities() {}

    public Aktivities(String name, User user) {
        this.name = name;
        this.user = user;
    }

    // Getters and Setters


    public String getName() {
        return name;
    }

    public void setName(String aktivityname) {
        this.name = aktivityname;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

