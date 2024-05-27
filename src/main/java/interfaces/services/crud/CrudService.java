package interfaces.services.crud;

import interfaces.services.Service;
import java.util.List;

public interface CrudService<T, ID> extends Service<T, ID> {

    public T save(T object);

    public T update(T object);

    public void delete(ID id);

    public T findById(ID id);

    List<T> saveAll(List<T> entityList);

    public List<T> findAll();

}
