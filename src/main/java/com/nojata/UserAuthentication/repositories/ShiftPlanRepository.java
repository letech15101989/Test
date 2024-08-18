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
import com.nojata.UserAuthentication.model.entity.ShiftPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftPlanRepository extends JpaRepository<ShiftPlan, Integer> {
}
