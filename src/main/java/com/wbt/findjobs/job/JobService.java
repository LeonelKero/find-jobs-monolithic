package com.wbt.findjobs.job;

import com.wbt.findjobs.job.Job;

import java.util.List;

public interface JobService {
    List<Job> findAll();

    void create(final Job job);

    Job findById(final Long jobId);

    Boolean delete(final Long jobId);
}
