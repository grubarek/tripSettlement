package pl.agh.id.tripsettlement.rest.provider;

import pl.agh.id.tripsettlement.rest.response.ResponseHelper;

import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionProvider implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(final Exception e) {
        if (e instanceof ConstraintViolationException) {
            return ResponseHelper.badRequest();
        }
        
        return ResponseHelper.internalServerError();
    }
}
