package com.flipkart.bean;

import java.util.List;

public class Course {
    private String id;
    private String name;
    private String department;
    private int noOfStudents;
    private boolean isAvailable;
    private Professor instructor;
    private List<Student> studentsEnrolled;

    public Course(String id, String name, String department, int noOfStudents, boolean isAvailable, Professor instructor, List<Student> studentsEnrolled) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.noOfStudents = noOfStudents;
        this.isAvailable = isAvailable;
        this.instructor = instructor;
        this.studentsEnrolled = studentsEnrolled;
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

    public int getNoOfStudents() {
        return noOfStudents;
    }

    public void setNoOfStudents(int noOfStudents) {
        this.noOfStudents = noOfStudents;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public Professor getInstructor() {
        return instructor;
    }

    public void setInstructor(Professor instructor) {
        this.instructor = instructor;
    }

    public List<Student> getStudentsEnrolled() {
        return studentsEnrolled;
    }

    public void setStudentsEnrolled(List<Student> studentsEnrolled) {
        this.studentsEnrolled = studentsEnrolled;
    }
}
