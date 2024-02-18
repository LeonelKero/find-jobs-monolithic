package com.wbt.findjobs.job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/jobs")
public record JobController(JobService jobService) {

    @GetMapping
    public ResponseEntity<List<Job>> findAll() {
        return new ResponseEntity<>(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> create(final @RequestBody Job job) {
        jobService.create(job);
        return new ResponseEntity<>("Created Successfully!", HttpStatus.CREATED);
    }

    @GetMapping(path = {"/{id}"})
    public ResponseEntity<Job> get(final @PathVariable(name = "id") Long id) {
        final var job = this.jobService.findById(id);
        if (job == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(job);
    }

    @DeleteMapping(path = {"/{id}"})
    public ResponseEntity<String> remove(final @PathVariable(name = "id") Long id) {
        final var deleted = this.jobService.delete(id);
        if (deleted) return new ResponseEntity<>("Job deleted successfully", HttpStatus.OK);
        return new ResponseEntity<>("Resource with iid %s is missing".formatted(id), HttpStatus.NOT_FOUND);
    }
}
