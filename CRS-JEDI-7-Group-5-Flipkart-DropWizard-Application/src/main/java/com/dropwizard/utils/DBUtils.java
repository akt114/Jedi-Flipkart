package com.dropwizard.utils;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
	
	private static Connection connection = null;
	
	public static Connection getConnection() {
		
        if (connection != null)
            return connection;
        else {
            try {
            	/*Properties prop = new Properties();
                InputStream inputStream = DBUtils.class.getClassLoader().getResourceAsStream("./config.properties");
                prop.load(inputStream);
                */
                String driver = "com.mysql.jdbc.Driver";
                String url = "jdbc:mysql://localhost:3306/test?autoReconnect=true&useSSL=false";
                String user = "root";
                String password = "Vineet@123";
                
                Class.forName(driver);
                connection = DriverManager.getConnection(url, user, password);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            } 
            return connection;
        }
    }
}
