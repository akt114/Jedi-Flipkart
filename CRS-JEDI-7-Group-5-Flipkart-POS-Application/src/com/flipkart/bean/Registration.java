package com.flipkart.bean;

/**
 * 
 * @author JEDI-05
 * Registration Bean Class
 * 
 */
public class Registration {
    private String studentId;
    private boolean registrationStatus;

    /**
	 * 
	 * Method : Registration's Parameterized Constructor
	 * @param studentId
	 * @param registrationStatus
	 * 
	 */
    public Registration(String studentId, boolean registrationStatus) {
        this.studentId = studentId;
        this.registrationStatus = registrationStatus;
    }

    /**
	 * 
	 * Method : Registration's's Default Constructor
	 * 
	 */
    public Registration(){}

    /**
	 * 
	 * Method to get StudentId
	 * 
	 */
    public String getStudentId() {
        return studentId;
    }

    /**
	 * 
	 * Method to set StudentId
	 * @param bankName
	 * 
	 */
    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    /**
	 * 
	 * Method to get Registration Status
	 * 
	 */
    public boolean isRegistrationStatus() {
        return registrationStatus;
    }

    /**
	 * 
	 * Method to set Registration Status
	 * @param registrationStatus
	 * 
	 */
    public void setRegistrationStatus(boolean registrationStatus) {
        this.registrationStatus = registrationStatus;
    }
}
