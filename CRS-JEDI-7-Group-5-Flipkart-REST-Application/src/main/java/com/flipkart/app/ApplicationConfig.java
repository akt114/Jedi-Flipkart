package com.flipkart.app;

import com.flipkart.restController.AdminController;
import com.flipkart.restController.UserController;
import com.flipkart.restController.ProfessorController;
import com.flipkart.restController.StudentController;

import org.glassfish.jersey.server.ResourceConfig;

public class ApplicationConfig extends ResourceConfig {
    // Register controllers
    public ApplicationConfig() {
        register(AdminController.class);
    	register(ProfessorController.class);
    	register(StudentController.class);
    	register(UserController.class);

    }
}
