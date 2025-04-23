package com.ism.dreamssellersv2.controller;

import com.ism.api.UserApi;
import com.ism.model.UserCreateDTO;
import com.ism.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController implements UserApi {
    @Override
    public ResponseEntity<UserDTO> createUser(UserCreateDTO userCreateDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteUser(Integer userId) {
        return null;
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(Integer userId) {
        return null;
    }

    @Override
    public ResponseEntity<List<UserDTO>> getUsers() {
        return null;
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(Integer userId, UserCreateDTO userCreateDTO) {
        return null;
    }
}
