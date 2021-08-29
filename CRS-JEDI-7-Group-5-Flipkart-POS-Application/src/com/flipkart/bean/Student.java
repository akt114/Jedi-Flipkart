package com.flipkart.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author JEDI-05
 * Student Bean Class
 * 
 */
public class Student extends User {
    private String  branch;
    private int semester;
    private String department;
    private GradeCard gradeCard;
    private boolean registrationStatus = false;
    private List<String> registeredCourses = new ArrayList<>();
    private BillPay billPay = new BillPay();
    private boolean registered = false;


    /**
	 * 
	 * Method : Student's Parameterized Constructor
	 * @param bankName
	 * @param branchName
	 * 
	 */
    public Student(String name, String email, String id, String password, String branch, int semester, String department, GradeCard gradeCard) {
        super(name, email, id, password);
        this.branch = branch;
        this.semester = semester;
        this.department = department;
        this.gradeCard = gradeCard;
    }

    /**
	 * 
	 * Method : Student's Default Constructor
	 * 
	 */
    public Student(){}
    
    /**
	 * 
	 * Method to get Registered status
	 * 
	 */
    public boolean isRegistered() {
        return registered;
    }

    /**
	 * 
	 * Method to set Registered status
	 * @param registered
	 * 
	 */
    public void setRegistered(boolean registered) {
        this.registered = registered;
    }
    
    /**
	 * 
	 * Method to get BillPay object
	 * 
	 */
    public BillPay getBillPay() {
        return billPay;
    }

    /**
	 * 
	 * Method to set BillPay object
	 * @param billPay
	 * 
	 */
    public void setBillPay(BillPay billPay) {
        this.billPay = billPay;
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
	 * Method to get RegisteredCourses
	 * 
	 */
    public List<String > getRegisteredCourses() {
        return registeredCourses;
    }

    /**
	 * 
	 * Method to set RegisteredCourses
	 * @param registeredCourses
	 * 
	 */
    public void setRegisteredCourses(List<String> registeredCourses) {
        this.registeredCourses = registeredCourses;
    }

    /**
	 * 
	 * Method to set RegistrationStatus
	 * @param registrationStatus
	 * 
	 */
    public void setRegistrationStatus(boolean registrationStatus) {
        this.registrationStatus = registrationStatus;
    }

    /**
	 * 
	 * Method to get GradeCard
	 * 
	 */
    public GradeCard getGradeCard() {
        return gradeCard;
    }

    /**
	 * 
	 * Method to set GradeCard
	 * @param gradeCard
	 * 
	 */
    public void setGradeCard(GradeCard gradeCard) {
        this.gradeCard = gradeCard;
    }


    /**
	 * 
	 * Method to get Branch Name
	 * 
	 */
    public String  getBranch() {
        return branch;
    }

    /**
	 * 
	 * Method to set Branch Name
	 * @param branch
	 * 
	 */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
	 * 
	 * Method to get Semester
	 * 
	 */
    public int getSemester() {
        return semester;
    }

    /**
	 * 
	 * Method to set Semester
	 * @param semester
	 * 
	 */
    public void setSemester(int semester) {
        this.semester = semester;
    }

    /**
	 * 
	 * Method to get Department Name
	 * 
	 */
    public String getDepartment() {
        return department;
    }

    /**
	 * 
	 * Method to set Department Name
	 * @param department
	 * 
	 */
    public void setDepartment(String department) {
        this.department = department;
    }


}


