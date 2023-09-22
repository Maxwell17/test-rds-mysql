package com.example.testrdsmysql.dto;

import com.example.testrdsmysql.entity.RoleName;
import com.fasterxml.jackson.annotation.JsonProperty;

public record RoleDTO(@JsonProperty("role_id") Long roleId,
                      @JsonProperty("name") RoleName name) {
}
