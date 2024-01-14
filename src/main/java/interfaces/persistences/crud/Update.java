package interfaces.persistences.crud;

import java.util.Optional;

public interface Update<T> {
    
    Optional<T> update (T object);
    
}
