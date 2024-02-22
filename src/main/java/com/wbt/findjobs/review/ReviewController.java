package com.wbt.findjobs.review;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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

    @GetMapping(path = {"/{reviewId}"})
    public ResponseEntity<Review> getReview(final @PathVariable(name = "reviewId") Long rId, final @PathVariable(name = "companyId") Long cId) {
        Optional<Review> optionalReview = this.reviewService.review(cId, rId);
        return optionalReview
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping(path = {"/{reviewId}"})
    public ResponseEntity<String> update(final @PathVariable(name = "companyId") Long cId, final @PathVariable(name = "reviewId") Long rId, final @RequestBody ReviewRequest reviewRequest) {
        final var isUpdated = this.reviewService.update(cId, rId, reviewRequest);
        if (isUpdated) return new ResponseEntity<>("Review resource updated successfully!", HttpStatus.OK);
        return new ResponseEntity<>("Resource not found", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping(path = {"/{reviewId}"})
    public ResponseEntity<String> delete(final @PathVariable(name = "companyId") Long cId, final @PathVariable(name = "reviewId") Long rId) {
        if (this.reviewService.delete(cId, rId))
            return new ResponseEntity<>("Resource successfully removed", HttpStatus.OK);
        return new ResponseEntity<>("Resource not found", HttpStatus.NOT_FOUND);
    }

}
