package interfaces.persistences.crud;

import interfaces.persistences.repositorys.FindAll;
import interfaces.persistences.repositorys.FindById;

public interface Crud<T,ID> extends Save<T>, Update<T>, Delete<T>, FindById<T, ID>,FindAll<T> {

}
