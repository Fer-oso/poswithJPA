package controllers.clients;

import entitys.models.addres.Address;
import entitys.models.client.Client;
import entitys.models.telephone.Telephone;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import views.clients.ClientRegisterFormView;
import interfaces.services.TelephoneService;
import interfaces.services.AddressService;
import interfaces.services.ClientService;
import java.awt.HeadlessException;
import lombok.SneakyThrows;

public class ClientRegisterFormController implements ActionListener {

    /*Services*/
    private final ClientService clientServiceImp;

    private final AddressService addressServiceImp;

    private final TelephoneService telehponeServiceImp;

    Client client;

    Address address;

    Telephone telephone;

    Telephone telephone2;

    /*VIEWS*/
    private final ClientRegisterFormView clientRegisterFormView;

    /*Constructors*/
    public ClientRegisterFormController(ClientRegisterFormView clientRegisterFormView, ClientService clientServiceImp, AddressService addressServiceImp, TelephoneService telehponeServiceImp) {

        this.clientRegisterFormView = clientRegisterFormView;

        this.clientServiceImp = clientServiceImp;

        this.addressServiceImp = addressServiceImp;

        this.telehponeServiceImp = telehponeServiceImp;

        addACtionsListeners();
    }

    /*Actions*/
    private void addACtionsListeners() {

        clientRegisterFormView.getBtnSave().addActionListener(this);

        clientRegisterFormView.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clientRegisterFormView.getBtnSave()) {

            try {

                createNewClient();

                save(client, address, telephone);

                clearForm();

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }

            if (e.getSource() == clientRegisterFormView.getBtnCancel()) {

                clearForm();
            }
        }
    }

    /*Functions*/
    private void createNewClient() throws Exception {

        try {

            if (checkFields()) {

                client = Client.builder()
                        .name(clientRegisterFormView.getTxtName().getText())
                        .lastName(clientRegisterFormView.getTxtLastName().getText())
                        .age(Integer.valueOf(clientRegisterFormView.getTxtAge().getText()))
                        .ssn(clientRegisterFormView.getTxtSsn().getText())
                        .clasification(clientRegisterFormView.getTxtClasification().getText())
                        .availability(clientRegisterFormView.getJcbAvailability().isSelected())
                        .build();

                address = Address.builder()
                        .streetDirection(clientRegisterFormView.getTxtStreetDirection().getText())
                        .streetNumber(Integer.valueOf(clientRegisterFormView.getTxtStreetNumber().getText()))
                        .city(clientRegisterFormView.getTxtCity().getText())
                        .state(clientRegisterFormView.getTxtState().getText())
                        .postalCode(Integer.valueOf(clientRegisterFormView.getTxtPostalCode().getText()))
                        .build();

                telephone = Telephone.builder()
                        .numberPhone(Integer.valueOf(clientRegisterFormView.getTxtNumberPhone().getText()))
                        .typePhone(clientRegisterFormView.getTxtTypePhone().getText()).build();

                telephone2 = Telephone.builder()
                        .numberPhone(Integer.valueOf(clientRegisterFormView.getTxtNumberPhone2().getText()))
                        .typePhone(clientRegisterFormView.getTxtTypePhone2().getText()).build();
            }

        } catch (HeadlessException | NumberFormatException e) {

            throw new Exception(e.getMessage());
        }
    }

    @SneakyThrows
    private void save(Client client, Address address, Telephone telephone) {

        if (clientServiceImp.checkDuplicateRegister(client)) {

            JOptionPane.showMessageDialog(null, "Client already registered, can find him with SSN " + client.getSsn());

        } else {

            client = clientServiceImp.save(client);

            address = addressServiceImp.save(address);

            telephone = telehponeServiceImp.save(telephone);

            telephone2 = telehponeServiceImp.save(telephone2);

            clientServiceImp.insertClientAddress(client, address);

            clientServiceImp.insertClientPhones(client, telephone, telephone2);

            JOptionPane.showMessageDialog(clientRegisterFormView, "Client registered succesfully");
        }
    }

    private boolean checkFields() {

        if (clientRegisterFormView.getTxtName().getText().equals("") || clientRegisterFormView.getTxtLastName().getText().equals("")
                || clientRegisterFormView.getTxtAge().getText().equals("") || clientRegisterFormView.getTxtSsn().getText().equals("")
                || clientRegisterFormView.getTxtClasification().getText().equals("") || clientRegisterFormView.getTxtNumberPhone().getText().equals("")
                || clientRegisterFormView.getTxtTypePhone().getText().equals("") || clientRegisterFormView.getTxtTypePhone2().getText().equals("")
                || clientRegisterFormView.getTxtNumberPhone2().getText().equals("") || clientRegisterFormView.getTxtStreetDirection().getText().equals("")
                || clientRegisterFormView.getTxtStreetNumber().getText().equals("") || clientRegisterFormView.getTxtPostalCode().getText().equals("")
                || clientRegisterFormView.getTxtCity().getText().equals("") || clientRegisterFormView.getTxtState().getText().equals("")) {

            JOptionPane.showMessageDialog(clientRegisterFormView, "All fields required");

            return false;
        }
        return true;
    }

    private void clearForm() {

        clientRegisterFormView.getLblId().setText("");

        clientRegisterFormView.getTxtName().setText("");

        clientRegisterFormView.getTxtLastName().setText("");

        clientRegisterFormView.getTxtAge().setText("");

        clientRegisterFormView.getTxtClasification().setText("");

        clientRegisterFormView.getJcbAvailability().setSelected(false);

        clientRegisterFormView.getTxtSsn().setText("");

        clientRegisterFormView.getTxtNumberPhone().setText("");

        clientRegisterFormView.getTxtTypePhone().setText("");

        clientRegisterFormView.getTxtTypePhone2().setText("");

        clientRegisterFormView.getTxtTypePhone2().setText("");

        clientRegisterFormView.getTxtStreetDirection().setText("");

        clientRegisterFormView.getTxtStreetNumber().setText("");

        clientRegisterFormView.getTxtCity().setText("");

        clientRegisterFormView.getTxtPostalCode().setText("");

        clientRegisterFormView.getTxtState().setText("");
    }

}
