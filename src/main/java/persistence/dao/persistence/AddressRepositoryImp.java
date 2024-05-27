package persistence.dao.persistence;

import entitys.models.addres.Address;
import interfaces.persistences.repositorys.Repository;
import interfaces.persistences.repositorys.entitys.address.AddressRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AddressRepositoryImp implements AddressRepository {

    Repository repository;

    public AddressRepositoryImp(Repository repository) {
        this.repository = repository;
    }
    
    @Override
    public Optional<Address> save(Address address) {
      
        repository.persist(address);
        
        return Optional.ofNullable(address);
        
    }

    @Override
    public Optional<Address> update(Address address) {
       
        repository.merge(address);
        
        return Optional.ofNullable(address);
    }

    @Override
    public void delete(Address address) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<Address> findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Address> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Address> saveAll(List<Address> addressList) {
       addressList.forEach(address -> repository.persist(address));
       
       return addressList;
    }

   
}
