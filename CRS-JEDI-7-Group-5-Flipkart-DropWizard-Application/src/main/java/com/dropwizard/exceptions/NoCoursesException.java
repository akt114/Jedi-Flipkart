package com.dropwizard.exceptions;

import org.apache.log4j.Logger;

/**
 * 
 * @author JEDI-05
 * Exception to check whether course is registered by student or not
 *
 */
public class NoCoursesException extends Exception {
	/**
	 * 
	 * @param str
	 */
	private static final Logger logger =Logger.getLogger(NoCoursesException.class);

	public NoCoursesException (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
        logger.info("NoCoursesException()");
    } 
}
