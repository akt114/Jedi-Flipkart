package com.flipkart.exceptions;

import org.apache.log4j.Logger;

/**
 * 
 * @author JEDI-05
 * Exception to check whether student is already registered or not
 *
 */
public class StudentAlreadyRegisteredException extends Exception{
	
	/**
	 * 
	 * @param message
	 */
	private static final Logger logger =Logger.getLogger(StudentAlreadyRegisteredException.class);

	public StudentAlreadyRegisteredException(String message){
		super(message);
		logger.info("StudentAlreadyRegisteredException()");
	}
}
