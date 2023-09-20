package com.example.testrdsmysql.dto;

import com.example.testrdsmysql.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface RoleMapper {

    @Mappings({
            @Mapping(target="name", source="name")
    })
    RoleDTO toDTO(Role source);

    @Mappings({
            @Mapping(target="name", source="name")
    })
    Role fromDTO(RoleDTO target);

}
