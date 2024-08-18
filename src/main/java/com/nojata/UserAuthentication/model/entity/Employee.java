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
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    
    @Id
    @Column(name = "emp_id")
    private String empId;

    @Column(name = "emp_first_name", nullable = false)
    private String empFirstName;

    @Column(name = "emp_middle_name")
    private String empMiddleName;

    @Column(name = "emp_last_name", nullable = false)
    private String empLastName;

    @Column(name = "emp_address", nullable = false)
    private String empAddress;

    @Column(name = "emp_postal_code", nullable = false)
    private String empPostalCode;

    @Column(name = "emp_country", nullable = false)
    private String empCountry;

    @Column(name = "emp_role", nullable = false)
    private String empRole;

    @Column(name = "emp_mob_no", nullable = false)
    private String empMobileNumber;

    @Column(name = "emp_telephone")
    private String empTelephone;

    @Column(name = "emp_email_id", nullable = false)
    private String empEmailId;

    @ManyToOne
    @JoinColumn(name = "comp_id")
    private Compnay company;

    
}

