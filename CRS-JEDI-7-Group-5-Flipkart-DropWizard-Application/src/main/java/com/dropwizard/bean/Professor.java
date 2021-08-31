package com.dropwizard.bean;

import java.util.ArrayList;
import java.util.List;

public class Professor extends User{
    private String department;
    private String designation;
    private List<Course> coursesTeaching;

    public Professor(String name, String email, String id, String password, String department, String designation, List<Course> coursesTeaching) {
        super(name, email, id, password);
        this.department = department;
        this.designation = designation;
        this.coursesTeaching = coursesTeaching;
    }

    public Professor(String department, String designation, List<Course> coursesTeaching) {
        this.department = department;
        this.designation = designation;
        this.coursesTeaching = coursesTeaching;
    }

    public Professor() {
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public List<Course> getCoursesTeaching() {
        return coursesTeaching;
    }

    public void setCoursesTeaching(List<Course> coursesTeaching) {
        this.coursesTeaching = coursesTeaching;
    }
}
