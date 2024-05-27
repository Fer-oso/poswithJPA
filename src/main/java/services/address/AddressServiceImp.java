package services.address;

import entitys.models.addres.Address;
import java.util.ArrayList;
import interfaces.persistences.repositorys.entitys.address.AddressRepository;
import interfaces.services.AddressService;
import java.util.List;
import lombok.SneakyThrows;
import services.exceptions.AddresServiceException;

public class AddressServiceImp implements AddressService {

    private final AddressRepository addressRepository;

    Address address;
    
    public AddressServiceImp(AddressRepository addressRepository) {

        this.addressRepository = addressRepository;
    }

    @Override
    @SneakyThrows
    public Address save(Address address) {

        if (checkDuplicateRegister(address)) {

           return findById(address.getId());

        } else {

            return addressRepository.save(address).orElseThrow(()->new AddresServiceException("Cant duplicate address"));
        }
    }

    @Override
    public Address update( Address address) {

        return addressRepository.update(address).get();
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Address> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Address findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean checkDuplicateRegister(Address address) {
           return findAll().stream().anyMatch(t -> {
            
            this.address = t;
            
            return (t.getStreetNumber().equals(address.getStreetNumber())
                    && t.getStreetDirection().equalsIgnoreCase(address.getStreetDirection())
                    && t.getCity().equalsIgnoreCase(address.getCity())
                    && t.getState().equalsIgnoreCase(address.getState()));
        });

    }

    @Override
    public List<Address> saveAll(List<Address> addressList) {
        return addressRepository.saveAll(addressList);
    }

}
