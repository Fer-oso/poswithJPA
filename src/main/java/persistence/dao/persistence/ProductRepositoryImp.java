package persistence.dao.persistence;

import entitys.models.product.Product;
import interfaces.persistences.repositorys.Repository;
import interfaces.persistences.repositorys.entitys.products.ProductRepository;
import jakarta.persistence.NoResultException;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

public class ProductRepositoryImp implements ProductRepository {

    Repository repository;

    public ProductRepositoryImp(Repository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Product> save(Product product) {
        repository.persist(product);

        return Optional.ofNullable(product);
    }

    @Override
    public List<Product> saveAll(List<Product> productList) {
        productList.forEach(client -> repository.persist(client));

        return productList;
    }

    @Override
    public Optional<Product> update(Product product) {
        repository.merge(product);

        return Optional.ofNullable(product);
    }

    @Override
    public void delete(Product product) {
        repository.remove(product);
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return Optional.ofNullable(repository.find(Product.class, id));
    }

    @Override
    public Optional<Product> findByProductCode(String productCode) {

        try {
            var query = repository.getEntityManager().createNamedQuery("Product.findByProductCode", Product.class);

            query.setParameter("productCode", productCode);

            return Optional.ofNullable(query.getSingleResult());

        } catch (NoResultException e) {
            
            return Optional.empty();
        }
    }

    @Override
    public List<Product> findAll() {
        return repository.getEntityManager().createNamedQuery("Product.findAll", Product.class).getResultList();
    }

    @Override
    public Iterator<Product> findByValue(String value) {

        String parameter = "%" + value + "%";

        var query = repository.getEntityManager().createNamedQuery("Product.findByValue", Product.class);

        query.setParameter("value", parameter);

        return query.getResultList().iterator();

    }
}
