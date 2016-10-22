package pl.agh.id.tripsettlement.rest.groups.manager;

import org.omg.CORBA.MARSHAL;
import pl.agh.id.tripsettlement.exception.ManagerException;
import pl.agh.id.tripsettlement.log.annotation.Loggable;
import pl.agh.id.tripsettlement.rest.groups.model.GroupDTO;
import pl.agh.id.tripsettlement.service.exceptions.ServiceException;
import pl.agh.id.tripsettlement.service.group.GroupService;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by pawel on 22.10.16.
 */
@Stateless
@Loggable
public class GroupManager {


    @EJB
    private GroupService groupService;


    public GroupDTO getGroupById(String groupId) throws ManagerException{

        try {
            groupService.getGroupResponse(groupId);
            //TODO
            return new GroupDTO();
        } catch (ServiceException e) {
            throw new ManagerException("", e.type);
        }
    }

}
