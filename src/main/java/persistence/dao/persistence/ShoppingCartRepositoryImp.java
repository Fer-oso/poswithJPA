package persistence.dao.persistence;

import entitys.models.shop.ShoppingCart;
import interfaces.persistences.repositorys.Repository;
import interfaces.persistences.repositorys.entitys.shop.ShoppingCartRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ShoppingCartRepositoryImp implements ShoppingCartRepository {

    Repository repository;

    public ShoppingCartRepositoryImp(Repository repository) {
        this.repository = repository;
    }
    
    @Override
    public Optional<ShoppingCart> save(ShoppingCart object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<ShoppingCart> update(ShoppingCart object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(ShoppingCart object) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Optional<ShoppingCart> findById(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<ShoppingCart> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ShoppingCart> saveAll(List<ShoppingCart> entitysList) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
