/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.services;

/**
 *
 * @author Shamsher
 */


import com.nojata.UserAuthentication.repositories.ShiftPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.nojata.UserAuthentication.model.entity.ShiftPlan;

import java.sql.Time;
import java.util.List;

@Service
public class ShiftPlanService {

    @Autowired
    private ShiftPlanRepository shiftPlanRepository;

    public List<ShiftPlan> findAll() {

        return shiftPlanRepository.findAll();
    }

    public ShiftPlan findById(int id) {

        return shiftPlanRepository.findById(id).orElse(null);
    }

    public boolean deleteShiftPlan(int id) {
        System.out.println("delete shift plan :"+id);
         shiftPlanRepository.deleteById(id);
            return true;
    }

    public boolean  createShiftPlan(String id, String name, String fromTime, String toTime){
/*        ShiftPlan shiftPlan = new ShiftPlan();
        shiftPlan = shiftPlanRepository.findById(Integer.valueOf(id)).orElse(null);
        if(shiftPlan == null){
            throw new Exception("Invalid  shiftplan id");
        }
        shiftPlan.setShift_Name(name);
        shiftPlan.setFromTime(fromTime);
        shiftPlan.setToTime(toTime);

        shiftPlanRepository.save(shiftPlan);*/
        return true;
    }

    public boolean  updateShiftPlan(String id, String name, String fromTime, String toTime) throws  Exception{
        ShiftPlan shiftPlan = new ShiftPlan();
        if(id !=null) {
            shiftPlan = shiftPlanRepository.findById(Integer.valueOf(id)).orElse(null);
            if(shiftPlan == null){
                throw new Exception("Invalid  shiftplan id");
            }
        }

        shiftPlan.setShift_name(name);
        shiftPlan.setFromTime(Time.valueOf(fromTime));
        shiftPlan.setToTime(Time.valueOf(toTime));

         shiftPlanRepository.save(shiftPlan);
         return true;
    }
}
