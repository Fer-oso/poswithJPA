package persistence.dao.persistence;

import entitys.models.telephone.Telephone;
import interfaces.persistences.repositorys.Repository;
import interfaces.persistences.repositorys.entitys.phones.TelephoneRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TelephoneRepositoryImp implements TelephoneRepository {

    Repository repository;

    public TelephoneRepositoryImp(Repository repository) {
        this.repository = repository;
    }
    
    @Override
    public Optional<Telephone> save(Telephone telephone) {
    
        repository.persist(telephone);
        
        return Optional.ofNullable(telephone);
    }

    @Override
    public Optional<Telephone> update(Telephone telephone) {
        
       repository.merge(telephone);
       
       return Optional.ofNullable(telephone);
    }

    @Override
    public void delete(Telephone telephone) {
       
    }

    @Override
    public Optional<Telephone> findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Telephone> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Telephone> saveAll(List<Telephone> telephoneList) {
         telephoneList.forEach(telephone -> repository.persist(telephone));
                
      return telephoneList;  
    }

}
