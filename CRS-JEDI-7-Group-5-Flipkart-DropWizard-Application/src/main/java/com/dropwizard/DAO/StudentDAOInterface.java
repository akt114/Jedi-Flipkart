package com.dropwizard.DAO;

import java.sql.SQLException;

import com.dropwizard.bean.Student;

/**
 * 
 * @author JEDI-05
 * Implementations of Student DAO interface
 * 
 */
public interface StudentDAOInterface {
	
	/**
	 * Method to get billing status
	 * @param student
	 * @throws SQLException
	 */
	public String getBillStatus(String studentId) throws SQLException;
	
	/**
	 * Method to set billing status
	 * @param student
	 * @param paymentId
	 * @throws SQLException
	 */
	public void setBillStatus(String studentId, String paymentId) throws SQLException;
	
	/**
	 * Method to get student
	 * @param userId
	 */
	public Student getStudent(String userId);
}
