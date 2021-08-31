package com.dropwizard.DAO;

import com.dropwizard.bean.Course;
import com.dropwizard.bean.Professor;
import com.dropwizard.exceptions.InvalidCourseException;
import com.dropwizard.exceptions.NoCoursesException;
import com.dropwizard.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Formatter;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;


/**
 * 
 * @author JEDI-05
 * Implementations of Professor DAO
 * 
 */
public class ProfessorDAO {
	
	private static Logger logger = Logger.getLogger(ProfessorDAO.class);
	
	
	/**
	 * Method to Enroll to teach a course
	 * @param courseId
	 * @param professor
	 * @throws SQLException, InvalidCourseException
	 */
	public static void enrollToCourse(String professorId, String courseId) throws SQLException, InvalidCourseException {
		Connection conn ;
		conn = DBUtils.getConnection();


		String sql="SELECT COUNT(*) FROM course WHERE courseId="+"'"+courseId+"'";
		
		Statement count = conn.createStatement();
    	
    	ResultSet rst=count.executeQuery(sql);
    	
    	if(rst.next()&&rst.getInt(1)==0) {
    		throw new InvalidCourseException(courseId+" Does not exist");
    	}
    	
    	logger.info("enrollToCourse()");
		sql="insert into professorcourse values(?,?)";
    	PreparedStatement stmt = conn.prepareStatement(sql);
    	
    	stmt.setString(1, professorId);
    	stmt.setString(2, courseId);
        stmt.executeUpdate();
	}
	
	/**
	 * Method to add grades for a student
	 * @param courseId
	 * @param professor
	 * @param studentId
	 * @throws SQLException, NoCoursesException
	 */
	public static void addGrades(String professorId, String studentId, String courseId, int grade) throws SQLException, NoCoursesException {
		Connection conn ;
		conn = DBUtils.getConnection();


		String sql="SELECT COUNT(*) FROM studentcourse WHERE studentId="+"'"+studentId+"'"+"AND courseId="+"'"+courseId+"'";
		Statement count = conn.createStatement();
    	
    	ResultSet rst=count.executeQuery(sql);
    	
    	if(rst.next()&&rst.getInt(1)==0) {
    		throw new NoCoursesException(studentId+" Is not registered for this course");
    	}
		
    	logger.info("addGrades()");
    	sql="UPDATE studentcourse set grade="+grade+ " WHERE studentId=? AND courseId=?";
    	PreparedStatement stmt = conn.prepareStatement(sql);
    	
    	stmt.setString(1, studentId);
    	stmt.setString(2, courseId);
        stmt.executeUpdate();
	}
	
	/**
	 * Method to view all courses
	 * @throws SQLException
	 */
	
	public static List<Course> viewCourses() throws SQLException {

		Connection conn ;
		conn = DBUtils.getConnection();

		logger.info("viewCourses()");
		Statement stmt = conn.createStatement();
    	
        String query="SELECT courseId, name, department FROM course";
        
        Formatter fmt = new Formatter();  
        System.out.println("*******************************************************************************************");
        fmt.format("%20s %20s %25s\n", "Course Id", "Name", "Department");  
        
             ResultSet rs = stmt.executeQuery(query);
             List<Course> courses=new LinkedList<Course>();
             while(rs.next()){
                //Display values
            	 Course course=new Course(rs.getString("courseId"),rs.getString("name"), rs.getString("department"));
            	 courses.add(course);
                fmt.format("%15s %25s %25s\n", rs.getString("courseId"),rs.getString("name"), rs.getString("department"));  
             }
             System.out.println(fmt);
             System.out.println("*******************************************************************************************");
             rs.close();
             return courses;
	}
	
	
	/**
	 * Method to view enrolled students in a course
	 * @param courseId
	 * @throws SQLException, InvalidCourseException 
	 */
	 public static HashMap<String,String> viewEnrolledStudents(String courseId) throws SQLException, InvalidCourseException {
		 Connection conn ;
		 conn = DBUtils.getConnection();

	 	Statement stmt = conn.createStatement();
		 String sql="SELECT COUNT(*) FROM course WHERE courseId="+"'"+courseId+"'";
			
			Statement count = conn.createStatement();
	    	
	    	ResultSet rst=count.executeQuery(sql);
	    	
	    	if(rst.next()&&rst.getInt(1)==0) {
	    		throw new InvalidCourseException(courseId+" Does not exist");
	    	}
	    	
	    	logger.info("viewEnrolledStudents()");
	        String query="SELECT studentId, name FROM studentcourse INNER JOIN student on studentcourse.studentId=student.id WHERE courseId="+"'"+courseId+"'";
	        Formatter fmt = new Formatter();  
	        System.out.println("*******************************************************************************************");
	        
	        fmt.format("%20s %20s\n", "Student Id", "Student Name");
	        	
	             ResultSet rs = stmt.executeQuery(query);
	             HashMap<String,String> map=new HashMap<String,String>();
	             while(rs.next()) {
	            	 map.put(rs.getString("studentId"),rs.getString("name"));
	                fmt.format("%15s %20s\n", rs.getString("studentId"),rs.getString("name"));
	             }
	             
	             System.out.println(fmt);
	             System.out.println("*******************************************************************************************");
	             rs.close();
	             return map;
	 }
	 
	 
	 /**
		 * Method to view enrolled courses teaching
		 * @param professor
		 * @throws SQLException 
		 */
	 public static List<Course> viewEnrolledCourses(String professorId) throws SQLException {
		 Connection conn ;
		 conn = DBUtils.getConnection();
		 
		 logger.info("viewEnrolledCourses()");
		 Statement stmt = conn.createStatement();
	    	
	        String query="SELECT course.courseId, name FROM professorcourse INNER JOIN course on professorcourse.courseId=course.courseId WHERE professorId="+"'"+professorId+"'";
	        
	             ResultSet rs = stmt.executeQuery(query);
	             Formatter fmt = new Formatter();  
	 	        System.out.println("*******************************************************************************************");
	 	       fmt.format("%20s %20s\n", "Course Id", "Course Name");
	 	      List<Course> courses=new LinkedList<Course>();
	             while(rs.next()){
	                //Display values
	            	 Course course=new Course(rs.getString("courseId"),rs.getString("name"));
	            	 courses.add(course);
	                fmt.format("%15s %23s\n", rs.getString("courseId"),rs.getString("name"));
	             }
	             
	             System.out.println(fmt);
	             System.out.println("*******************************************************************************************");
	             rs.close();
	             
	             return courses;
	 }
	 
	 /**
		 * Method to get professor
		 * @param userId
		 */
	 public static Professor getProfessor(String userId){
		 Connection conn ;
		 conn = DBUtils.getConnection();

		 logger.info("getProfessor()");
			String sql = "select * from professor where id=?";
			Professor professor = null;
			try {
				PreparedStatement st = conn.prepareStatement(sql);
				st.setString(1, userId);
				ResultSet rs = st.executeQuery();
				rs.next();
				professor = new Professor();
				professor.setName(rs.getString("name"));
				professor.setId(userId);
				professor.setDesignation(rs.getString("designation"));
				professor.setDepartment(rs.getString("department"));
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
			return professor;
		 }
	 
}
