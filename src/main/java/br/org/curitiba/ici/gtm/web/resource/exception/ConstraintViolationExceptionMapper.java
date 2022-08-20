package br.org.curitiba.ici.gtm.web.resource.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import br.org.curitiba.ici.gtm.exceptions.ConstraintViolationException;

@Provider
public class ConstraintViolationExceptionMapper implements ExceptionMapper<ConstraintViolationException> {

	@Override
	public Response toResponse(ConstraintViolationException exception) {
		ErrorConstraint error = new ErrorConstraint("Constraint Violation", 400, exception.getField(), 
				exception.getMessage());
		return Response.status(Status.BAD_REQUEST).entity(error).build();
	}

}
