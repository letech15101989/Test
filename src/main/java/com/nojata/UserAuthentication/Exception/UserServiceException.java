/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.Exception;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;

/**
 *
 * @author Shamsher
 */
@Data
@ControllerAdvice
public class UserServiceException   extends RuntimeException{
    
    private String errorCode;
    public UserServiceException(){
    super();
    }
    
    public UserServiceException(String status, String message){
    super(message);
    this.errorCode = status;
    
    }
    
}
