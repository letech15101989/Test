/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.repositories;

import com.nojata.UserAuthentication.model.entity.User;
import com.nojata.UserAuthentication.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Shamsher
 */
public interface  RoleRepository  extends JpaRepository<UserRole, Long>{
    
}
