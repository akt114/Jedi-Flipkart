package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {
    private String  branch;
    private int semester;
    private String department;
    private GradeCard gradeCard;
    private boolean registrationStatus = false;
    private List<String> registeredCourses = new ArrayList<>();
    private BillPay billPay = new BillPay();
    private boolean registered = false;

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public Student(String name, String email, String id, String password, String branch, int semester, String department, GradeCard gradeCard) {
        super(name, email, id, password);
        this.branch = branch;
        this.semester = semester;
        this.department = department;
        this.gradeCard = gradeCard;
    }
    
    public Student(String name, String email, String id, String password, String branch, int semester, String department) {
        super(name, email, id, password);
        this.branch = branch;
        this.semester = semester;
        this.department = department;
        this.gradeCard = new GradeCard();
    }

    public BillPay getBillPay() {
        return billPay;
    }

    public void setBillPay(BillPay billPay) {
        this.billPay = billPay;
    }

    public Student(){}

    public boolean isRegistrationStatus() {
        return registrationStatus;
    }

    public List<String > getRegisteredCourses() {
        return registeredCourses;
    }

    public void setRegisteredCourses(List<String> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    public void setRegistrationStatus(boolean registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    public GradeCard getGradeCard() {
        return gradeCard;
    }

    public void setGradeCard(GradeCard gradeCard) {
        this.gradeCard = gradeCard;
    }


    public String  getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getSemester() {
        return semester;
    }

    public void setSemester(int semester) {
        this.semester = semester;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


}
