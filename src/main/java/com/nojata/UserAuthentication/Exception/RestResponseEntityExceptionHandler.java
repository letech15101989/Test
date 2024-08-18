/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nojata.UserAuthentication.Exception;

import org.omg.CORBA.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 *
 * @author Shamsher
 */
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    
    @ExceptionHandler(UserServiceException.class)
    public ResponseEntity<ErrorResponse> handleException(UserServiceException exception){
       
        return new ResponseEntity<ErrorResponse>(new ErrorResponse().builder().errorMessage(exception.getErrorCode()).errorStatus(exception.getMessage()).build(), HttpStatus.NOT_FOUND);
    
    }
    
}
