package com.flipkart.DAO;

import com.flipkart.bean.Student;
import com.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.Formatter;
import java.util.HashMap;
import java.util.List;


/**
 * 
 * @author JEDI-05
 * Implementations of Student DAO operations
 * 
 */
public class StudentDAOOperations implements StudentDAOInterface{
	
	Connection conn ;
	private static Logger logger = Logger.getLogger(StudentDAOOperations.class);
	public StudentDAOOperations() {
		// TODO Auto-generated constructor stub
		conn = DBUtils.getConnection();
	}
	
	/**
	 * Method to get billing status
	 * @param student
	 * @throws SQLException
	 */
	@Override
	public String getBillStatus(Student student) throws SQLException{
		logger.info("getBillStatus()");
		String sql="select status from billpay where studentId=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, student.getId());
		ResultSet rs = st.executeQuery();
		rs.next();
		return rs.getString("status");
	}
	
	/**
	 * Method to set billing status
	 * @param student
	 * @param paymentId
	 * @throws SQLException
	 */

	@Override
	public void setBillStatus(Student student, String paymentId) throws SQLException{
		logger.info("setBillStatus()");
		String sql = "update billpay set status=?,billId=?,amount=? where studentId=?";
		PreparedStatement st = conn.prepareStatement(sql);
		st.setString(1, "true");
		st.setString(2, paymentId);
		String id=student.getId();
		st.setInt(3, 5000);
		st.setString(4, id);
		st.executeUpdate();
	}
	
	/**
	 * Method to get student
	 * @param userId
	 * @throws SQLException
	 */
	@Override
	public Student getStudent(String userId){
		logger.info("getStudent()");
		String sql = "select * from student where id=?";
		Student student = null;
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, userId);
			ResultSet rs = st.executeQuery();
			rs.next();
			student = new Student();
			student.setName(rs.getString("name"));
			student.setId(userId);
			student.setSemester(rs.getInt("semester"));
			student.setDepartment(rs.getString("department"));
			student.setBranch(rs.getString("branch"));
			student.setRegistrationStatus(rs.getBoolean("registrationStatus"));
			student.setRegisteredCourses(getEnrolledCourses(student));
			//add listOfCourses, billPay etc
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return student;
	}
	
	/**
	 * Method to set registration status
	 * @param student
	 * @throws SQLException
	 */
	public void setRegistrationStatus(Student student){
		logger.info("setRegistrationStatus()");
		String sql = "update student set registrationStatus=? where id=?";
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, "true");
			String id=student.getId();
			st.setString(2, id);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Method to add course
	 * @param student
	 * @param courseId
	 * @throws SQLException
	 */
	public void addCourse(Student student,String courseId){
		logger.info("addCourse()");
		String sql = "insert into studentcourse values(?,?,?)";
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			String id=student.getId();
			st.setString(1, id);
			st.setString(2, courseId);
			st.setInt(3, 0);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Method to drop course
	 * @param student
	 * @param courseId
	 * @throws SQLException
	 */
	public void dropCourse(Student student,String courseId){
		logger.info("dropCourse()");
		String sql = "DELETE FROM studentcourse where studentId=? and courseId=?";
		PreparedStatement st;
		try {
			st = conn.prepareStatement(sql);
			String id=student.getId();
			st.setString(1, id);
			st.setString(2, courseId);
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Method to view enrolled courses
	 * @param student
	 * @throws SQLException
	 */
	public List<String> getEnrolledCourses(Student student){
		logger.info("getEnrolledCourses()");
		List<String> enrolledCourses = new ArrayList<String>();
		String sql = "select * from studentcourse where studentId=?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, student.getId());
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				enrolledCourses.add(rs.getString("courseId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enrolledCourses;
	}
	
	/**
	 * Method to view grades
	 * @param student
	 * @throws SQLException
	 */
	public HashMap<String, Integer> getGrades(Student student){
		logger.info("getGrades()");
		HashMap<String, Integer> enrolledCoursesAndGrades = new HashMap<String, Integer>();
		String sql = "select * from studentcourse where studentId=?";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, student.getId());
			ResultSet rs = st.executeQuery();
			while(rs.next()){
				enrolledCoursesAndGrades.put(rs.getString("courseId"),rs.getInt("grade"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return enrolledCoursesAndGrades;
	}
	
	
	/**
	 * Method to view all courses
	 * @throws SQLException
	 */
	public void getAllCourses(){
		logger.info("getAllCourses()");
		String sql = "select * from course";
		try {
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();
			Formatter fmt = new Formatter();
			System.out.println("*******************************************************************************************");
			fmt.format("%15s %23s\n", "Course Id", "Course Name");
			while(rs.next()){
				//Display values
				fmt.format("%15s %20s\n", rs.getString("courseId"),rs.getString("name"));
			}

			System.out.println(fmt);
			System.out.println("*******************************************************************************************");
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Method to view all enrolled courses
	 * @param student
	 */
	public void getAllEnrolledCourses(Student student) throws SQLException{
		logger.info("getAllEnrolledCourses()");
		Statement stmt = conn.createStatement();
    	
        String query="SELECT course.courseId, name FROM studentcourse INNER JOIN course on studentcourse.courseId=course.courseId WHERE studentId="+"'"+student.getId()+"'";

		ResultSet rs = stmt.executeQuery(query);
		Formatter fmt = new Formatter();
		System.out.println("*******************************************************************************************");
		fmt.format("%20s %20s\n", "Course Id", "Course Name");
		while(rs.next()){
			//Display values
			fmt.format("%20s %23s\n", rs.getString("courseId"),rs.getString("name"));
		}

		System.out.println(fmt);
		System.out.println("*******************************************************************************************");
		rs.close();
 
	}
	
	/**
	 * Method to view number of students enrolled in a course
	 * @param courseId
	 * @throws SQLException
	 */
	public int noOfStudentsEnrolled(String courseId) {
		logger.info("noOfStudentsEnrolled()");
		String sql = "select Count(*) as number from studentcourse group by courseId having courseId=?";
		PreparedStatement stmt;
		int numberOfStudents = 0;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, courseId);
			ResultSet rs = stmt.executeQuery();
			rs.next();
			numberOfStudents = rs.getInt("number");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return numberOfStudents;
	}
	
	
	/**
	 * Method to signup by a student
	 * @param student
	 * @throws SQLException
	 */
	public void signUp(Student student){
		logger.info("signUp()");
		String sql="insert into user values(?,?)";
    	PreparedStatement stmt;
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1,student.getPassword()); 
	        stmt.setString(2,student.getId());
	        stmt.executeUpdate();
	        
	        sql="insert into student values(?,?,?,?,?,?,?)";
	        stmt = conn.prepareStatement(sql);
	        
	        stmt.setString(1,student.getId());
	    	stmt.setString(2,student.getName());
	        stmt.setInt(3,student.getSemester());
	        stmt.setString(4,student.getDepartment());
	        stmt.setString(5,student.getBranch());
	        stmt.setString(6,"false");
	        stmt.setString(7,"false");
	        stmt.executeUpdate();
			System.out.println("You have successfully signed up!!!");
			System.out.println();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
			System.out.println(e.getMessage());
			System.out.println();
		}
    	
    	
	}
}
