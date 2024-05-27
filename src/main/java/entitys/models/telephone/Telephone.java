package entitys.models.telephone;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;
import interfaces.entitys.phone.ITelephone;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class Telephone implements ITelephone{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Integer id;
    
    @Column(name = "number_phone")
    Integer numberPhone;

    @Column(name = "type_phone")
    String typePhone;
    
    @Tolerate
    public Telephone() {
    }

    @Override
    public String toString() {
        
        return String.valueOf(getNumberPhone());
    }
    
    
}
