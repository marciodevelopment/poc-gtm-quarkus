package br.org.curitiba.ici.gtm.web.resource.exception;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class NotFoundExceptionExceptionMapper implements ExceptionMapper<NotFoundException> {

	@Override
	public Response toResponse(NotFoundException exception) {
		ErrorConstraint error = new ErrorConstraint("Constraint Violation", Status.NOT_FOUND.getStatusCode(), 
				"", 
				exception.getMessage());
		return Response.status(Status.NOT_FOUND).entity(error).build();
	}

}
