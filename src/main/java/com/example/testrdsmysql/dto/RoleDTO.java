package com.example.testrdsmysql.dto;

import com.example.testrdsmysql.entity.RoleName;

public record RoleDTO(RoleName name, UserDTO userDTO) {
}
