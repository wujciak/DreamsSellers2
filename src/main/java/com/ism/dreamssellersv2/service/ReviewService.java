package com.ism.dreamssellersv2.service;

import com.ism.model.ReviewCreateDTO;
import com.ism.model.ReviewDTO;

import java.util.List;

public interface ReviewService {
    List<ReviewDTO> getReviews();
    ReviewDTO getReviewById(Integer reviewId);
    ReviewDTO createReview(ReviewCreateDTO reviewCreateDTO);
    void deleteReview(Integer reviewId);
}