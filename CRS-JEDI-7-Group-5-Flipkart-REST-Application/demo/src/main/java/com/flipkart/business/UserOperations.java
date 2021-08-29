package com.flipkart.business;


import com.flipkart.utils.DBUtils;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
*@author JEDI-05
* Implementation of User Operations
*
* */
public class UserOperations implements UserInterface{

    private static Logger logger = Logger.getLogger(UserOperations.class);

    /*
    *
    *Method to login
    *@param userName
    *@param password
    *@param role
    *
    * */
    @Override
    public boolean login(String userName,String password, String role) {
        // TODO Auto-generated method stub
        //fetching the data and validating the user


        logger.info("login()");
        logger.debug(userName+" "+password+" "+role);

        String sql="select * from user where id=?";
        Connection conn = DBUtils.getConnection();
        PreparedStatement st,st1;
        try {
            st = conn.prepareStatement(sql);
            st.setString(1, userName);
            ResultSet rs = st.executeQuery();
            rs.next();
            String gotPassword = rs.getString("password");
            if(!gotPassword.equals(password))
                return false;
            if(role.equals("Student")){
                sql= "select * from student where id=?";
                st1 = conn.prepareStatement(sql);
                st1.setString(1, userName);
                ResultSet set = st1.executeQuery();
                if(set.next()){
                    return true;
                }
                return false;
            }
            else if(role.equals("Admin")){
                sql= "select * from admin where id=?";
                st1 = conn.prepareStatement(sql);
                st1.setString(1, userName);
                ResultSet set = st1.executeQuery();
                if(set.next()) return true;
                return false;
            }
            else{
                sql= "select * from professor where id=?";
                st1 = conn.prepareStatement(sql);
                st1.setString(1, userName);
                ResultSet set = st1.executeQuery();
                if(set.next()) return true;
                return false;
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public boolean approvalCheck(String userName) {
        String sql= "select * from student where id=?";
        Connection conn = DBUtils.getConnection();
        try{

            PreparedStatement st1 = conn.prepareStatement(sql);

            st1.setString(1, userName);
            ResultSet set = st1.executeQuery();
            if(set.next()){
                if(set.getString("isApproved").equals("true"))
                    return true;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }

}