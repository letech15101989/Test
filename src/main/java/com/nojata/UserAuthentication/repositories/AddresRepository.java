/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.repositories;

import com.nojata.UserAuthentication.model.entity.Address;
import java.util.List;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Shamsher
 */
@Repository
public interface  AddresRepository  extends JpaRepository<Address, Long>{
    public List<Address> findAll();
      }
