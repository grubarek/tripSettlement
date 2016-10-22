package pl.agh.id.tripsettlement;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class AbstractFacade {

    @PersistenceContext(unitName = "tripsettlementUnit")
    protected EntityManager entityManager;

    public EntityManager getEntityManager() {
        return entityManager;
    }
}
