package com.example.testrdsmysql.controller.advice;

import lombok.Getter;
import lombok.experimental.StandardException;

@StandardException
public class UserNotFoundException extends RuntimeException {

    @Getter
    private String username;

    public UserNotFoundException(String username) {
        this.username = username;
    }
}
