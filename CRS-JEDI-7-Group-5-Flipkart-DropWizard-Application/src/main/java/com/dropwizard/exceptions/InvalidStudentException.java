package com.dropwizard.exceptions;

import org.apache.log4j.Logger;

/**
 * 
 * @author JEDI-05
 * Exception to check whether student has registered for course or not
 */

public class InvalidStudentException extends Exception {
	/**
	 * 
	 * @param str
	 */
	private static final Logger logger =Logger.getLogger(InvalidStudentException.class);

	public InvalidStudentException (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
        logger.info("InvalidStudentException()");
    } 
}
