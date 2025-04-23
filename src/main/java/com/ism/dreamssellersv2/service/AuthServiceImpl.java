package com.ism.dreamssellersv2.service;

import com.ism.dreamssellersv2.mapper.AuthMapper;
import com.ism.dreamssellersv2.model.AuthEntity;
import com.ism.dreamssellersv2.model.UserEntity;
import com.ism.dreamssellersv2.repository.AuthRepository;
import com.ism.dreamssellersv2.repository.UserRepository;
import com.ism.model.LoginDTO;
import com.ism.model.LoginResponseDTO;
import com.ism.model.RegisterDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Transactional
public class AuthServiceImpl implements AuthService {

    private final AuthRepository authRepository;
    private final UserRepository userRepository;
    private final AuthMapper authMapper;

    public AuthServiceImpl(AuthRepository authRepository, UserRepository userRepository, AuthMapper authMapper) {
        this.authRepository = authRepository;
        this.userRepository = userRepository;
        this.authMapper = authMapper;
    }

    @Override
    public LoginResponseDTO register(RegisterDTO registerDTO) {
        if (authRepository.findByUsername(registerDTO.getUsername()).isPresent()) {
            throw new RuntimeException("Username already taken");
        }
        AuthEntity authEntity = authMapper.registerDTOToAuthEntity(registerDTO);
        authEntity.setPassword(registerDTO.getPassword());
        UserEntity userEntity = new UserEntity();
        userEntity.setName(registerDTO.getName());
        authEntity.setUser(userEntity);
        userEntity.setAuth(authEntity);
        userRepository.save(userEntity);
        authRepository.save(authEntity);

        return new LoginResponseDTO().username(authEntity.getUsername());
    }

    @Override
    public LoginResponseDTO login(LoginDTO loginDTO) {
        Optional<AuthEntity> optionalAuth = authRepository.findByUsername(loginDTO.getUsername());

        if (optionalAuth.isPresent()) {
            AuthEntity authEntity = optionalAuth.get();

            if (authEntity.getPassword().equals(loginDTO.getPassword())) {
                return new LoginResponseDTO().username(authEntity.getUsername());
            } else {
                throw new RuntimeException("Invalid password");
            }
        } else {
            throw new RuntimeException("Username not found");
        }
    }
}