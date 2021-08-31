package com.flipkart.exceptions;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class GenericExceptionMapper implements ExceptionMapper<Exception>{
	@Override
	public Response toResponse(Exception ex)
	{
		System.out.println("GenericClass");
		if(ex instanceof CourseAlreadyExistException)
		{
		
			return Response.status(Status.BAD_REQUEST)
				       .entity(new ErrorProps("400", ex.getMessage()))
				       .build();
		}
		else if(ex instanceof CourseDoesNotExistException)
		{
		
			return Response.status(Status.BAD_REQUEST)
				       .entity(new ErrorProps("400", ex.getMessage()))
				       .build();
		}
		else if(ex instanceof PreConditionException)
		{
		
			return Response.status(Status.BAD_REQUEST)
				       .entity(new ErrorProps("400", ex.getMessage()))
				       .build();
		}
		else if(ex instanceof DuplicateCourseException)
		{
		
			return Response.status(Status.BAD_REQUEST)
				       .entity(new ErrorProps("400", ex.getMessage()))
				       .build();
		}
		else if(ex instanceof DuplicateProfessorException)
		{
		
			return Response.status(Status.BAD_REQUEST)
				       .entity(new ErrorProps("400", ex.getMessage()))
				       .build();
		}
		else if(ex instanceof ExcessStudentsException)
		{
		
			return Response.status(Status.BAD_REQUEST)
				       .entity(new ErrorProps("400", ex.getMessage()))
				       .build();
		}
		else if(ex instanceof GradeNotAddedException)
		{
		
			return Response.status(Status.BAD_REQUEST)
				       .entity(new ErrorProps("400", ex.getMessage()))
				       .build();
		}
		else if(ex instanceof InvalidCourseException)
		{
		
			return Response.status(Status.BAD_REQUEST)
				       .entity(new ErrorProps("400", ex.getMessage()))
				       .build();
		}
		else if(ex instanceof InvalidProfessorException)
		{
		
			return Response.status(Status.FORBIDDEN)
				       .entity(new ErrorProps("401", ex.getMessage()))
				       .build();
		}
		else if(ex instanceof InvalidStudentException)
		{
			return Response.status(Status.BAD_REQUEST)
				       .entity(new ErrorProps("400", ex.getMessage()))
				       .build();
		}
		else if(ex instanceof NoCoursesException)
		{
		
			return Response.status(Status.BAD_REQUEST)
				       .entity(new ErrorProps("400", ex.getMessage()))
				       .build();
		}
		else if(ex instanceof StudentAlreadyRegisteredException)
		{
		
			return Response.status(Status.BAD_REQUEST)
				       .entity(new ErrorProps("400", ex.getMessage()))
				       .build();
		}
		else
		{
			return Response.status(Status.INTERNAL_SERVER_ERROR)
					.entity(new ErrorProps("Something went wrong!", ex.getMessage()))
					.build();
		}
	}

}