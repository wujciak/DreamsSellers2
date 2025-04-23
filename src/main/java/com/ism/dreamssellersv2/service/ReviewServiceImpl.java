package com.ism.dreamssellersv2.service;

import com.ism.dreamssellersv2.mapper.ReviewMapper;
import com.ism.dreamssellersv2.model.ReviewEntity;
import com.ism.dreamssellersv2.repository.ReviewRepository;
import com.ism.model.ReviewCreateDTO;
import com.ism.model.ReviewDTO;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ReviewServiceImpl implements ReviewService {

    private final ReviewRepository reviewRepository;
    private final ReviewMapper reviewMapper;

    public ReviewServiceImpl(ReviewRepository reviewRepository, ReviewMapper reviewMapper) {
        this.reviewRepository = reviewRepository;
        this.reviewMapper = reviewMapper;
    }

    @Override
    public List<ReviewDTO> getReviews() {
        return reviewRepository.findAll()
                .stream()
                .map(reviewMapper::reviewEntityToReviewDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ReviewDTO getReviewById(Integer reviewId) {
        ReviewEntity reviewEntity = reviewRepository.findById(reviewId)
                .orElseThrow(() -> new RuntimeException("Review not found"));
        return reviewMapper.reviewEntityToReviewDTO(reviewEntity);
    }

    @Override
    public ReviewDTO createReview(ReviewCreateDTO reviewCreateDTO) {
        ReviewEntity reviewEntity = reviewMapper.reviewCreateDTOToReviewEntity(reviewCreateDTO);
        return reviewMapper.reviewEntityToReviewDTO(reviewRepository.save(reviewEntity));
    }

    @Override
    public void deleteReview(Integer reviewId) {
        if (!reviewRepository.existsById(reviewId)) {
            throw new RuntimeException("Review not found");
        }
        reviewRepository.deleteById(reviewId);
    }
}