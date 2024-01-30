package com.example.Service.GlobalExceptionHandler;

import com.example.Model.CustomExceptions.CustomerNotFoundException;
import com.example.Model.ResponsePojos.RequestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

     @ExceptionHandler(CustomerNotFoundException.class)
     public ResponseEntity<RequestResponse> handleCustomerNotFoundException(CustomerNotFoundException e){
         RequestResponse response = new RequestResponse();
         response.setStatusCode(HttpStatus.NOT_FOUND.value());
         response.setMessage(e.getMessage());
         return new ResponseEntity<>(response , HttpStatus.NOT_FOUND);
     }
}
