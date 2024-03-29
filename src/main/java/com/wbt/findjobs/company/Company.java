package com.wbt.findjobs.company;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.wbt.findjobs.job.Job;
import com.wbt.findjobs.review.Review;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    // link to jobs offer by this company
//    @JsonIgnore
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    private List<Job> jobs = new ArrayList<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "company", cascade = CascadeType.ALL)
    private List<Review> reviews = new ArrayList<>();

    public Company() {
    }

    public Company(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Company(String name, String description, List<Job> jobs) {
        this.name = name;
        this.description = description;
        this.jobs = jobs;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<Job> getJobs() {
        return jobs;
    }

    public void setJobs(List<Job> jobs) {
        this.jobs = jobs;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
