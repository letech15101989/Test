/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.services;

import com.nojata.UserAuthentication.Exception.UserServiceException;
import com.nojata.UserAuthentication.model.dto.LoginInput;
import com.nojata.UserAuthentication.model.dto.SignupInput;
import javax.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nojata.UserAuthentication.model.dto.UserDetails;
import com.nojata.UserAuthentication.model.dto.UserResponse;
import com.nojata.UserAuthentication.model.entity.Address;
import com.nojata.UserAuthentication.model.entity.User;
import com.nojata.UserAuthentication.model.entity.UserRole;
import com.nojata.UserAuthentication.repositories.AddresRepository;
import com.nojata.UserAuthentication.repositories.RoleRepository;
import com.nojata.UserAuthentication.repositories.UserRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
/**
 *
 * @author Shamsher
 */
@Service
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public class UserService {
    @Autowired
    UserRepository userRepo;
    @Autowired
    AddresRepository address;
    @Autowired
    RoleRepository roleRepository;
    
     @Autowired
    private JavaMailSender emailSender;

    public String  createUser(SignupInput userdetails){
        try{
            
            System.out.println("started inserting");
            
           String password= userdetails.getUserName()+"@123456";
           com.nojata.UserAuthentication.model.entity.User user = new com.nojata.UserAuthentication.model.entity.User().builder().password(password).emailId(userdetails.getEmailId()).mobileNo(userdetails.getMobileNo()).userName(userdetails.getUserName()). build();
           userRepo.save(user);
            Address add= new Address().builder().city("Mumbai").country("India1").postalCode("4001101").street("Spanish residency11").state("Maharashtra").user(user). build();
            ArrayList arr= new ArrayList();
            UserRole userRole = new UserRole().builder().roleId(user.getUserId()).roleName("Accountant").userId(user.getUserId()).build();
            roleRepository.save(userRole);
            //arr.add(add);
            
        address.save(add);
           
        
        sendPasswordEmail(user.getEmailId(), password);
        return user.getUserId();
        }catch(Exception nn){
        
         throw new UserServiceException("DUPLICATE_ENTRY", "Provide mobile number or email id or username is already exist in database");
        }
    
    }
    
    
    public String  resetPassword(LoginInput loginInput){
        try{
            
            System.out.println("started inserting");
            
           String password= loginInput.getPassword();
                List<User> pp =   userRepo.findAll();
              List<User> userList =     pp.stream().filter(x-> x.getEmailId().equalsIgnoreCase(loginInput.getUserName()) ).collect(Collectors.toList());
              if(userList.size()>0){
                 User user = userList.get(0);
                 user.setPassword(password);
                 userRepo.save(user);
              }
        
        //sendPasswordEmail(user.getEmailId(), password);
        return "Password updated Sucessfully!!!";
        }catch(Exception nn){
        
         throw new UserServiceException("EXCEPTION", "Unable to update");
        }
    
    }
    
    public  void sendResetEmail(String email, String token) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Reset Your Password");
        message.setText("Click the link to reset your password: http://localhost:3000/reset-password?token=" + token);
        emailSender.send(message);
    }
    
        public  void sendPasswordEmail(String email, String password) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(email);
        message.setSubject("Temporary Password");
        message.setText(" Congratulations !!!!!! . Your password  :"+password + "for email id :"+email);
        emailSender.send(message);
    }
    
        public  UserResponse  isValidUser(LoginInput userdetails){
     
              UserDetails userDetails = new UserDetails();
            try{
             UserResponse userResponse = new UserResponse();
            System.out.println("checking user>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+userdetails.getUserName() );
            
            
           List<User> pp =   userRepo.findAll();
           pp.stream().forEach(x-> System.out.println("Fetched data from database >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+x.getEmailId() + ">>>password:"+x.getPassword() + ">><<<hhhhhh>>"+(x.getEmailId().equalsIgnoreCase(userdetails.getUserName()) && x.getPassword().equalsIgnoreCase(userDetails.getPassword()))));
           
            List<User> userList =     pp.stream().filter(x-> x.getEmailId().equalsIgnoreCase(userdetails.getUserName()) && x.getPassword().equalsIgnoreCase(userdetails.getPassword())).collect(Collectors.toList());
           User user =   userList.size() > 0 ? userList.get(0) : null;
           if(user != null){
             
               userDetails.setEmailId(user.getEmailId());
               userDetails.setMobileNo(user.getMobileNo());
               userDetails.setUserId(user.getUserId());
               userDetails.setUserName(user.getUserName());
               
         
           }
       
              return  UserResponse.builder().userDetails(userDetails).userRoles(user.getUserRole()).build();
        }catch(Exception nn){
        
         throw new UserServiceException("DUPLICATE_ENTRY", "Provide mobile number or email id or username is already exist in database");
        }
        }       
             

    public Boolean isAdmin(String emailId) {
        boolean isAdmin = false;
        try {
            UserResponse userResponse = new UserResponse();
            System.out.println("checking user>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>" + emailId);

            List<User> pp = userRepo.findAll();
         
            List<User> userList = pp.stream().filter(x -> x.getEmailId().equalsIgnoreCase(emailId) ).collect(Collectors.toList());
            User user = userList.size() > 0 ? userList.get(0) : null;
            
            
            if (user != null) {
               System.out.println("Shamsher role is :"+  user.getUserRole().get(0).getRoleName());
               
               if("ADMIN".equalsIgnoreCase(user.getUserRole().get(0).getRoleName())){
               isAdmin = true;
               System.out.println("role in admin :"+isAdmin);
               }
                
                List<UserRole> userRole = roleRepository.findAll();
                List<UserRole> roleList = userRole.stream().filter(x -> user.getUserId().equalsIgnoreCase(x.getUserId())).collect(Collectors.toList());
                if (roleList != null && roleList.size() == 0) {
                    isAdmin = "ADMIN".equalsIgnoreCase(roleList.get(0).getRoleName());
                      System.out.println("role in list :"+isAdmin);
                }
            }

        } catch (Exception nn) {

            throw new UserServiceException("DUPLICATE_ENTRY", "Provide mobile number or email id or username is already exist in database");
        }
       return isAdmin;
    }
  
}
