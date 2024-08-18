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

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Entity
@Table(name = "companies")
public class Compnay {
    
    @Id
    @Column(name = "comp_id")
    private String compId;

    @Column(name = "comp_name", nullable = false)
    private String compName;

    @Column(name = "comp_address", nullable = false)
    private String compAddress;

    @Column(name = "comp_postalcode", nullable = false)
    private String compPostalCode;

    @Column(name = "comp_country", nullable = false)
    private String compCountry;

    @Lob
    @Column(name = "comp_logo")
    private byte[] compLogo;
// @Column(name = "comp_logo", columnDefinition = "MEDIUMTEXT")
//    private String compLogo;
    // Getters and setters (omitted for brevity)
}

