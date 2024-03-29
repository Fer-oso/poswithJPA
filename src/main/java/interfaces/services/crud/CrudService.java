package interfaces.services.crud;

import interfaces.services.Service;
import java.util.List;

public interface CrudService<T, ID> extends Service<T, ID> {

    public T save(T object);

    public T update(ID id, T object);

    public void delete(ID id);
    
    public List<T> findAll();
    
    public T findById(ID id);
}
