package com.flipkart.application;

import com.flipkart.DAO.StudentDAOOperations;
import com.flipkart.bean.CourseCatalog;
import com.flipkart.bean.Student;
import com.flipkart.business.StudentOperation;
import com.flipkart.exceptions.*;
import org.apache.log4j.Logger;

import java.sql.SQLException;
import java.util.Scanner;
/**
 * 
 * @author JEDI-05
 * This class will show the Student Menu in console
 *
 */
public class StudentMenu {
	private static Logger logger = Logger.getLogger(StudentMenu.class);
    Scanner scanner = new Scanner(System.in);
    StudentOperation studentOperation = new StudentOperation();
    StudentDAOOperations daoOperation = new StudentDAOOperations();
    /**
     * Method to show the menu
     * @param student
     * @param courseCatalog
     */
    public void menu(Student student, CourseCatalog courseCatalog){
    	logger.info("menu()");
        while(true){
            System.out.println("press 1 : registerForSemester");
            System.out.println("press 2 : payFee");
            System.out.println("press 3 : viewCourses");
            System.out.println("press 4 : viewGradeCard");
            System.out.println("press 5 : addCourse");
            System.out.println("press 6 : dropCourse");
            System.out.println("press 7 : viewEnrolledCourses");
            System.out.println("press 8 : Logout");
            int v = scanner.nextInt();
            if(v == 1){
            	try{
                studentOperation.registerForSemester(student);
            	}
            	catch(StudentAlreadyRegisteredException e){
            		System.out.println(e.getMessage());
            	}
            }else if(v == 2){
            	String status = "false";
				try {
					status = daoOperation.getBillStatus(student);
                } catch (SQLException e) {
					// TODO Auto-generated catch block
//					e.printStackTrace();

                }

                if(!student.isRegistrationStatus()){
                    System.out.println("You are not registered for this semester");
                } else if(status.equals("true")){
                    System.out.println("You have completed payment for this semester.");
                } else if(!studentOperation.preConditionCheck(student)){
                    System.out.println("Taken courses are not valid.");
                } else{
                    System.out.println("You have to pay Rs. 5000.");
                    System.out.println("Enter payment id : ");
                    String  id = scanner.next();
                    studentOperation.payFee(student, id);
                }
            }else if(v == 3){
                studentOperation.viewCourses();
            }else if(v == 4){
            	try{
                studentOperation.viewGradeCard(student);
            	} catch (GradeNotAddedException e){
            		System.out.println(e.getMessage());
            	}
            }else if(v == 5){
                if(!student.isRegistrationStatus()){
                    System.out.println("You are not registered for this semester");
                }else{
                    System.out.println("Enter Course Id : ");
                    String courseId = scanner.next();
                    try{
                    studentOperation.addCourse(student, courseId);
                    } catch(CourseAlreadyExistException | ExcessStudentsException e){
                    	System.out.println(e.getMessage());
                    }
                }
            }else if(v == 6){
                if(!student.isRegistrationStatus()){
                    System.out.println("You are not registered for this semester");
                }else{
                    System.out.println("Enter Course Id : ");
                    String courseId = scanner.next();
                    try{
                    studentOperation.dropCourse(student, courseId);
                    } catch (CourseDoesNotExistException e){
                    	System.out.println(e.getMessage());
                    }
                }
            }else if(v == 7){
            	if(!student.isRegistrationStatus()){
                    System.out.println("You are not registered for this semester");
                }else {
                	studentOperation.viewEnrolledCourses(student);
                }
            }else {
                return;
            }
        }

    }


}
