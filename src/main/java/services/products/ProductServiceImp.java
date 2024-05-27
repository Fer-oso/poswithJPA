package services.products;

import entitys.models.product.Product;
import interfaces.persistences.repositorys.entitys.products.ProductRepository;
import interfaces.services.ProductService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import lombok.SneakyThrows;

public class ProductServiceImp implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImp(ProductRepository productRepository) {

        this.productRepository = productRepository;
    }

    @Override
    public Product save(Product product) {
        return productRepository.save(product).orElseThrow();
    }

    @Override
    public List<Product> saveAll(List<Product> productList) {
        return productRepository.saveAll(productList);
    }

    @Override
    public Product update(Product product) {
        return productRepository.update(product).orElseThrow();
    }

    @Override
    public void delete(Integer id) {
        productRepository.delete(findById(id));
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Integer id) {
        return productRepository.findById(id).orElseThrow();
    }

    @Override

    public Product findByProductCode(String productCode) {
        
        Product optionalProduct = null;
        
        if(productRepository.findByProductCode(productCode).isPresent()){
        
          return optionalProduct = productRepository.findByProductCode(productCode).get();
        }
        
       return optionalProduct;
    }

    @Override
    public List<Product> findByValue(String value) {

        Iterator<Product> iteratorListProducts = productRepository.findByValue(value);

        List<Product> listProducts = new ArrayList<>();

        while (iteratorListProducts.hasNext()) {
            Product product = iteratorListProducts.next();

            listProducts.add(product);
        }

        return listProducts;
    }

    @Override
    public boolean checkDuplicateRegister(Product product) {
        return findAll().stream().anyMatch(p -> {
            return p.getProductCode().equalsIgnoreCase(product.getProductCode());
        });
    }

}
