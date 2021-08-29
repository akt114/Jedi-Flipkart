package com.flipkart.exceptions;

import org.apache.log4j.Logger;

/**
 * 
 * @author JEDI-03
 * Exception to check whether grade added or not in database
 *
 */
public class GradeNotAddedException extends Exception{
	/** 
	 * 
	 * @param message
	 */
	private static final Logger logger =Logger.getLogger(GradeNotAddedException.class); 
	public GradeNotAddedException(String message){
		super(message);
		logger.info("GradeNotAddedException()");
	}
}
