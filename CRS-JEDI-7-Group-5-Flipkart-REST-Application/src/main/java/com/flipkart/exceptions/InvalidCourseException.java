package com.flipkart.exceptions;

import org.apache.log4j.Logger;

/**
 * 
 * @author JEDi-05
 * Exception to check whether course is available or not
 *
 */
public class InvalidCourseException extends Exception {
	/**
	 * 
	 * @param str
	 */
	private static final Logger logger =Logger.getLogger(InvalidCourseException.class);
	public InvalidCourseException (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
        logger.info("InvalidCourseException()");
    } 
}
