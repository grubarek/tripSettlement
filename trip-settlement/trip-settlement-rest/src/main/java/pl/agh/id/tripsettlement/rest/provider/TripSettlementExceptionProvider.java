package pl.agh.id.tripsettlement.rest.provider;


import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider
public class TripSettlementExceptionProvider implements ExceptionMapper<Exception> {

    @Override
    public Response toResponse(final Exception e) {
//        switch (e.getStatus()) {
//            case VALIDATION_ERROR:
//                if (e.getMessage() != null) {
//                    return ResponseHelper.badRequest(e.getMessage());
//                }
//                return ResponseHelper.badRequest();
//            case DISABLED:
//                return ResponseHelper.notFound();
//            case NO_RESULT:
//                return ResponseHelper.notFound();
//            case NO_PERMISSION:
//                return ResponseHelper.forbidden();
//            case UNAUTHORIZED:
//                return ResponseHelper.unauthorized();
//            default:
//                return ResponseHelper.internalServerError();
//        }
        return null;
    }
}