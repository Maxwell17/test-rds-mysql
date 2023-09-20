package com.example.testrdsmysql.dto;

import com.example.testrdsmysql.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {

    @Mappings({
            @Mapping(target="username", source="username"),
            @Mapping(target="firstName", source="firstName"),
            @Mapping(target="lastName", source="lastName"),
            @Mapping(target="position", source="position")
    })
    UserDTO toDTO(User source);

    @Mappings({
            @Mapping(target="username", source="username"),
            @Mapping(target="firstName", source="firstName"),
            @Mapping(target="lastName", source="lastName"),
            @Mapping(target="position", source="position")
    })
    User fromDTO(UserDTO target);

}
