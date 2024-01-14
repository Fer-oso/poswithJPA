package persistence.config;

import interfaces.persistences.repositorys.Repository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class RepositoryImp implements Repository {

    protected EntityManagerFactory entityManagerFactory;
    protected EntityManager entityManager;

    public RepositoryImp(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected void conectar() {
        if (!entityManager.isOpen()) {
            entityManager = entityManagerFactory.createEntityManager();
        }
    }

    protected void desconectar() {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    @Override
    public void persist(Object t) {
       conectar();
       
       entityManager.getTransaction().begin();
       
       entityManager.persist(t);
       
       entityManager.getTransaction().commit();
       
       desconectar();
    }

    @Override
    public void merge(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void remove(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object find(Object entityClass) {
       
        entityManager.find(entityClass.getClass(),)
    }

  
}
