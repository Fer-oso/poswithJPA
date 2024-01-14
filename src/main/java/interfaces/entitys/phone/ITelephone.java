package interfaces.entitys.phone;

import interfaces.entitys.entity.Entity;

public interface ITelephone extends Entity<Integer>{
    
    Integer getNumberPhone();
    
    void setNumberPhone(Integer numberPhone);
    
    String getTypePhone();
    
    void setTypePhone(String phone);
    
}
