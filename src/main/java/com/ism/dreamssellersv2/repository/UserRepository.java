package com.ism.dreamssellersv2.repository;

import com.ism.dreamssellersv2.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByName(String name);
    Optional<UserEntity> findByAuth_Username(String username);
}