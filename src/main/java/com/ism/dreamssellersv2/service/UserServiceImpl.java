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
    public List<UserDTO> getUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::userEntityToUserDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUserById(Integer userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));
        return userMapper.userEntityToUserDTO(userEntity);
    }

    @Override
    public UserDTO createUser(UserCreateDTO userCreateDTO) {
        UserEntity userEntity = userMapper.userCreateDTOToUserEntity(userCreateDTO);
        return userMapper.userEntityToUserDTO(userRepository.save(userEntity));
    }

    @Override
    public UserDTO updateUser(Integer userId, UserCreateDTO userCreateDTO) {
        UserEntity existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        UserEntity updatedUser = userMapper.userCreateDTOToUserEntity(userCreateDTO);
        updatedUser.setUserId(existingUser.getUserId());
        return userMapper.userEntityToUserDTO(userRepository.save(updatedUser));
    }

    @Override
    public void deleteUser(Integer userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(userId);
    }
}