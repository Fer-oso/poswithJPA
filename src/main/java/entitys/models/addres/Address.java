package entitys.models.addres;

import interfaces.entitys.addres.IAddress;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.io.Serializable;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;


@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "address")
public class Address implements IAddress, Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    String streetDirection;

    Integer streetNumber;

    String city;

    String state;

    Integer postalCode;
    
    @Tolerate
    public Address() {
    }  
}
