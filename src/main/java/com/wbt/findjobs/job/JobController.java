package com.wbt.findjobs.job;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/jobs")
public record JobController() {
    private static final List<Job> jobs = new ArrayList<Job>();

    @GetMapping
    public List<Job> findAll() {
        return jobs;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String create(final @RequestBody Job job) {
        jobs.add(job);
        return "Created Successfully!";
    }
}
