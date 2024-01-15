package interfaces.persistences.repositorys.entitys.clients.client;

import entitys.models.addres.Address;
import entitys.models.telephone.Telephone;
import interfaces.entitys.clients.IClient;
import interfaces.persistences.crud.CrudRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface IClientRepository<T extends IClient, ID> extends CrudRepository<T, ID> {

    Optional<T> findBySsn(String ssn);

    List<T> findAllByName(String name);

    List<T> findAllByLastName(String lastName);

    List<T> findAllByAge(Integer age);

    List<T> findAllByClasification(String clasification);

    List<T> findAllByAvailability(boolean availability);

    void insertClientAddress(T client, Address... address) throws Exception;

    void insertClientPhone(T client, Telephone... phone) throws Exception;

    ArrayList<Telephone> getPhonesClients(T client) throws Exception;

    ArrayList<Address> getAddressClients(T client) throws Exception;

}
