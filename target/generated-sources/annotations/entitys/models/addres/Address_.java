package entitys.models.addres;

import jakarta.persistence.metamodel.SingularAttribute;
import jakarta.persistence.metamodel.StaticMetamodel;
import javax.annotation.processing.Generated;

@Generated(value="org.eclipse.persistence.internal.jpa.modelgen.CanonicalModelProcessor", date="2024-01-15T06:13:00", comments="EclipseLink-4.0.2.v20230616-r3bfa6ac6ddf76d7909adc5ea7ecaa47c02c007ed")
@StaticMetamodel(Address.class)
@SuppressWarnings({"rawtypes", "deprecation"})
public class Address_ { 

    public static volatile SingularAttribute<Address, Integer> streetNumber;
    public static volatile SingularAttribute<Address, String> city;
    public static volatile SingularAttribute<Address, Integer> postalCode;
    public static volatile SingularAttribute<Address, Integer> id;
    public static volatile SingularAttribute<Address, String> state;
    public static volatile SingularAttribute<Address, String> streetDirection;

}