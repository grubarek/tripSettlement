package pl.agh.id.tripsettlement.rest.resource;


import pl.agh.id.tripsettlement.rest.response.ResponseHelper;

import javax.ejb.Stateless;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;


@Stateless
@Path("/users")
public class UserResource {
    private static final Logger LOGGER = Logger.getLogger(UserResource.class.toString());


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(@Context final HttpServletRequest request) {
        List<String> userTypeDTOList = new ArrayList<>();
        LOGGER.info("UsersResource.test - response: list size " + userTypeDTOList.size());
        return ResponseHelper.ok(userTypeDTOList);
    }


}
