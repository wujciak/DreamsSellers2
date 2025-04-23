package com.ism.dreamssellersv2.service;

import com.ism.model.UserCreateDTO;
import com.ism.model.UserDTO;

import java.util.List;

public interface UserService {
    List<UserDTO> getUsers();
    UserDTO getUserById(Integer userId);
    UserDTO createUser(UserCreateDTO userCreateDTO);
    UserDTO updateUser(Integer userId, UserCreateDTO userCreateDTO);
    void deleteUser(Integer userId);
}