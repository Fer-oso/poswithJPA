package main;

import entitys.models.addres.Address;
import entitys.models.client.Client;
import entitys.models.telephone.Telephone;
import interfaces.persistences.repositorys.Repository;
import interfaces.persistences.repositorys.entitys.address.AddressRepository;
import persistence.dao.persistence.ClientRepositoryImp;
import interfaces.persistences.repositorys.entitys.clients.client.ClientRepository;
import interfaces.persistences.repositorys.entitys.phones.TelephoneRepository;
import interfaces.services.AddressService;
import interfaces.services.ClientService;
import interfaces.services.TelephoneService;
import java.util.List;
import persistence.config.DaoImp;
import persistence.dao.persistence.AddressRepositoryImp;
import persistence.dao.persistence.TelephoneRepositoryImp;
import services.address.AddressServiceImp;
import services.client.ClientServiceImp;
import services.phone.TelephoneServiceImp;

public class Poswithmysqlc {

    public static void main(String[] args) throws Exception {

        System.out.println("Hello World!");

        // POS.main(args);
        Repository repository = new DaoImp("posPU");

        ClientRepository clientRepository = new ClientRepositoryImp(repository);

        ClientService clientService = new ClientServiceImp(clientRepository);

        AddressRepository addressRepository = new AddressRepositoryImp(repository);

        AddressService addressService = new AddressServiceImp(addressRepository);

        TelephoneRepository telephoneRepository = new TelephoneRepositoryImp(repository);

        TelephoneService telephoneService = new TelephoneServiceImp(telephoneRepository);

        Telephone telephone = Telephone.builder()
                .numberPhone(46698856)
                .typePhone("Telephone")
                .build();

        Telephone movil = Telephone.builder()
                .numberPhone(1157602019)
                .typePhone("Movil")
                .build();

        Address address = Address.builder()
                .city("Isidro Casanova")
                .postalCode(1765)
                .state("Buenos Aires")
                .streetDirection("Jose Ignacio Rucci")
                .streetNumber(3394)
                .build();

        //telephoneService.save(telephone);
        //addressService.save(address);
      /*  Client client1 = Client.builder()
                .name("Mario")
                .lastName("benedeto")
                .age(30)
                .ssn("38128526")
                .telephone(telephoneService.saveAll(List.of(telephone, movil)))
                .address(List.of(addressService.save(address)))
                .clasification("Client")
                .availability(true)
                .build();
        
        
         Telephone telephone1 = Telephone.builder()
                .numberPhone(44850812)
                .typePhone("Telephone")
                .build();

        Telephone movil1 = Telephone.builder()
                .numberPhone(1167981080)
                .typePhone("Movil")
                .build();

        Address address1 = Address.builder()
                .city("Isidro Casanova")
                .postalCode(1765)
                .state("Buenos Aires")
                .streetDirection("Jose Ignacio Rucci")
                .streetNumber(3394)
                .build();

        Client client2 = Client.builder()
                .name("Fernando")
                .lastName("Perez")
                .age(30)
                .ssn("42352323")
                .telephone(telephoneService.saveAll(List.of(telephone1, movil1)))
                .address(List.of(addressService.save(address1)))
                .clasification("Client")
                .availability(true)
                .build();

         //  clientService.saveAll(List.of(client1,client2));
      //  System.out.println("Esta es la lista de entidades guardadas " + clientService.saveAll(List.of(client1, client2)));
 */
//        client1 = clientService.findById(1);
//        System.out.println("Este es el registro con id" + client1.getId());
//
//        client1.setName("");
//        clientService.update(client1.getId(), client1);
      Client client1 = clientService.findById(1);
        
        client1.setName("Carlos");
        
        System.out.println(clientService.update(client1));
        
        
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
