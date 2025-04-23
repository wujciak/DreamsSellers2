package com.ism.dreamssellersv2.controller;

import com.ism.api.UserApi;
import com.ism.dreamssellersv2.service.UserService;
import com.ism.model.UserCreateDTO;
import com.ism.model.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class UserController implements UserApi {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<UserDTO> createUser(UserCreateDTO userCreateDTO) {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "Feature not implemented yet");
    }

    @Override
    public ResponseEntity<Void> deleteUser(Integer userId) {
        userService.deleteUser(userId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<UserDTO> getUserById(Integer userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

    @Override
    public ResponseEntity<List<UserDTO>> getUsers() {
        return ResponseEntity.ok(userService.getUsers());
    }

    @Override
    public ResponseEntity<UserDTO> updateUser(Integer userId, UserCreateDTO userCreateDTO) {
        throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED, "Update feature is not implemented yet");
    }
}