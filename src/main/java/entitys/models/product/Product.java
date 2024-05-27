package entitys.models.product;

import interfaces.entitys.product.IProduct;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;

@Builder
@Entity
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Table(name = "products")


@NamedQueries({
  @NamedQuery(name="Product.findByProductCode" ,query="SELECT p FROM Product p WHERE p.productCode = :productCode"),
  @NamedQuery(name="Product.findAll" ,query="SELECT p FROM Product p"),
  @NamedQuery(name="Product.findByValue", query="SELECT p from Product p WHERE p.productCode LIKE :value OR p.name LIKE :value"),

})
public class Product implements IProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "brand")
    private String brand;
    
    @Column(name = "price")
    private Double price;
    
    @Column(name = "stock")
    private Integer stock;
    
    @Column(name = "availability")
    private boolean availability;
    
    @Column(name = "product_code")
    private String productCode;
    
    @Tolerate
    public Product() {
    }

    
}
