package com.ism.dreamssellersv2.controller;

import com.ism.api.AuthApi;
import com.ism.dreamssellersv2.service.AuthService;
import com.ism.model.LoginDTO;
import com.ism.model.LoginResponseDTO;
import com.ism.model.RegisterDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController implements AuthApi {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<LoginResponseDTO> login(LoginDTO loginDTO) {
        return ResponseEntity.ok(authService.login(loginDTO));
    }

    @Override
    public ResponseEntity<LoginResponseDTO> register(RegisterDTO registerDTO) {
        return ResponseEntity.ok(authService.register(registerDTO));
    }
}