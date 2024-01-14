package services.client;

import entitys.models.addres.Address;
import entitys.models.client.Client;
import entitys.models.telephone.Telephone;
import interfaces.persistences.repositorys.entitys.clients.client.ClientRepository;
import interfaces.services.ClientService;
import java.util.ArrayList;
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
    public Client save(Client object) {

        return clientRepository.save(object).orElseThrow();
    }

    @Override
    @SneakyThrows
    public Client update(Integer id, Client object) {

        return clientRepository.update(object).orElseThrow(() -> new ClientServiceException("No value present with that id"));
    }

    @Override
    @SneakyThrows
    public void delete(Integer id) {

        Client client = clientRepository.findById(id).orElseThrow(() -> new ClientServiceException("No value present with that id"));

        clientRepository.delete(client);
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
    public ArrayList<Client> findAll() {

        return clientRepository.findAll();
    }

    @Override
    public boolean checkDuplicateRegister(Client object) {

        return findAll().stream().anyMatch(t -> {

            return t.getSsn().equalsIgnoreCase(object.getSsn());

        });
    }

    @SneakyThrows
    @Override
    public void insertClientAddress(Client client, Address... address) {

        clientRepository.insertClientAddress(client, address);

    }

    @SneakyThrows
    @Override
    public void insertClientPhones(Client client, Telephone... telephones) {

        clientRepository.insertClientPhone(client, telephones);
    }

    @Override
    public ArrayList<Telephone> getPhonesClients(Client client) throws Exception {
        try {

            return clientRepository.getPhonesClients(client);

        } catch (Exception e) {

            throw new ClientServiceException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Address> getAddressClients(Client client) throws Exception {
        try {

            return clientRepository.getAddressClients(client);

        } catch (Exception e) {

            throw new ClientServiceException(e.getMessage());
        }
    }

    @Override
    public ArrayList<Client> findAllBy(Object value) {

        return clientRepository.findAllBy(value);
    }

}
