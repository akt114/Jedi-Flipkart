package com.flipkart.bean;

import java.util.Set;

public class CourseCatalog {

    private Set<Course> availableCourses;

    public CourseCatalog(Set<Course> availableCourses) {
        this.availableCourses = availableCourses;
    }

    public CourseCatalog() {
    }

    public Set<Course> getAvailableCourses() {
        return availableCourses;
    }

    public void setAvailableCourses(Set<Course> availableCourses) {
        this.availableCourses = availableCourses;
    }
}
