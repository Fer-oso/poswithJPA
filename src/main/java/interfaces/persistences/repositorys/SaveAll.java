package interfaces.persistences.repositorys;

import java.util.List;

@FunctionalInterface
public interface SaveAll<T> {
    
    List<T> saveAll(List<T> objectList);
}
