package pl.agh.id.tripsettlement.dao;

import pl.agh.id.tripsettlement.domain.Groups;

import javax.ejb.Local;

/**
 * Created by pawel on 22.10.16.
 */
@Local
public interface GroupDao {
    public long createGroup(Groups groups) throws DaoException;

    public boolean updateGroup(Groups groups) throws DaoException;

    public boolean deleteGroup(long groupId) throws DaoException;

    public Groups getGroupsById(long groupId) throws DaoException;
}
