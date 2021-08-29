package com.flipkart.bean;

/**
 * 
 * @author JEDI-05
 * Admin Bean Class
 * 
 */
public class Admin extends User{
	
	/**
	 * 
	 * Method : Admin's Parameterized Constructor
	 * @param name
	 * @param email
	 * @param id
	 * @param password 
	 * 
	 */

    public Admin(String name, String email, String id, String password) {
        super(name, email, id, password);
    }
    
    /**
	 * 
	 * Method : Admin's Default Constructor
	 * 
	 */
    
    public Admin() {
    }
}