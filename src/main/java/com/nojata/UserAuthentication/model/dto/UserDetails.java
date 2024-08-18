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
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDetails {
    private String userId;
    private String userName;
    private String emailId;
    private String password;
    private long mobileNo;
    
    
}
