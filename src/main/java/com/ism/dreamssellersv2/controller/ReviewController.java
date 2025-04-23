package com.ism.dreamssellersv2.controller;

import com.ism.api.ReviewApi;
import com.ism.model.ReviewCreateDTO;
import com.ism.model.ReviewDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ReviewController implements ReviewApi {
    @Override
    public ResponseEntity<ReviewDTO> createReview(ReviewCreateDTO reviewCreateDTO) {
        return null;
    }

    @Override
    public ResponseEntity<Void> deleteReview(Integer reviewId) {
        return null;
    }

    @Override
    public ResponseEntity<ReviewDTO> getReviewById(Integer reviewId) {
        return null;
    }

    @Override
    public ResponseEntity<List<ReviewDTO>> getReviews() {
        return null;
    }
}
