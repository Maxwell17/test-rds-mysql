package com.example.testrdsmysql.controller.advice;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@Log4j2
@ControllerAdvice
public class UserControllerAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> notFound(UserNotFoundException exc) {
        return new ResponseEntity<>(new ErrorDTO("Cannot find user with username: " + exc.getUsername(), LocalDateTime.now()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserCreateException.class)
    public ResponseEntity<ErrorDTO> errorCreate(UserCreateException exc) {
        return new ResponseEntity<>(new ErrorDTO("Cannot create user with username: " + exc.getUsername(), LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UserUpdateException.class)
    public ResponseEntity<ErrorDTO> errorCreate(UserUpdateException exc) {
        return new ResponseEntity<>(new ErrorDTO("Cannot create user with username: " + exc.getUsername(), LocalDateTime.now()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
