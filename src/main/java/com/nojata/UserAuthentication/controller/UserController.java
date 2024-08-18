/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.controller;

import com.nojata.UserAuthentication.model.dto.LoginInput;
import com.nojata.UserAuthentication.model.dto.SignupInput;
import com.nojata.UserAuthentication.model.dto.UserDetails;
import com.nojata.UserAuthentication.model.dto.UserResponse;
import com.nojata.UserAuthentication.services.UserService;
import java.util.Map;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.mail.MailSender;  
import org.springframework.mail.SimpleMailMessage;  
import org.springframework.mail.javamail.JavaMailSender;
import javax.mail.internet.MimeMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

/**
 *
 * @author Shamsher
 */
@RestController
public class UserController {
    
    @Autowired
    UserService userservice;
    
    
    
    @PostMapping(path = "/user")
    public String createUser(@RequestBody SignupInput  userdetails){
        System.out.println("USer Details :"+userdetails);
        String isValid = userservice.createUser(userdetails);
        
        return isValid;
    
    }
    
    @GetMapping("/admin")
    public boolean isAdmin(@RequestParam String userEmail){
           return userservice.isAdmin(userEmail);
    }
    
     @PostMapping("/isValidUser")
    public ResponseEntity<UserResponse> isValidUser(@RequestBody LoginInput userDetails) {
         System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
        UserResponse  userResponse = userservice.isValidUser(userDetails);
        return ResponseEntity.ok().body(userResponse);
    }
    
    @PostMapping(name ="/request" , produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> requestResetPassword(@RequestBody Map<String, String> requestBody) {
        String email = requestBody.get("email");

        // Generate a unique token (you can use UUID.randomUUID() or a custom method)
        String token = generateToken();

        // Save the token along with the user's email in a database

        // Send email with reset link
        userservice.sendResetEmail(email, token);

        return ResponseEntity.ok("Password reset link sent to your email.");
    }

    @PostMapping("/reset")
    public ResponseEntity<String> resetPassword(@RequestBody LoginInput loginInput) {
        // Verify the token and get the associated user's email

 //      sendResetEmail("shamsherdemo@gmail.com",  "112ssdfc11xddddcdv455dfv1d54fd5f4d2v");
        String message = userservice.resetPassword(loginInput);
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }

    private String generateToken() {
        // Implement your token generation logic
        return UUID.randomUUID().toString();
    }

    
    
    
}
