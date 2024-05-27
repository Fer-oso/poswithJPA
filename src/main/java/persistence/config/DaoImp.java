package persistence.config;

import interfaces.persistences.repositorys.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import persistence.dao.exceptios.DaoExceptions;

public class DaoImp implements Repository {

    EntityManagerFactory entityManagerFactory;

    EntityManager entityManager;

    public DaoImp(String persistenceUnitName) {

        entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);

        entityManager = entityManagerFactory.createEntityManager();
    }

    @Override
    public EntityManager getEntityManager() {

        if (!entityManager.isOpen()) {

            entityManager = entityManagerFactory.createEntityManager();
        }

        return entityManager;
    }

    @Override
    public void persist(Object object) {

        try {
            
            getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.persist(object);
            
            entityManager.flush();

            entityManager.getTransaction().commit();

        } catch (Exception e) {

            System.out.println(new DaoExceptions(e.getMessage()));

        } finally {

            entityManager.close();
        }
    }

    @Override
    public <T> T merge(T entity) {

        try {
            
            getEntityManager();

            entityManager.getTransaction().begin();

            entityManager.merge(entity);
            
            entityManager.flush();

            entityManager.getTransaction().commit();

            return entity;
            
        } catch (Exception e) {
            
             System.out.println(new DaoExceptions(e.getMessage()));
            
        } finally {
            
            entityManager.close();
        }
        
        return null;
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
