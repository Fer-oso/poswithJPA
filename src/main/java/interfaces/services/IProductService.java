package interfaces.services;

import entitys.models.product.Product;
import interfaces.entitys.product.IProduct;
import interfaces.services.crud.CrudService;
import java.util.List;

public interface IProductService<T extends IProduct, ID> extends CrudService<T, ID>{
    
     List<Product> findByValue(String value);
    
     Product findByProductCode( String productCode);

 
}
