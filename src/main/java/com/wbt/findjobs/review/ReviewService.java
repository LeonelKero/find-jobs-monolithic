package com.wbt.findjobs.review;

import java.util.List;
import java.util.Optional;

public interface ReviewService {
    List<Review> findAll();

    Optional<Review> review(final Long reviewId);

    Boolean delete(final Long reviewId);

    Boolean update(final Long reviewId, final ReviewRequest request);
}
