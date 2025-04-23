package com.ism.dreamssellersv2.service;

import com.ism.model.UserCreateDTO;
import com.ism.model.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserCreateDTO userCreateDTO);
    void deleteUser(Integer userId);
    UserDTO getUserById(Integer userId);
    List<UserDTO> getUsers();
    UserDTO updateUser(Integer userId, UserCreateDTO userCreateDTO);
}