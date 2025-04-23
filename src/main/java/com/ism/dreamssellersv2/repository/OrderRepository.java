package com.ism.dreamssellersv2.repository;

import com.ism.dreamssellersv2.model.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<OrderEntity, Integer> {
    List<OrderEntity> findByUser_UserId(Integer userId);
    List<OrderEntity> findByStatus(String status);
    List<OrderEntity> findByTotalPriceGreaterThan(Double price);
}