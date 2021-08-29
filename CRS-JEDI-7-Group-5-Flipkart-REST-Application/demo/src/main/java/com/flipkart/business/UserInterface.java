package com.flipkart.business;


/*
* @author JEDI-05
* Interface for User Operations
*
* */
public interface UserInterface {

    /*
     *
     * Method to login
     * @param userName
     * @param password
     * @param role
     *
     * */
    boolean login(String userName, String password, String role);

}
