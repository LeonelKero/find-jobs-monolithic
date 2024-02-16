package com.wbt.findjobs.job.impl;

import com.wbt.findjobs.job.Job;
import com.wbt.findjobs.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobServiceImpl implements JobService {
    private final static List<Job> jobs = new ArrayList<>();

    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void create(final Job newJob) {
        jobs.add(newJob);
    }

    @Override
    public Job findById(final Long jobId) {
        final var job = jobs.stream().filter(j -> j.getId().equals(jobId)).findFirst();
        return job.orElse(null);
    }
}
