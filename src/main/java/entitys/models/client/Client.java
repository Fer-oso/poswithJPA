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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.util.List;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;

@NamedQueries({
    
@NamedQuery(name="Client.findBySsn" ,query="SELECT c FROM Client c WHERE c.ssn = :ssn"),
@NamedQuery(name="Client.findAll" ,query="SELECT c FROM Client c"),
@NamedQuery(name="Client.findAllByName" ,query="SELECT c FROM Client c WHERE c.name = :name"),
@NamedQuery(name="Client.findAllByLastName" ,query="SELECT c FROM Client c WHERE c.lastName = :lastName"),
@NamedQuery(name="Client.findAllByAge" ,query="SELECT c FROM Client c WHERE c.age = :age"),
@NamedQuery(name="Client.findAllByClasification" ,query="SELECT c FROM Client c WHERE c.clasification = :clasification"),
@NamedQuery(name="Client.findAllByAvailability" ,query="SELECT c FROM Client c WHERE c.availability = :availability")

})


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
