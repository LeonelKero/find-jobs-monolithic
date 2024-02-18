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
        return ResponseEntity.ok(this.jobService.findById(id));
    }
}
