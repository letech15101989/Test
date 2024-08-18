/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.repositories;

/**
 *
 * @author Shamsher
 */
import com.nojata.UserAuthentication.model.entity.Compnay;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyRepository extends JpaRepository<Compnay, String> {
    // You can add custom query methods here if needed
}
