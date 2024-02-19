package com.wbt.findjobs.review.impl;

import com.wbt.findjobs.review.Review;
import com.wbt.findjobs.review.ReviewRepository;
import com.wbt.findjobs.review.ReviewRequest;
import com.wbt.findjobs.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;

    public ReviewServiceImpl(final ReviewRepository reviewRepository) {
        this.reviewRepository = reviewRepository;
    }

    @Override
    public List<Review> findAll() {
        return this.reviewRepository.findAll();
    }

    @Override
    public List<Review> findAllByCompany(Long companyId) {
        return this.reviewRepository.findByCompanyId(companyId);
    }

//    @Override
//    public Optional<Review> review(final Long companyId, final Long reviewId) {
//        return this.reviewRepository.findById(reviewId);
//    }
//
//    @Override
//    public Boolean delete(final Long reviewId) {
//        if (this.reviewRepository.existsById(reviewId)) {
//            this.reviewRepository.deleteById(reviewId);
//            return true;
//        }
//        return false;
//    }
//
//    @Override
//    public Boolean update(final Long reviewId, final ReviewRequest request) {
//        return null;
//    }
}
