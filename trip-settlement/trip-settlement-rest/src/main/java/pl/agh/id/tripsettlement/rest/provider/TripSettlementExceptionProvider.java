package pl.agh.id.tripsettlement.rest.provider;


import pl.agh.id.tripsettlement.exception.TripSettlementException;
import pl.agh.id.tripsettlement.rest.response.ResponseHelper;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import static javafx.scene.DepthTest.DISABLE;
import static javax.ws.rs.core.Response.Status.UNAUTHORIZED;
import static jdk.net.SocketFlow.Status.NO_PERMISSION;

@Provider
public class TripSettlementExceptionProvider implements ExceptionMapper<TripSettlementException> {

    @Override
    public Response toResponse(TripSettlementException e) {
        switch (e.getStatus()) {
            case VALIDATION_ERROR:
                if (e.getMessage() != null) {
                    return ResponseHelper.badRequest(e.getMessage());
                }
                return ResponseHelper.badRequest();
            case DISABLE:
                return ResponseHelper.notFound();
            case NO_RESULT:
                return ResponseHelper.notFound();
            case NO_PERMISSION:
                return ResponseHelper.forbidden();
            case UNAUTHORIZED:
                return ResponseHelper.unauthorized();
            default:
                return ResponseHelper.internalServerError();
        }
    }
}