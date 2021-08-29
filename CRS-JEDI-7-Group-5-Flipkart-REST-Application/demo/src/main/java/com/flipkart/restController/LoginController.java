package com.flipkart.restController;


import com.flipkart.bean.Login;
import com.flipkart.bean.Student;
import com.flipkart.business.StudentOperation;
import com.flipkart.business.UserOperations;
import org.apache.log4j.Logger;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/home")
public class LoginController {

    private static Logger logger = Logger.getLogger(LoginController.class);

    @POST
    @Path("/login")
    @Consumes(MediaType.APPLICATION_JSON)
    public String loginUser(Login userInfo){

        logger.info("loginUser()");
        String userId = userInfo.getUserId();
        String password = userInfo.getPass();
        String role = userInfo.getRole();

        boolean isValidUser = new UserOperations().login(userId,password, role);
        if(isValidUser){
            if(role.equals("Student")){
                if(new UserOperations().approvalCheck(userId)){
                    return "Student logged in successfully!!";
                }else{
                    return "Student is not approved by Admin";
                }
            }
            else if(role.equals("Admin")) {
                return "Admin logged in successfully!!";
            }
            else {
                return "Professor logged in successfully!!";
            }
        }
        else {
            logger.debug("Incorrect details");
            return "Incorrect Details\n" + "Please Try again\n";
        }
    }

    @POST
    @Path("/studentSignUp")
    @Consumes(MediaType.APPLICATION_JSON)
    public String registerStudent(Student student) {
        logger.info("registerStudent()");
        StudentOperation operation = new StudentOperation();
        operation.signUp(student);
        return "SignUp Successful";
    }

}
