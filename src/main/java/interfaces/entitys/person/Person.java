package interfaces.entitys.person;

import entitys.models.addres.Address;
import entitys.models.telephone.Telephone;
import interfaces.entitys.entity.Entity;
import java.util.List;

public interface Person<K> extends Entity<K> {

    String getName();

    void setName(String name);

    String getLastName();

    void setLastName(String lastName);

    Integer getAge();

    void setAge(Integer age);

    String getSsn();

    void setSsn(String ssn);

    List<Address> getAddress();

    void setAddress(List<Address> address);

    List<Telephone> getPhone();

    void setPhone(List<Telephone> phone);

    boolean isAvailability();

    void setAvailability(boolean availability);

    String getClasification();

    void setClasification(String clasification);
}
