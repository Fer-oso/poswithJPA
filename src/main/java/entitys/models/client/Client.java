package entitys.models.client;

import entitys.models.addres.Address;
import entitys.models.telephone.Telephone;
import interfaces.entitys.clients.IClient;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
@EqualsAndHashCode
@ToString
@Table(name = "clients")
public class Client implements IClient{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "lastname")
    private String lastName;
    
    @Column(name = "age")
    private Integer age;
    
    @Column(name = "ssn",unique = true)
    private String ssn;
    
    @Column(name = "clasification")
    private String clasification;
    
    @Column(name = "availability")
    private boolean availability;
    
    @OneToMany( fetch = FetchType.EAGER)
    @JoinTable(name= "client_address", joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"),
                                inverseJoinColumns = @JoinColumn(name = "id_address", referencedColumnName = "id") )
    private List<Address> address;
    
    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name= "client_phone", joinColumns = @JoinColumn(name = "id_client", referencedColumnName = "id"),
                                inverseJoinColumns = @JoinColumn(name = "id_phone", referencedColumnName = "id") )
    private List<Telephone> telephone;

    @Tolerate
    public Client() {
    }


   
    
}
