package entitys.models.addres;

import interfaces.entitys.addres.IAddress;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "address")
public class Address implements IAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;

    @Column(name = "street_direction")
    String streetDirection;

    @Column(name = "street_number")
    Integer streetNumber;

    @Column(name = "city")
    String city;

    @Column(name = "state")
    String state;

    @Column(name = "postal_code")
    Integer postalCode;

    @Tolerate
    public Address() {
    }

    @Override
    public String toString() {
        return getStreetDirection();
    }

}
