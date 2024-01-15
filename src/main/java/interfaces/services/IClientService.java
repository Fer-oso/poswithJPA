package interfaces.services;

import entitys.models.addres.Address;
import entitys.models.telephone.Telephone;
import interfaces.entitys.clients.IClient;
import interfaces.services.crud.CrudService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IClientService<T extends IClient, ID> extends CrudService<T, ID>{
    
    Optional<T> findBySsn(String ssn);
    
    List<T> findAllByName(String name);

    List<T> findAllByLastName(String lastName);

    List<T> findAllByAge(Integer age);

    List<T> findAllByClasification(String clasification);

    List<T> findAllByAvailability(boolean availability);
    
    void insertClientAddress(T client, Address... address) throws Exception;
    
    void insertClientPhones(T client, Telephone... telephones) throws Exception;

    ArrayList<Telephone> getPhonesClients(T client) throws Exception;

    ArrayList<Address> getAddressClients(T client) throws Exception;
}
