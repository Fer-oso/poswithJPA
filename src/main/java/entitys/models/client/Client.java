package entitys.models.client;

import entitys.models.addres.Address;
import entitys.models.telephone.Telephone;
import interfaces.entitys.clients.IClient;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;

@Entity
@Builder
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "clients")

public class Client implements IClient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String lastName;
    private Integer age;
    private String ssn;
    private String clasification;
    private boolean availability;
    
    @OneToMany()
    @JoinTable(name= "client_address", joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"),
                                inverseJoinColumns = @JoinColumn(name = "id_address", referencedColumnName = "id") )
    private List<Address> address;
    
    @OneToMany()
    @JoinTable(name= "client_phone", joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"),
                                inverseJoinColumns = @JoinColumn(name = "id_phone", referencedColumnName = "id") )
    private List<Telephone> phone;

    @Tolerate
    public Client() {
    }

    
}
