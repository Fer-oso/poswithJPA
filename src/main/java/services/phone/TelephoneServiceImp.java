package services.phone;

import entitys.models.telephone.Telephone;
import interfaces.persistences.repositorys.entitys.phones.TelephoneRepository;
import interfaces.services.TelephoneService;
import java.util.ArrayList;
import java.util.List;
import lombok.SneakyThrows;
import services.exceptions.AddresServiceException;

public class TelephoneServiceImp implements TelephoneService {

    private final TelephoneRepository telephoneRepository;

    private Telephone telephone;
    
    public TelephoneServiceImp(TelephoneRepository phoneRepository) {
        this.telephoneRepository = phoneRepository;
    }

    @Override
    @SneakyThrows
    public Telephone save(Telephone telephone) {
        
         if (checkDuplicateRegister(telephone)) {

           return findById(telephone.getId());

        } else {

            return telephoneRepository.save(telephone).orElseThrow(()->new AddresServiceException("Cant duplicate telephone"));
        }
    }

    @Override
    public Telephone update(Telephone telephone) {

        return telephoneRepository.update(telephone).get();
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
    public boolean checkDuplicateRegister(Telephone telephone) {
        
          return findAll().stream().anyMatch(t -> {
            
            this.telephone = t;
            
            return (t.getNumberPhone().equals(telephone.getNumberPhone()));
        });
    }

    @Override
    public List<Telephone> saveAll(List<Telephone> telephoneList) {
        return telephoneRepository.saveAll(telephoneList);
    }

}
