package main;

import entitys.models.client.Client;
import interfaces.persistences.repositorys.Repository;
import persistence.dao.persistence.ClientRepositoryImp;
import interfaces.persistences.repositorys.entitys.clients.client.ClientRepository;
import interfaces.services.ClientService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import persistence.config.DaoImp;
import services.client.ClientServiceImp;

public class Poswithmysqlc {

    public static void main(String[] args) throws Exception {

        System.out.println("Hello World!");

        // POS.main(args);
        
        
    
        
        Repository repository = new DaoImp();

        ClientRepository clientRepository = new ClientRepositoryImp(repository);

        ClientService clientService = new ClientServiceImp(clientRepository);
        
        Client client = Client.builder().name("persiste").build();
        
        
        
        System.out.println(clientRepository.findAllByAge(30));
        
        

        // FunctionalEjemplos functionalEjemplos = new FunctionalEjemplos();
//         
//Client clientBD = clientService.findById(20);
//
//clientBD.setName("Fernando");
//
//clientService.update(20, clientBD);
        //   productService.delete(5);
// Product productToSave = productService.findById(5);
//productToSave.setStock(10);
//        productService.update(5, productToSave);
        //  productService.save(productToSave);
        // Product productDB = productService.findById(6);
//        
//        
//            
//         System.out.println(productDB);
//         productDB.setName("fer");
//         
        //  System.out.println(productService.update(5, productDB));
//                  
//        
//         System.out.println(productService.findAll());
        // productRepository.save(productDB);
//        Function<Product, Product> guardar = product ->  productService.save(product);
//                
//        Function<Product, Product> buscar = product -> productService.findById(product.getId());
//        
//        Consumer<Product> mostrar = product -> System.out.println("hello" + product ); 
        //  Function<Product, Product> mostrar = guardar.andThen(buscar);
        //    search.apply(productToSave);
        // Product product =guardar.andThen(buscar).apply(productToSave);
//       FunctionalEjemplos functionalEjemplos = new FunctionalEjemplos();
//       
//       
//      functionalEjemplos.guardarymostrar.accept(productToSave);
        //  functionalEjemplos.mostrar.accept(functionalEjemplos.guardar.andThen(functionalEjemplos.buscar).apply(productToSave));
//        Optional<Product> product4 = Optional.ofNullable(new Product());
//        
//        product4.ifPresent(functionalEjemplos.guardarymostrar);
        //   System.out.println(clientService.update(19, clientBD));
    }
}
