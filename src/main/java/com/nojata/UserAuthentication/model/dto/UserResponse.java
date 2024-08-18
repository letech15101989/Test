/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.model.dto;

import com.nojata.UserAuthentication.model.entity.UserRole;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Shamsher
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserResponse {
    
    UserDetails userDetails;
    List<UserRole> userRoles;
    
}
