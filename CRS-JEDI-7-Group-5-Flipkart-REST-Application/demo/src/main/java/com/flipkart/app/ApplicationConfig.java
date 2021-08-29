package com.flipkart.app;

import com.flipkart.restController.AdminController;
import com.flipkart.restController.LoginController;
import com.flipkart.restController.ProfessorController;
import com.flipkart.restController.StudentController;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {
    // Register controllers
    public ApplicationConfig() {

//        register(StudentRestAPI.class);
//        register(UserRestAPI.class);
//        register(ProfessorRestAPI.class);
//        register(AdminRestAPI.class);
    	
        register(AdminController.class);
    	register(ProfessorController.class);
    	register(StudentController.class);
    	register(LoginController.class);

    }
}
