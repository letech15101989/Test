/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.controller;


import com.nojata.UserAuthentication.model.entity.Aktivities;
import com.nojata.UserAuthentication.services.CompanyService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.nojata.UserAuthentication.model.entity.Compnay;
import java.util.List;

/**
 *
 * @author Shamsher
 */
@RestController
@RequestMapping("/company")
public class CompnayController {
    @Autowired
    CompanyService service;

   
    @PostMapping("/createCompany")
     public ResponseEntity<String> uploadFile(@RequestParam("logo") MultipartFile file,
                             @RequestParam("name") String name,
                             @RequestParam("address") String address) {
        // Process uploaded data here
        // You can save the logo file to a directory, save name and address to a database, etc.
        System.out.println("Shamsher chacha..>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
         if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Please select a file to upload");
        }
         try {
              String base64Image = org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(file.getBytes());
         service.saveCompany(name, address, file.getBytes());
         }catch(Exception nn){
         nn.printStackTrace();
         }
        return ResponseEntity.status(HttpStatus.OK).body("Company saved successfully");
    }
     
     
     @GetMapping("/companyView")
     public ResponseEntity<Compnay> viewCompany(@RequestParam("compId")  String compId) {
         Compnay comp =null;
         try {
             comp =      service.getCompany(compId);
            
         }catch(Exception nn){
         nn.printStackTrace();
         }
        return ResponseEntity.status(HttpStatus.OK).body(comp);
    }
     
     @DeleteMapping("/delete")
     public ResponseEntity<Boolean> deleteCompany(@RequestParam("compId")  String compId) {
         System.out.println("delete comp id :"+compId);
         boolean isDeleted = false;
         try {
             isDeleted =      service.deleteCompany(compId);
            
         }catch(Exception nn){
         nn.printStackTrace();
         return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(isDeleted);
         }
        return ResponseEntity.status(HttpStatus.OK).body(isDeleted);
    }
    
     
      @GetMapping("/company")
     public ResponseEntity<List<Compnay>> viewCompany() {
        List<Compnay>comp =null;
         try {
             comp =      service.getAllCompany();
            
         }catch(Exception nn){
         nn.printStackTrace();
         }
        return ResponseEntity.status(HttpStatus.OK).body(comp);
    }
    
     
     @PostMapping("/updatecompany")
       public ResponseEntity<String> uploadFile(@RequestParam("logo") MultipartFile file,
                             @RequestParam("name") String name,
                             @RequestParam("address") String address,
                             @RequestParam("compId") String compId) {
            System.out.println("update company called");
         if (compId.isEmpty() || compId ==null ) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Company id is null.");
        }
         try {
              String base64Image = "";
             if(!file.isEmpty()){
               base64Image = org.apache.tomcat.util.codec.binary.Base64.encodeBase64String(file.getBytes());
             }
         service.updateCompany(compId, name, address, file.getBytes());
         }catch(Exception nn){
         nn.printStackTrace();
         }
        return ResponseEntity.status(HttpStatus.OK).body("Company saved successfully");
    }
     
       @GetMapping("/aktivity")
     public ResponseEntity<List<Aktivities>> viewAktivity() {
        List<Aktivities>comp =null;
         try {
             comp =      service.getAllAktivities();
            
         }catch(Exception nn){
         nn.printStackTrace();
         }
        return ResponseEntity.status(HttpStatus.OK).body(comp);
    }


    @PostMapping("addActivity")
    public boolean addActivity(String id, String name, String shiftPlan, String userId) {
        List<Aktivities>comp =null;
        try {
            return service.createActivities(null, name, shiftPlan, userId);

        }catch(Exception nn){
            nn.printStackTrace();
        }
        return false;
    }
    
}
