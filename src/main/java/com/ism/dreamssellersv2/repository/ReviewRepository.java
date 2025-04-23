package com.ism.dreamssellersv2.repository;

import com.ism.dreamssellersv2.model.ReviewEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<ReviewEntity, Integer> {
    List<ReviewEntity> findByItem_ItemId(Integer itemId);
    List<ReviewEntity> findByUser_UserId(Integer userId);
    List<ReviewEntity> findByRatingGreaterThan(Float rating);
}