package com.example.testrdsmysql.dto;

import com.example.testrdsmysql.entity.Role;

import java.util.Set;

public record UserDTO(String username, String firstName, String lastName, String position, Set<Role> roles) {
}
