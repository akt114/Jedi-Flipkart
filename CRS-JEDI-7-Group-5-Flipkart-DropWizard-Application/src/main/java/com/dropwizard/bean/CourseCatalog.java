package com.dropwizard.bean;

import java.util.HashMap;

public class CourseCatalog {

    private HashMap<String,Course> availableCourses;

    public CourseCatalog( HashMap<String,Course> courses) {
        this.availableCourses = courses;
    }

    public CourseCatalog() {

    }


    public HashMap<String,Course> getAvailableCourses() {
        return availableCourses;
    }

    public void setAvailableCourses( HashMap<String,Course> availableCourses) {
        this.availableCourses = availableCourses;
    }
}