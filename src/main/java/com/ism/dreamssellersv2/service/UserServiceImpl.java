package com.ism.dreamssellersv2.service;

import com.ism.dreamssellersv2.mapper.UserMapper;
import com.ism.dreamssellersv2.model.UserEntity;
import com.ism.dreamssellersv2.repository.UserRepository;
import com.ism.model.UserCreateDTO;
import com.ism.model.UserDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    
    @Override
    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        UserEntity userEntity = userMapper.userCreateDTOToUserEntity(userCreateDTO);
        return userMapper.userEntityToUserDTO(userRepository.save(userEntity));
    }
    
    @Override
    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);
    }
    
    @Override
    public UserDTO getUserById(Integer userId) {
        return userRepository.findById(userId)
                .map(userMapper::userEntityToUserDTO)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
    
    @Override
    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::userEntityToUserDTO)
                .collect(Collectors.toList());
    }
    
    @Override
    public UserDTO updateUser(Integer userId, UserCreateDTO userCreateDTO) {
        UserEntity existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        existingUser.setName(userCreateDTO.getName());
        existingUser.setAuth(userMapper.userCreateDTOToUserEntity(userCreateDTO).getAuth());
        return userMapper.userEntityToUserDTO(userRepository.save(existingUser));
    }
}