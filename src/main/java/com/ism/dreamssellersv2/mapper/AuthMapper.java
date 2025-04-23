package com.ism.dreamssellersv2.mapper;

import com.ism.dreamssellersv2.model.AuthEntity;
import com.ism.model.LoginDTO;
import com.ism.model.RegisterDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AuthMapper {

    // RegisterDTO -> AuthEntity
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", source = "password")
    AuthEntity registerDTOToAuthEntity(RegisterDTO registerDTO);

    // LoginDTO -> AuthEntity
    @Mapping(target = "username", source = "username")
    @Mapping(target = "password", ignore = true)
    AuthEntity loginDTOToAuthEntity(LoginDTO loginDTO);
}