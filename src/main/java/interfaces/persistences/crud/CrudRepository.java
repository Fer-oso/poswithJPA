package interfaces.persistences.crud;

import interfaces.persistences.repositorys.FindAll;
import interfaces.persistences.repositorys.FindById;
import interfaces.persistences.repositorys.SaveAll;

public interface CrudRepository<T extends Object, ID extends Object> extends Crud<T,ID>,SaveAll<T> , FindById<T, ID>, FindAll<T>{  
    
 
}
