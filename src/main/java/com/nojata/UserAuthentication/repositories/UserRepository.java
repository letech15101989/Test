/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.repositories;
import javax.persistence.NamedQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.nojata.UserAuthentication.model.entity.User;
import java.util.List;
import org.springframework.data.domain.Sort;

/**
 *
 * @author Shamsher
 */
@Repository
public interface  UserRepository extends JpaRepository<User, String>{
    public List<User> findAll();

  


  

    
      }
