package com.example.testrdsmysql.dto;

import com.example.testrdsmysql.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {

    RoleDTO toDTO(Role source);

    Role fromDTO(RoleDTO destination);

}
