package com.flipkart.exceptions;

import org.apache.log4j.Logger;

/**
 * 
 * @author JEDI-05
 * Exception to check if course is available or not
 * 
 *
 */
public class CourseDoesNotExistException extends Exception{
	/**
	 * 
	 * @param message
	 */
	private static Logger logger = Logger.getLogger(CourseDoesNotExistException.class);

	public CourseDoesNotExistException(String message){
		super(message);
		logger.info("CourseDoesNotExistException()");
		
	}
}
