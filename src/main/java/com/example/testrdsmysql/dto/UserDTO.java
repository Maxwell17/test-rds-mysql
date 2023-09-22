package com.example.testrdsmysql.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Set;

public record UserDTO(@JsonProperty("user_id") Long userId,
                      @JsonProperty("username") String username,
                      @JsonProperty("first_name") String firstName,
                      @JsonProperty("last_name") String lastName,
                      @JsonProperty("position") String position,
                      @JsonProperty("roles") Set<RoleDTO> roleDTOs) {
}
