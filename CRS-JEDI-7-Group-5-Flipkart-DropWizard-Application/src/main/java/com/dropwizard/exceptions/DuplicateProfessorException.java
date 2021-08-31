package com.dropwizard.exceptions;

import org.apache.log4j.Logger;

/**
 * 
 * @author JEI-05
 * Exception to check whether Professor already exist or not
 *
 */
public class DuplicateProfessorException extends Exception {
	/**
	 * 
	 * @param str
	 */
	private static Logger logger = Logger.getLogger(DuplicateProfessorException.class);

	public DuplicateProfessorException (String str)  
    {  
        // calling the constructor of parent Exception  
        super(str);  
        logger.info("DuplicateProfessorException()");
    } 
}
