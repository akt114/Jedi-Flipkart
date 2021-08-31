package com.dropwizard.exceptions;

import org.apache.log4j.Logger;

/**
 * Exception to check precondition for registration
 * @author JEDI-05
 *
 */
public class PreConditionException extends Exception{
	/**
	 * 
	 * @param message
	 */
	private static Logger logger = Logger.getLogger(CourseAlreadyExistException.class);
	
	public PreConditionException(String message){
		super(message);
		logger.info("ReistrationRequirementNotMet()");
		
		
	}
}