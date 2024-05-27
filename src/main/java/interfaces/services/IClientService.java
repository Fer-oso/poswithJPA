package interfaces.services;

import interfaces.entitys.clients.IClient;
import interfaces.services.crud.CrudService;
import java.util.List;
import java.util.Optional;

public interface IClientService<T extends IClient, ID> extends CrudService<T, ID>{
    
    Optional<T> findBySsn(String ssn);
    
    List<T> findAllByLastName(String lastName);
}
