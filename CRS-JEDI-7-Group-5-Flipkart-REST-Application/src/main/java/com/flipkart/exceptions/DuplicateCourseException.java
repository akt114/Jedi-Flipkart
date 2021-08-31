package com.flipkart.exceptions;

import org.apache.log4j.Logger;

/**
 * 
 * @author JEDI-05
 * Exception to check whether course already exist or not
 *
 */
public class DuplicateCourseException extends RuntimeException {
		/**
		 * 
		 * @param message
		 */
	private static Logger logger = Logger.getLogger(DuplicateCourseException.class);

		public DuplicateCourseException (String message)  
	    {  
	        // calling the constructor of parent Exception  
	        super(message);  
	        logger.info("DuplicateCourseException()");
	    } 
}
