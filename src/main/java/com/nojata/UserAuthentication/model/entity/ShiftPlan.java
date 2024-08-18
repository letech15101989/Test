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
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

    import java.sql.Time;

@Entity
@Table(name = "shift_plan")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShiftPlan {
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShift_name() {
        return shift_name;
    }

    public void setShift_name(String shift_name) {
        this.shift_name = shift_name;
    }

    public Compnay getCompany() {
        return company;
    }

    public void setCompany(Compnay company) {
        this.company = company;
    }

    public Time getFromTime() {
        return fromTime;
    }

    public void setFromTime(Time fromTime) {
        this.fromTime = fromTime;
    }

    public Time getToTime() {
        return toTime;
    }

    public void setToTime(Time toTime) {
        this.toTime = toTime;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name="shift_name")
    private String shift_name;

    @ManyToOne
    @JoinColumn(name = "comp_id", nullable = false)
    private Compnay company;

    @Column(name = "from_time", nullable = false)
    private java.sql.Time fromTime;

    @Column(name = "to_time", nullable = false)
    private java.sql.Time toTime;

    
}
    

