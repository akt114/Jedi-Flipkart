package com.flipkart.bean;

public class Student extends User {
    private String  branch;
    private int semester;
    private String department;
    private GradeCard gradeCard;

    public Student(String name, String email, String id, String password, String branch, int semester, String department, GradeCard gradeCard) {
        super(name, email, id, password);
        this.branch = branch;
        this.semester = semester;
        this.department = department;
        this.gradeCard = gradeCard;
    }

    public GradeCard getGradeCard() {
        return gradeCard;
    }

    public void setGradeCard(GradeCard gradeCard) {
        this.gradeCard = gradeCard;
    }


    public Student(){}

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
