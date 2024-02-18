package com.wbt.findjobs.company;

import com.wbt.findjobs.job.Job;

import java.util.List;

public record CompanyRequest(String name, String description, List<Job> jobList) {
}
