package services.phone;

import entitys.models.telephone.Telephone;
import interfaces.persistences.repositorys.entitys.phones.TelephoneRepository;
import interfaces.services.TelephoneService;
import java.util.ArrayList;
import services.exceptions.AddresServiceException;
import services.exceptions.PhoneServiceException;
import lombok.SneakyThrows;

public class TelephoneServiceImp implements TelephoneService {

    private static final long serialVersionUID = 1L;

    private final TelephoneRepository telephoneRepository;
    
    Telephone telephone;

    public TelephoneServiceImp(TelephoneRepository phoneRepository) {
        this.telephoneRepository = phoneRepository;
    }

    @Override
    public Telephone save(Telephone object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Telephone update(Integer id, Telephone object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Telephone> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Telephone findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public boolean checkDuplicateRegister(Telephone t) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }


}
