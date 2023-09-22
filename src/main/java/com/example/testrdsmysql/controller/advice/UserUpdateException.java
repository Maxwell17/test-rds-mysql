package com.example.testrdsmysql.controller.advice;

import lombok.Getter;
import lombok.experimental.StandardException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@StandardException
@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class UserUpdateException extends RuntimeException {

    private String username;

    public UserUpdateException(String username) {
        this.username = username;
    }

}
