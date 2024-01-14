package interfaces.services;

public interface Service<T, ID>{
    
    boolean checkDuplicateRegister(T t);
}
