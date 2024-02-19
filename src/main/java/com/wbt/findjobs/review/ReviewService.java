package com.wbt.findjobs.review;

import java.util.List;

public interface ReviewService {
    List<Review> findAll();
    List<Review> findAllByCompany(final Long companyId);

    String create(final Long companyId, final ReviewRequest request);

//    @Query("select r from Review r where r.company.id = :companyId")
//    Optional<Review> review(final Long companyId, final Long reviewId);
//
//    Boolean delete(final Long reviewId);
//
//    Boolean update(final Long reviewId, final ReviewRequest request);
}
