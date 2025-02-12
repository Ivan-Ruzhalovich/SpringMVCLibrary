package com.ivan.mylibrary.exceptionsHalnder;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponseException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> validationsExc(ConstraintViolationException e){
        String s = "Поле E-mail " +  e.getConstraintViolations().stream().findFirst().get().getMessage();
        return new ResponseEntity(s,HttpStatus.BAD_GATEWAY);
    }

    @ExceptionHandler(ErrorResponseException.class)
    public ResponseEntity<String> bookEx(ErrorResponseException e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> otherExc(RuntimeException e){
        return new ResponseEntity(e.getMessage(),HttpStatus.BAD_GATEWAY);
    }
}
