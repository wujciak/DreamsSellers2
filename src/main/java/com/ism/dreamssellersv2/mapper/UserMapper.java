package com.ism.dreamssellersv2.mapper;

import com.ism.dreamssellersv2.model.UserEntity;
import com.ism.model.UserCreateDTO;
import com.ism.model.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    // UserEntity -> UserDTO
    @Mapping(source = "auth.username", target = "username")
    UserDTO userEntityToUserDTO(UserEntity userEntity);

    // UserCreateDTO -> UserEntity
    @Mapping(target = "auth.username", source = "username")
    @Mapping(target = "auth.password", ignore = true)
    UserEntity userCreateDTOToUserEntity(UserCreateDTO userCreateDTO);
}