package pl.agh.id.tripsettlement.rest.resource;

import pl.agh.id.tripsettlement.exception.TripSettlementException;
import pl.agh.id.tripsettlement.rest.groups.manager.GroupManager;
import pl.agh.id.tripsettlement.rest.response.ResponseHelper;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by pawel on 22.10.16.
 */
@Stateless
@Path("/groups")
public class GroupResource {

    private static final Logger LOGGER = Logger.getLogger(GroupResource.class.toString());


    @Inject
    private GroupManager groupManager;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response test(@Context final HttpServletRequest request) {
        List<String> userTypeDTOList = new ArrayList<>();
        LOGGER.info("GroupResource.test - response: list size " + userTypeDTOList.size());
        return ResponseHelper.ok(userTypeDTOList);
    }


    @GET
    @Path("/{key}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getGroup(String key, @Context final HttpServletRequest request) throws TripSettlementException {

        groupManager.getGroupById(key);
        LOGGER.info("GroupResource.getGroup - response:");
        return ResponseHelper.ok();
    }
}

