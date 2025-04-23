package com.ism.dreamssellersv2.repository;

import com.ism.dreamssellersv2.model.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<ItemEntity, Integer> {
    List<ItemEntity> findByNameContainingIgnoreCase(String name);
    List<ItemEntity> findByVendor_VendorId(Integer vendorId);
    List<ItemEntity> findByStockLessThan(Integer stock);
}