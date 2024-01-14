package interfaces.persistences.repositorys.entitys.phones;

import interfaces.persistences.crud.CrudRepository;
import interfaces.entitys.phone.ITelephone;

public interface IPhoneRepository<T extends ITelephone,ID> extends CrudRepository<T, ID>{
    
}
