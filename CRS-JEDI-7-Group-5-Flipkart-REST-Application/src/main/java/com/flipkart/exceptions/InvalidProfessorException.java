package com.flipkart.exceptions;

import org.apache.log4j.Logger;

/**
 * 
 * @author JEDI-05
 * Exception to check whether professor has sign up for course or not
 */
public class InvalidProfessorException extends Exception {
	/**
	 * 
	 * @param str
	 */
	private static final Logger logger =Logger.getLogger(InvalidProfessorException.class);

	public InvalidProfessorException (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str); 
        logger.info("InvalidProfessorException()");
        
    } 
}