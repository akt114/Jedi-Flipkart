package com.flipkart.bean;

public class Registration {
    private String studentId;
    private boolean registrationStatus;

    public Registration(String studentId, boolean registrationStatus) {
        this.studentId = studentId;
        this.registrationStatus = registrationStatus;
    }

    public Registration(){}

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public boolean isRegistrationStatus() {
        return registrationStatus;
    }

    public void setRegistrationStatus(boolean registrationStatus) {
        this.registrationStatus = registrationStatus;
    }
}
