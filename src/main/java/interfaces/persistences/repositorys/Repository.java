package interfaces.persistences.repositorys;

import jakarta.persistence.EntityManager;

public interface Repository {

    EntityManager getEntityManager();

    void persist(Object entity);

    <T> T merge(T entity);

    void remove(Object entity);

    <T> T find(Class<T> entityType, Object primaryKey);
}
