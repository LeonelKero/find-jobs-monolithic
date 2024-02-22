package com.wbt.findjobs.review.impl;

import com.wbt.findjobs.company.CompanyService;
import com.wbt.findjobs.review.Review;
import com.wbt.findjobs.review.ReviewRepository;
import com.wbt.findjobs.review.ReviewRequest;
import com.wbt.findjobs.review.ReviewService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReviewServiceImpl implements ReviewService {
    private final ReviewRepository reviewRepository;
    private final CompanyService companyService;

    public ReviewServiceImpl(final ReviewRepository reviewRepository, CompanyService companyService) {
        this.reviewRepository = reviewRepository;
        this.companyService = companyService;
    }

    @Override
    public List<Review> findAll() {
        return this.reviewRepository.findAll();
    }

    @Override
    public List<Review> findAllByCompany(Long companyId) {
        return this.reviewRepository.findByCompanyId(companyId);
    }

    @Override
    public String create(final Long companyId, final ReviewRequest request) {
        final var optionalCompany = this.companyService.findById(companyId);
        if (optionalCompany.isPresent()) {
            final var review = new Review(request.title(), request.content(), request.rating());
            review.setCompany(optionalCompany.get());
            this.reviewRepository.save(review);
            return "Review for company %s successfully saved".formatted(companyId);
        }
        return null;
    }

    @Override
    public Optional<Review> review(final Long companyId, final Long reviewId) {
        if (this.companyService.exists(companyId)) {
            return this.reviewRepository.findByIdAndCompanyId(reviewId, companyId);
        }
        return Optional.empty();
    }

    @Override
    public boolean delete(final Long companyId, final Long reviewId) {
        if (this.companyService.exists(companyId) && this.reviewRepository.existsById(reviewId)) {
            this.reviewRepository.deleteById(reviewId);
            return true;
        }
        return false;
    }

    @Override
    public Boolean update(final Long companyId, final Long reviewId, final ReviewRequest request) {
        final var optionalCompany = this.companyService.findById(companyId);
        if (optionalCompany.isPresent()) {
            final var optionalReview = this.review(optionalCompany.get().getId(), reviewId);
            if (optionalReview.isPresent()) {
                final var review = optionalReview.get();
                review.setTitle(request.title());
                review.setContent(request.content());
                review.setRating(request.rating());
                this.reviewRepository.save(review);
                return true;
            }
            return false;
        }
        return false;
    }
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
