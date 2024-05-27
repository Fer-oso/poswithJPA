package persistence.dao.persistence;

import entitys.models.client.Client;
import interfaces.persistences.repositorys.Repository;
import interfaces.persistences.repositorys.entitys.clients.client.ClientRepository;
import java.util.List;
import java.util.Optional;

public class ClientRepositoryImp implements ClientRepository {

    Repository repository;

    public ClientRepositoryImp(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Client> save(Client client) {

        repository.persist(client);

        return Optional.ofNullable(client);
    }

    @Override
    public List<Client> saveAll(List<Client> clientList) {

        clientList.forEach(client -> repository.persist(client));

        return clientList;
    }

    @Override
    public Optional<Client> update(Client client) {

        repository.merge(client);

        return Optional.ofNullable(client);

    }

    @Override
    public void delete(Client client) {

        repository.remove(client);
    }

    @Override
    public Optional<Client> findById(Integer id) {

        return Optional.ofNullable(repository.find(Client.class, id));
    }

    @Override
    public Optional<Client> findBySsn(String ssn) {

        var query = repository.getEntityManager().createNamedQuery("Client.findBySsn", Client.class);

        query.setParameter("ssn", ssn);

        return Optional.ofNullable(query.getSingleResult());
    }

    @Override
    public List<Client> findAll() {

        return repository.getEntityManager().createNamedQuery("Client.findAll", Client.class).getResultList();
    }

    @Override
    public List<Client> findAllByName(String name) {

        var query = repository.getEntityManager().createNamedQuery("Client.findAllByName", Client.class);

        query.setParameter("name", name);

        return query.getResultList();
    }

    @Override
    public List<Client> findAllByLastName(String lastName) {

        var query = repository.getEntityManager().createNamedQuery("Client.findAllByLastName", Client.class);

        query.setParameter("lastName", lastName);

        return query.getResultList();
    }

    @Override
    public List<Client> findAllByAge(Integer age) {

        var query = repository.getEntityManager().createNamedQuery("Client.findAllByAge", Client.class);

        query.setParameter("age", age);

        return query.getResultList();
    }

    @Override
    public List<Client> findAllByClasification(String clasification) {

        var query = repository.getEntityManager().createNamedQuery("Client.findAllByClasification", Client.class);

        query.setParameter("clasification", clasification);

        return query.getResultList();
    }

    @Override
    public List<Client> findAllByAvailability(boolean availability) {

        var query = repository.getEntityManager().createNamedQuery("Client.findAllByAvailability", Client.class);

        query.setParameter("availability", availability);

        return query.getResultList();
    }
}
