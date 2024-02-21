package com.wbt.findjobs.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(final Long companyId);

    Optional<Review> findByIdAndCompanyId(final Long reviewId, final Long companyId);
}
