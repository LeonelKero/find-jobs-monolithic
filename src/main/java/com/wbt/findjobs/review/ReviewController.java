package com.wbt.findjobs.review;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = {"/companies/{companyId}/reviews"})
public record ReviewController(ReviewService reviewService) {
    @GetMapping
    public ResponseEntity<List<Review>> allReviews(@PathVariable(name = "companyId") Long id) {
        return ResponseEntity.ok(this.reviewService().findAllByCompany(id));
    }

    @PostMapping
    public ResponseEntity<String> add(final @PathVariable(name = "companyId") Long id, final @RequestBody ReviewRequest review) {
        String response = this.reviewService.create(id, review);
        if (response != null) return ResponseEntity.ok(response);
        return ResponseEntity.badRequest().build();
    }

}
