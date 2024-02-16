package com.wbt.findjobs.job;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/jobs")
public record JobController(JobService jobService) {

    @GetMapping
    public List<Job> findAll() {
        return jobService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(final @RequestBody Job job) {
        jobService.create(job);
        return "Created Successfully!";
    }

    @GetMapping(path = {"/{id}"})
    public Job get(final @PathVariable(name = "id") Long id) {
        return this.jobService.findById(id);
    }
}
