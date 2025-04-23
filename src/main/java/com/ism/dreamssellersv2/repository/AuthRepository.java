package com.ism.dreamssellersv2.repository;

import com.ism.dreamssellersv2.model.AuthEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AuthRepository extends JpaRepository<AuthEntity, Integer> {
    Optional<AuthEntity> findByUsername(String username);
}
