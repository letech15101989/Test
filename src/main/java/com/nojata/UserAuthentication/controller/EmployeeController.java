/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.controller;

import com.nojata.UserAuthentication.model.entity.Employee;
import com.nojata.UserAuthentication.services.EmployeeService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author Shamsher
 */
@RestController
@RequestMapping("/emp")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("getAllEmp")
    public List<Employee> getAllEmployee() {

        return service.getAllEmployee();
    }
    
    @PostMapping("deleteEmployee")
    public boolean deleteEmployee(@RequestParam("empId") String empId){
      return service.deleteEmployee(empId);
    }

    @PostMapping("updateEmployee")
    public String iupdateEmployee(@RequestParam("empId") String empId,  @RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("mobileNo") String mobileNo, @RequestParam("companyId") String companyId) {
        System.out.println("employee id in updateEmployee:"+empId);
        String data = service.saveEmployee(empId, name, address, "Finland", companyId);
        return data;
    }

    @PostMapping("createEmployee")
    public String createEmployee(@RequestParam("name") String name, @RequestParam("address") String address, @RequestParam("mobileNo") String mobileNo, @RequestParam("companyId") String companyId) {
        String data = service.saveEmployee(null, name, address, "Finland", companyId);
        return data;
    }
}
