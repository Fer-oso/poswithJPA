package services.address;

import entitys.models.addres.Address;
import java.util.ArrayList;
import services.exceptions.AddresServiceException;
import interfaces.persistences.repositorys.entitys.address.AddressRepository;
import interfaces.services.AddressService;
import lombok.SneakyThrows;

public class AddressServiceImp implements AddressService {

    private static final long serialVersionUID = 1L;

    private final AddressRepository addressRepository;
    
     Address address;

    public AddressServiceImp(AddressRepository addressRepository) {

        this.addressRepository = addressRepository;
    }

    @Override
    public Address save(Address object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Address update(Integer id, Address object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
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
    public boolean checkDuplicateRegister(Address t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

   
}
