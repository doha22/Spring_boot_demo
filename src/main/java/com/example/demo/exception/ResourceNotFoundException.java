package com.example.demo.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus
// @ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException{
    
//     @ControllerAdvice
// public class GlobalExceptionHandler {
//     @ExceptionHandler(ResourceNotFoundException.class)
//     public ResponseEntity<?> resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
//         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
//         return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
//     }

//     @ExceptionHandler(Exception.class)
//     public ResponseEntity<?> globleExcpetionHandler(Exception ex, WebRequest request) {
//         ErrorDetails errorDetails = new ErrorDetails(new Date(), ex.getMessage(), request.getDescription(false));
//         return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
//     }


private static final long serialVersionUID = 1L;

public ResourceNotFoundException(String message) {
    super(message);
}

public ResourceNotFoundException(String message, Throwable throwable) {
    super(message, throwable);
}
// public ResourceNotFoundException(String message){
//     super(message);
// }

}
