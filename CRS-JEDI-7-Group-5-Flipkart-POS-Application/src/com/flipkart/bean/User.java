package com.flipkart.bean;


/**
 * 
 * @author JEDI-05
 * User Bean Class
 * 
 */
public class User {
    private String name;
    private String email;
    private String id;
    private String password;

   /**
	 * 
	 * Method : User's Parameterized Constructor
	 * @param name
	 * @param email
	 * @param id
	 * @param password
	 * 
	 */
    public User(String name, String email, String id, String password) {
        this.name = name;
        this.email = email;
        this.id = id;
        this.password = password;
    }

    /**
	 * 
	 * Method : User's Default Constructor
	 * 
	 */
    public User(){}

    /**
	 * 
	 * Method to get Name
	 * 
	 */
    public String getName() {
        return name;
    }

    /**
	 * 
	 * Method to set Name
	 * @param name
	 * 
	 */
    public void setName(String name) {
        this.name = name;
    }

    /**
	 * 
	 * Method to get Email
	 * 
	 */
    public String getEmail() {
        return email;
    }

    /**
	 * 
	 * Method to set Email
	 * @param email
	 * 
	 */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
	 * 
	 * Method to get Id
	 * 
	 */
    public String getId() {
        return id;
    }

    /**
	 * 
	 * Method to set Id
	 * @param id
	 * 
	 */
    public void setId(String id) {
        this.id = id;
    }

    /**
	 * 
	 * Method to get Password
	 * 
	 */
    public String getPassword() {
        return password;
    }

    /**
	 * 
	 * Method to set Password
	 * @param password
	 * 
	 */
    public void setPassword(String password) {
        this.password = password;
    }
}
