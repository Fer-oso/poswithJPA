package services.client;

import entitys.models.client.Client;
import interfaces.persistences.repositorys.entitys.clients.client.ClientRepository;
import interfaces.services.ClientService;
import java.util.List;
import java.util.Optional;
import lombok.SneakyThrows;
import services.exceptions.ClientServiceException;

public class ClientServiceImp implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImp(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    @SneakyThrows
    public Client save(Client client) {

        return clientRepository.save(client).orElseThrow();
    }

    @Override
    public List<Client> saveAll(List<Client> clientList) {
      return  clientRepository.saveAll(clientList);
    }

    @Override
    @SneakyThrows
    public Client update(Client client) {

        return clientRepository.update(client).orElseThrow(() -> new ClientServiceException("No value present with that id"));
    }

    @Override
    public void delete(Integer id) {

        clientRepository.delete(clientRepository.findById(id).orElseThrow());
    }

    @Override
    @SneakyThrows
    public Client findById(Integer id) {

        return clientRepository.findById(id).orElseThrow(() -> new ClientServiceException("No value present with that id"));
    }

    @Override
    @SneakyThrows
    public Optional<Client> findBySsn(String ssn) {

        return clientRepository.findBySsn(ssn);
    }

    @Override
    @SneakyThrows
    public List<Client> findAll() {

        return clientRepository.findAll();
    }

    @Override
    public List<Client> findAllByLastName(String lastName) {
        return clientRepository.findAllByLastName(lastName);
    }

    @Override
    public boolean checkDuplicateRegister(Client client) {

        return findAll().stream().anyMatch(c -> {

            return c.getSsn().equalsIgnoreCase(client.getSsn());

        });
    }
}
