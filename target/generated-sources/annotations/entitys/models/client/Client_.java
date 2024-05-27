package entitys.models.client;

import entitys.models.addres.Address;
import entitys.models.telephone.Telephone;
import jakarta.persistence.metamodel.ListAttribute;
import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-05-27T14:31:55", comments="EclipseLink-4.0.2.v20230616-r3bfa6ac6ddf76d7909adc5ea7ecaa47c02c007ed")
@StaticMetamodel(Client.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class Client_ { 

    public static volatile SingularAttribute<Client, String> lastName;
    public static volatile ListAttribute<Client, Address> address;
    public static volatile SingularAttribute<Client, String> clasification;
    public static volatile SingularAttribute<Client, String> name;
    public static volatile ListAttribute<Client, Telephone> telephone;
    public static volatile SingularAttribute<Client, Integer> id;
    public static volatile SingularAttribute<Client, Boolean> availability;
    public static volatile SingularAttribute<Client, Integer> age;
    public static volatile SingularAttribute<Client, String> ssn;

}