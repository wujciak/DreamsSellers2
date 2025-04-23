package com.ism.dreamssellersv2.controller;

import com.ism.api.ReviewApi;
import com.ism.dreamssellersv2.service.ReviewService;
import com.ism.model.ReviewCreateDTO;
import com.ism.model.ReviewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController implements ReviewApi {

    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @Override
    public ResponseEntity<ReviewDTO> createReview(ReviewCreateDTO reviewCreateDTO) {
        return ResponseEntity.ok(reviewService.createReview(reviewCreateDTO));
    }

    @Override
    public ResponseEntity<Void> deleteReview(Integer reviewId) {
        reviewService.deleteReview(reviewId);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<ReviewDTO> getReviewById(Integer reviewId) {
        return ResponseEntity.ok(reviewService.getReviewById(reviewId));
    }

    @Override
    public ResponseEntity<List<ReviewDTO>> getReviews() {
        return ResponseEntity.ok(reviewService.getReviews());
    }
}