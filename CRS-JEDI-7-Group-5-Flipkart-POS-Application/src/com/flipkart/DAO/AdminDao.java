package com.flipkart.DAO;

import com.flipkart.bean.Professor;
import com.flipkart.exceptions.*;
import com.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.*;
import java.util.Formatter;

/**
 * 
 * @author JEDI-05
 * Implementations of Admin DAO
 * 
 */
public class AdminDao {
	
	private static Logger logger = Logger.getLogger(AdminDao.class);
	
	/**
	 * Method to Add Course to Course Catalog
	 * @param courseId
	 * @param courseName
	 * @param department
	 * @throws SQLException, DuplicateCourseException
	 */


	public static void addCourse(String courseId,String courseName,String department) throws SQLException,DuplicateCourseException {
		Connection conn ;
		conn = DBUtils.getConnection();

		String sql="SELECT count(*) FROM course WHERE courseId="+"'"+courseId+"'";
		Statement count = conn.createStatement();

    	ResultSet rst=count.executeQuery(sql);
    	
    	if(rst.next()&&rst.getInt(1)!=0) {
    		throw new DuplicateCourseException(courseId+" Already exists");
    	}
    	
    	logger.info("addCourse()");
		sql="insert into course values(?,?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
    	
    	stmt.setString(1, courseId);  // This would set age
        stmt.setString(2,courseName);
        stmt.setString(3,department);
        stmt.executeUpdate();
	}
	
	/**
	 * Method to Delete Course from Course Catalog
	 * @param courseId
	 * @throws SQLException, InvalidCourseException
	 */
	
	public static void deleteCourse(String courseId) throws SQLException,InvalidCourseException {
		Connection conn ;
		conn = DBUtils.getConnection();

		String sql="SELECT COUNT(*) FROM course WHERE courseId="+"'"+courseId+"'";

		Statement count = conn.createStatement();
    	
    	ResultSet rst=count.executeQuery(sql);
    	
    	if(rst.next()&&rst.getInt(1)==0) {
    		throw new InvalidCourseException(courseId+" Does not exist");
    	}
    	
    	logger.info("deleteCourse()");
		sql="DELETE FROM course WHERE courseId = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
    	
    	stmt.setString(1, courseId);  // This would set age
        stmt.executeUpdate();
	}
	
	/**
	 * Method to Approve student registration
	 * @param studentId
	 * @throws SQLException, InvalidStudentException
	 */
	public static void approveStudent(String studentId) throws SQLException,InvalidStudentException {
		Connection conn ;
		conn = DBUtils.getConnection();

		String sql="SELECT COUNT(*) FROM student WHERE id="+"'"+studentId+"'";
		Statement count = conn.createStatement();

		ResultSet rst=count.executeQuery(sql);

		if(rst.next()&&rst.getInt(1)==0) {
			throw new InvalidStudentException(studentId+" Does not exist");
		}

    	logger.info("approveStudent()");
		logger.debug(studentId);
		sql="UPDATE student set isApproved='true' WHERE id=?";
		PreparedStatement stmt = conn.prepareStatement(sql);
    	stmt.setString(1, studentId);
		stmt.executeUpdate();
	}
	
	/**
	 * Method to Add professor
	 * @param professor
	 * @throws SQLException, DuplicateProfessorException
	 */

	public static void addProfessor(Professor professor) throws SQLException,DuplicateProfessorException {
		Connection conn ;
		conn = DBUtils.getConnection();

		String sql="SELECT COUNT(*) FROM professor WHERE id="+"'"+professor.getId()+"'";
		Statement count = conn.createStatement();
    	
    	ResultSet rst=count.executeQuery(sql);
    	
    	if(rst.next()&&rst.getInt(1)==1) {
    		throw new DuplicateProfessorException(professor.getId()+" Already exists");
    	}
    	
    	logger.info("addProfessor()");
		sql="insert into user values(?,?)";
		PreparedStatement stmt = conn.prepareStatement(sql);
    	
    	stmt.setString(1,professor.getId()+"123");  // This would set age
        stmt.setString(2,professor.getId());
        stmt.executeUpdate();
        
        sql="insert into professor values(?,?,?,?)";
        stmt = conn.prepareStatement(sql);
    	
    	stmt.setString(1,professor.getName());  // This would set age
        stmt.setString(2,professor.getId());
        stmt.setString(3,professor.getDesignation());
        stmt.setString(4,professor.getDepartment());
        stmt.executeUpdate();
	}
	
	/**
	 * Method to Get grades
	 * @param studentId
	 * @throws SQLException, NoCoursesException
	 */
	public static void getGrades(String studentId) throws SQLException, NoCoursesException {
		Connection conn ;
		conn = DBUtils.getConnection();

		String sql="SELECT COUNT(*) FROM studentcourse WHERE studentId="+"'"+studentId+"'";
		Statement count = conn.createStatement();
    	
    	ResultSet rst=count.executeQuery(sql);
    	
    	if(rst.next()&&rst.getInt(1)==0) {
    		throw new NoCoursesException(studentId+" Is not registered for any course");
    	}
    	
    	logger.info("getGrades()");
    	
        String query="SELECT courseId, grade FROM studentcourse WHERE studentId="+"'"+studentId+"'";
        Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(query);
             
            Formatter fmt = new Formatter();  
 	        System.out.println("*******************************************************************************************");
 	        
 	        fmt.format("%20s %23s\n", "Course Id", "Grade");
             while(rs.next()){
                fmt.format("%20s %22s\n", rs.getString("courseId"),rs.getInt("grade"));
             }
             System.out.println(fmt);
             System.out.println("*******************************************************************************************");
             rs.close();
	}
}
