package entitys.models.product;

import interfaces.entitys.product.IProduct;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;


@Builder
@Entity
@Getter
@Setter
@ToString

@Table(name = "products")
public class Product implements IProduct {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String brand;
    private Double price;
    private Integer stock;
    private boolean availability;
    private String productCode;
    
    @Tolerate
    public Product() {
    }

    
}
