package entitys.models.telephone;


import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;
import interfaces.entitys.phone.ITelephone;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.io.Serializable;

@Entity
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class Telephone implements ITelephone, Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    Integer numberPhone;

    String typePhone;

    @Tolerate
    public Telephone() {
    }
}
