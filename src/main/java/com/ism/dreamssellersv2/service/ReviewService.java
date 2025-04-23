package com.ism.dreamssellersv2.service;

import com.ism.model.ReviewCreateDTO;
import com.ism.model.ReviewDTO;

import java.util.List;

public interface ReviewService {
    ReviewDTO createReview(ReviewCreateDTO reviewCreateDTO);
    void deleteReview(Integer reviewId);
    ReviewDTO getReviewById(Integer reviewId);
    List<ReviewDTO> getReviews();
}