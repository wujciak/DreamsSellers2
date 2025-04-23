package com.ism.dreamssellersv2.service;

import com.ism.model.LoginDTO;
import com.ism.model.LoginResponseDTO;
import com.ism.model.RegisterDTO;

public interface AuthService {
    LoginResponseDTO register(RegisterDTO registerDTO);
    LoginResponseDTO login(LoginDTO loginDTO);
}