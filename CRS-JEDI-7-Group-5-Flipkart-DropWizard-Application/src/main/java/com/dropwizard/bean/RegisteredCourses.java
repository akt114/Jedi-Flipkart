package com.dropwizard.bean;

import java.util.List;

public class RegisteredCourses {

    private List<Course> primaryCourses;
    private List<Course> secondaryCourses;
    private List<Course> registeredCourses;

    public RegisteredCourses(List<Course> primaryCourses, List<Course> secondaryCourses, List<Course> registeredCourses) {
        this.primaryCourses = primaryCourses;
        this.secondaryCourses = secondaryCourses;
        this.registeredCourses = registeredCourses;
    }

    public RegisteredCourses(){}

    public List<Course> getPrimaryCourses() {
        return primaryCourses;
    }

    public void setPrimaryCourses(List<Course> primaryCourses) {
        this.primaryCourses = primaryCourses;
    }

    public List<Course> getSecondaryCourses() {
        return secondaryCourses;
    }

    public void setSecondaryCourses(List<Course> secondaryCourses) {
        this.secondaryCourses = secondaryCourses;
    }

    public List<Course> getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(List<Course> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }
}
