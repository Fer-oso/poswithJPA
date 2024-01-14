package interfaces.persistences.repositorys;

public interface Repository{
    
    void persist(Object object);
    
    void merge(Object object);
    
    void remove(Object object);
    
    Object find(Object object);
}
