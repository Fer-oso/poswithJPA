package interfaces.services;

import interfaces.services.crud.CrudService;
import interfaces.entitys.phone.ITelephone;

public interface ITelephoneService<T extends ITelephone,ID> extends CrudService<T, ID>{

}
