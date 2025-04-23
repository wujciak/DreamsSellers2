package com.ism.dreamssellersv2.repository;

import com.ism.dreamssellersv2.model.VendorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VendorRepository extends JpaRepository<VendorEntity, Integer> {
    List<VendorEntity> findByVerifiedTrue();
    List<VendorEntity> findByNameContainingIgnoreCase(String name);
}