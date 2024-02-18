package com.wbt.findjobs.job.impl;

import com.wbt.findjobs.job.Job;
import com.wbt.findjobs.job.JobRepository;
import com.wbt.findjobs.job.JobService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobServiceImpl implements JobService {

    private final JobRepository jobRepository;

    public JobServiceImpl(JobRepository jobRepository) {
        this.jobRepository = jobRepository;
    }

    @Override
    public List<Job> findAll() {
        return this.jobRepository.findAll();
    }

    @Override
    public void create(final Job newJob) {
        this.jobRepository.save(newJob);
    }

    @Override
    public Job findById(final Long jobId) {
        return this.jobRepository.findById(jobId).orElse(null);
    }

    @Override
    public Boolean delete(final Long jobId) {
        try {
            this.jobRepository.deleteById(jobId);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Boolean update(final Long jobId, final Job job) {
        final var j = this.findById(jobId);
        if (j != null) {
            j.setTitle(job.getTitle());
            j.setDescription(job.getDescription());
            j.setLocation(job.getLocation());
            j.setMaxSalary(job.getMaxSalary());
            j.setMinSalary(job.getMinSalary());
            return true;
        }
        return false;
    }
}
