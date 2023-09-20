package com.example.testrdsmysql.controller;

import com.example.testrdsmysql.controller.advice.UserNotFoundException;
import com.example.testrdsmysql.dto.UserDTO;
import com.example.testrdsmysql.dto.UserMapper;
import com.example.testrdsmysql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    private final UserMapper mapper;

    @GetMapping
    public ResponseEntity<List<UserDTO>> users() {
        return ResponseEntity.ok(userService
                .findUsers()
                .stream()
                .map(mapper::toDTO)
                .toList()
        );
    }

    @GetMapping("/{username}")
    public ResponseEntity<UserDTO> findByUsername(@PathVariable String username) {
        return ResponseEntity.ok(userService
                .findUserByUsername(username)
                .map(mapper::toDTO)
                .orElseThrow(() -> new UserNotFoundException(username))
        );
    }

}
