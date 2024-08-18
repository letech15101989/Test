/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Shamsher
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignupInput {
      private String  userName;
     private String  emailId;
     private Long  mobileNo;
      private String address;
      private String companyName;
      private String city;
      private String country;
      private String postalCode;
}
