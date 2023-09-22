package com.example.testrdsmysql.controller;

import com.example.testrdsmysql.controller.advice.UserCreateException;
import com.example.testrdsmysql.controller.advice.UserNotFoundException;
import com.example.testrdsmysql.dto.UserDTO;
import com.example.testrdsmysql.dto.UserMapper;
import com.example.testrdsmysql.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static java.util.Objects.nonNull;

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

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody Optional<UserDTO> userDTO) {
        return ResponseEntity.ok(userDTO
                .map(this.mapper::fromDTO)
                .map(userService::create)
                .map(this.mapper::toDTO)
                .orElseThrow(UserCreateException::new)
        );
    }

    @PutMapping
    public ResponseEntity<UserDTO> updateUser(@RequestBody Optional<UserDTO> userDTO) {
        return ResponseEntity.ok(userDTO
                .filter(u -> nonNull(u.userId()))
                .map(this.mapper::fromDTO)
                .map(userService::update)
                .map(this.mapper::toDTO)
                .orElseThrow(UserCreateException::new)
        );
    }

}
