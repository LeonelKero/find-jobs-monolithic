package com.wbt.findjobs.review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAll();

    List<Review> findAllByCompany(final Long companyId);

    String create(final Long companyId, final ReviewRequest request);

    Optional<Review> review(final Long companyId, final Long reviewId);

    boolean delete(final Long companyId, final Long reviewId);

    Boolean update(final Long companyId, final Long reviewId, final ReviewRequest request);
}
