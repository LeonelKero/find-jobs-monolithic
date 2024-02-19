package com.wbt.findjobs.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = {"/companies/{id}/reviews"})
public record ReviewController(ReviewService reviewService) {
    @GetMapping
    public ResponseEntity<List<Review>> allReviews() {
        return ResponseEntity.ok(this.reviewService().findAll());
    }

}
