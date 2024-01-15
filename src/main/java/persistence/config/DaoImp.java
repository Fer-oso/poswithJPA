package persistence.config;

import interfaces.persistences.repositorys.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class DaoImp implements Repository {

    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("posPU");

    EntityManager entityManager = entityManagerFactory.createEntityManager();

    @Override
    public EntityManager getEntityManager() {

        if (!entityManager.isOpen()) {

            entityManager = entityManagerFactory.createEntityManager();
        }
        
        return entityManager;
    }

    @Override
    public void persist(Object object) {
        
        getEntityManager();

        entityManager.getTransaction().begin();

        entityManager.persist(object);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public <T> T merge(T entity) {
        
       getEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(entity);

        entityManager.getTransaction().commit();

        entityManager.close();

        return entity;
    }

    @Override
    public void remove(Object entity) {
        
        getEntityManager();

        entityManager.getTransaction().begin();

        entityManager.remove(entity);

        entityManager.getTransaction().commit();

        entityManager.close();
    }

    @Override
    public <T> T find(Class<T> entityType, Object primaryKey) {
        
         getEntityManager();
        
        return entityManager.find(entityType, primaryKey);
    }
}
