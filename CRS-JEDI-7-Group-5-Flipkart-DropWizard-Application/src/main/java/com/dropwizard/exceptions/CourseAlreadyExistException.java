package com.dropwizard.exceptions;

import org.apache.log4j.Logger;


/**
 * Exception to check if course is already exist
 * @author JEDI-05
 *
 */
public class CourseAlreadyExistException extends Exception{
	/**
	 * 
	 * @param message
	 */
	private static Logger logger = Logger.getLogger(CourseAlreadyExistException.class);
	
	public CourseAlreadyExistException(String message){
		super(message);
		logger.info("CourseAlreadyExistException()");
		
		
	}
}
