package com.wbt.findjobs.job.impl;

import com.wbt.findjobs.job.Job;
import com.wbt.findjobs.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public Boolean delete(final Long jobId) {
        final var jobIterator = jobs.iterator();
        while (jobIterator.hasNext()) {
            if (jobIterator.next().getId().equals(jobId)) {
                jobIterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean update(final Long jobId, final Job job) {
        for (Job j : jobs) {
            if (j.getId().equals(jobId)) {
                j.setTitle(job.getTitle());
                j.setDescription(job.getDescription());
                j.setLocation(job.getLocation());
                j.setMaxSalary(job.getMaxSalary());
                j.setMinSalary(job.getMinSalary());
                return true;
            }
        }
        return false;
    }
}
