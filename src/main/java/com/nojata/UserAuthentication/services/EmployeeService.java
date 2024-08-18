/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.services;

import com.nojata.UserAuthentication.Util.RenadomNumberGenerator;
import com.nojata.UserAuthentication.model.entity.Compnay;
import com.nojata.UserAuthentication.model.entity.Employee;
import com.nojata.UserAuthentication.repositories.CompanyRepository;
import com.nojata.UserAuthentication.repositories.EmployeeRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Shamsher
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository rep;
    
    @Autowired
    CompanyRepository cr;
    
    public  List<Employee> getAllEmployee(){
              return rep.findAll();
     
    }
    
    public  boolean deleteEmployee(String empId){
         rep.deleteById(empId);
        return true;
    }
    
    public String  saveEmployee(String empId, String empName, String compAddr, String country, String compId){
               System.out.println("Employee empId  >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+empId);
               Employee employee = new Employee();

               if(empId ==null) {
                   empId = RenadomNumberGenerator.generate(empName.substring(0, 2));
                   employee.setEmpId(empId);
                   System.out.println("employee in if");
               } else {
                   employee = rep.findById(empId).get();
                System.out.println("employee in else"+employee);
               }

               employee.setEmpAddress(compAddr);
               employee.setEmpCountry(country);
             //  employee.setCompany(cr.getById(compId));
               employee.setEmpFirstName(empName);
               employee.setEmpEmailId("shamsherdemo@gmail.com");
               Compnay cmp = cr.findById("noGHI89Z70").orElse(null);
               employee.setCompany(null);
               employee.setEmpLastName("lsdtnsme");
               employee.setEmpMiddleName("middelName");
               employee.setEmpPostalCode("400101");
               employee.setEmpMobileNumber("9702380970");
               employee.setEmpRole("role");
               employee.setEmpTelephone("niull");
           //    employee.setEmp
               rep.save(employee);
               
               System.out.println("Employee created >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        return "saved";
    
    }
    
}
