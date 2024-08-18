/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import com.nojata.UserAuthentication.model.entity.AlphanumericGenerator;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

/**
 *
 * @author Shamsher
 */
   
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue( generator = "uniqueIdgenerator")
    @GenericGenerator(strategy = "com.nojata.UserAuthentication.model.entity.AlphanumericGenerator", name = "uniqueIdgenerator")
    @Column(name = "userid", unique = true, nullable = false)
    private String userId;

    @Column(name = "username", unique = true)
    private String userName;

    @Column(nullable = false, unique = true, name = "emailid")
    private String emailId;

    @Column(name = "mobileno")
    private long mobileNo;
    
    @Column(name="password")
   private String password;
    
   @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Address> addresses;

   @OneToMany(mappedBy = "userId", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<UserRole> userRole; 
   
}

