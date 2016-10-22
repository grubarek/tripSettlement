package pl.agh.id.tripsettlement;

import pl.agh.id.tripsettlement.dao.DaoException;
import pl.agh.id.tripsettlement.dao.GroupDao;
import pl.agh.id.tripsettlement.domain.Groups;
import pl.agh.id.tripsettlement.log.annotation.Loggable;

import javax.ejb.Stateless;
import javax.persistence.NoResultException;

/**
 * Created by pawel on 22.10.16.
 */
@Stateless
@Loggable
public class GroupFacade extends AbstractFacade implements GroupDao {


    @Override
    public long createGroup(Groups groups) throws DaoException {
        return 0;
    }

    @Override
    public boolean updateGroup(Groups groups) throws DaoException {
        return false;
    }

    @Override
    public boolean deleteGroup(long groupId) throws DaoException {
        return false;
    }

    @Override
    public Groups getGroupsById(long groupId) throws DaoException {
        Groups groups = null;
        try {
            groups = entityManager.find(Groups.class, groupId);
        } catch (NoResultException e) {
            throw new DaoException(e);
        } catch (Exception e) {
            throw new DaoException(e);
        }
        return groups;
    }
}
