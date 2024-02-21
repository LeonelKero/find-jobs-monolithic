package com.wbt.findjobs.review;

import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAll();

    List<Review> findAllByCompany(final Long companyId);

    String create(final Long companyId, final ReviewRequest request);

    Optional<Review> review(final Long companyId, final Long reviewId);

//    @Query("select r from Review r where r.company.id = :companyId")
//    Optional<Review> review(final Long companyId, final Long reviewId);
//
//    Boolean delete(final Long reviewId);
//
//    Boolean update(final Long reviewId, final ReviewRequest request);
}
