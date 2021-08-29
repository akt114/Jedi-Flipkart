package com.flipkart.application;

import com.flipkart.bean.*;

import java.sql.Connection;
import java.sql.DriverManager;

import java.util.HashMap;

import org.apache.log4j.Logger;
/**
 * 
 * @author JEDI-05
 * This class will connection the application to Database.
 * 
 */
public class Database {
    public static CourseCatalog courseCatalog;
    public static HashMap<String,Student> students;
    public static HashMap<String,Professor> professors;
    public static HashMap<String, Admin> admins;
    private static Logger logger = Logger.getLogger(Database.class);
    
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    
    //  Database credentials
    static final String DB_URL = "jdbc:mysql://localhost/test";
    static final String USER = "root";
    static final String PASS = "root";
    
    public static Connection conn=null;

    /**
     * Method to connect to Database
     * 
     */
    public static void createDatabase() {
    	logger.info("createDatabase()");
    	try {
    		 Class.forName("com.mysql.jdbc.Driver");

             // Step 4 make/open  a connection

             System.out.println("Connecting to database...");
             conn = DriverManager.getConnection(DB_URL,USER,PASS);
    	}
    	catch(Exception e){
    		System.out.println(e.getMessage());
    	}

    }
}
