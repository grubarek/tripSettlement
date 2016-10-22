package pl.agh.id.tripsettlement.rest.response;

import javax.ws.rs.core.Response;

public class ResponseHelper {

    public static Response ok() {
        return Response.status(Response.Status.OK).build();
    }

    public static Response ok(Object o) {
        return Response.status(Response.Status.OK).entity(o).build();
    }

    public static Response ok(String message) {
        MessageApplicationResponse messageApplicationResponse = new MessageApplicationResponse();
        messageApplicationResponse.setMessage(message);
        return Response.status(Response.Status.OK).entity(messageApplicationResponse).build();
    }

    public static Response created(Object o) {
        return Response.status(Response.Status.OK).entity(o).build();
    }

    public static Response created(String message) {
        MessageApplicationResponse messageApplicationResponse = new MessageApplicationResponse();
        messageApplicationResponse.setMessage(message);
        return Response.status(Response.Status.OK).entity(messageApplicationResponse).build();
    }

    public static Response badRequest(String message) {
        MessageApplicationResponse messageApplicationResponse = new MessageApplicationResponse();
        messageApplicationResponse.setMessage(message);
        return Response.status(Response.Status.BAD_REQUEST).entity(messageApplicationResponse).build();
    }

    public static Response badRequest() {
        return Response.status(Response.Status.BAD_REQUEST).build();
    }

    public static Response unauthorized(String message) {
        MessageApplicationResponse messageApplicationResponse = new MessageApplicationResponse();
        messageApplicationResponse.setMessage(message);
        return Response.status(Response.Status.UNAUTHORIZED).entity(messageApplicationResponse).build();
    }

    public static Response unauthorized() {
        return Response.status(Response.Status.UNAUTHORIZED).build();
    }

    public static Response forbidden(String message) {
        MessageApplicationResponse messageApplicationResponse = new MessageApplicationResponse();
        messageApplicationResponse.setMessage(message);
        return Response.status(Response.Status.FORBIDDEN).entity(messageApplicationResponse).build();
    }

    public static Response forbidden() {
        return Response.status(Response.Status.FORBIDDEN).build();
    }

    public static Response notFound(String message) {
        MessageApplicationResponse messageApplicationResponse = new MessageApplicationResponse();
        messageApplicationResponse.setMessage(message);
        return Response.status(Response.Status.NOT_FOUND).entity(messageApplicationResponse).build();
    }

    public static Response notFound() {
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    public static Response internalServerError(String message) {
        MessageApplicationResponse messageApplicationResponse = new MessageApplicationResponse();
        messageApplicationResponse.setMessage(message);
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(messageApplicationResponse).build();
    }

    public static Response internalServerError() {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
    }
}
