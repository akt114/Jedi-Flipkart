package com.dropwizard.bean;

import java.util.ArrayList;
import java.util.List;

public class Course {
    private String id;
    private String name;
    private String department;
    

    public Course(String id, String name, String department, boolean isAvailable, Professor instructor, List<Student> studentsEnrolled) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Course(String id, String name, String department, boolean isAvailable, Professor instructor) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public Course(String id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    
    public Course(String id, String name) {
        this.id = id;
        this.name = name;
        this.department = null;
    }

    public Course() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
