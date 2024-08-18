/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.controller;

import com.nojata.UserAuthentication.model.entity.ShiftPlan;
import com.nojata.UserAuthentication.services.ShiftPlanService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Shamsher
 */
@RestController
@RequestMapping("/companyshiftplan")
public class ShiftPlanController {
    
    @Autowired
    ShiftPlanService shiftPlanService;
    
    @GetMapping("/shiftplan")
    public List<ShiftPlan>  getAllShiftPlan() {
            List<ShiftPlan> shiftPlans = shiftPlanService.findAll();
            return shiftPlans;
    }

    @PostMapping("/deleteshiftplan")
    public boolean  deleteShiftPlan(@RequestParam("id") String id) {
        return shiftPlanService.deleteShiftPlan(Integer.valueOf(id));

    }

    @PostMapping("/createShiftplan")
    public boolean  createShiftPlan( @RequestParam("name") String shiftName, @RequestParam("fromTime") String fromTime, @RequestParam("toTime") String toTime) throws Exception {
        return shiftPlanService.updateShiftPlan(null, shiftName, fromTime, toTime);

    }

    @PutMapping("/updateShiftplan")
    public boolean  updateShiftPlan(@RequestParam("id") String id, @RequestParam("name") String shiftName, @RequestParam("fromTime") String fromTime, @RequestParam("toTime") String toTime) throws  Exception {
        return shiftPlanService.updateShiftPlan(id, shiftName, fromTime, toTime);

    }
    
}
