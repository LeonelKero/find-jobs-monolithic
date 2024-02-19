package com.wbt.findjobs.review;

import com.wbt.findjobs.company.Company;

public record ReviewRequest(String title, String content, Double rating, Company company) {
}
