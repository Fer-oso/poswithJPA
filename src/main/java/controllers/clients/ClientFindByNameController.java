package controllers.clients;

import entitys.models.addres.Address;
import entitys.models.client.Client;
import entitys.models.telephone.Telephone;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import javax.swing.table.DefaultTableModel;

import views.clients.ClientFindByNameFormView;
import java.awt.event.MouseEvent;
import javax.swing.JOptionPane;
import interfaces.entitys.clients.IClient;
import interfaces.services.TelephoneService;
import interfaces.services.AddressService;
import interfaces.services.ClientService;
import java.awt.HeadlessException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientFindByNameController extends MouseAdapter implements ActionListener {

    private final ClientFindByNameFormView clientFindByNameFormView;

    private final ClientService clientServiceImp;

    private DefaultTableModel model = new DefaultTableModel();
    private List<Client> listClients;

    private int row;
    private int id;
    private Client client;
    private Telephone telephone;
    private Address address;
    private int rowTelephoneSelected;
    private int rowStreetDirectionSelected;

    /*Constructors*/
    public ClientFindByNameController(ClientFindByNameFormView clientFindByNameFormView, ClientService clientServiceImp, AddressService addressServiceImp, TelephoneService telephoneServiceImp) {

        this.clientFindByNameFormView = clientFindByNameFormView;

        this.clientServiceImp = clientServiceImp;

        addActionsListeners();
    }

    /*Actions*/
    private void addActionsListeners() {

        clientFindByNameFormView.getJtTableClients().addMouseListener(this);

        clientFindByNameFormView.getBtnSearch().addActionListener(this);

        clientFindByNameFormView.getBtnEdit().addActionListener(this);

        clientFindByNameFormView.getBtnDelete().addActionListener(this);

        clientFindByNameFormView.getBtnCancel().addActionListener(this);

        clientFindByNameFormView.getJcbPhones().addActionListener(this);

        clientFindByNameFormView.getJcbStreetDirection().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == clientFindByNameFormView.getBtnSearch()) {

            try {

                if (!searchButton()) {

                    refreshTable();

                    String value = clientFindByNameFormView.getTxtSearch().getText().toLowerCase();

                    listClients = findAllBy(value);

                    listClients(listClients);
                }

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }

        }

        if (e.getSource() == clientFindByNameFormView.getBtnEdit()) {

            try {

                if (setClientwithDataOfForm()) {

                    editClient(client);

                    loadList();

                }

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }

        }

        if (e.getSource() == clientFindByNameFormView.getBtnDelete()) {

            try {

                deleteClient(id);

                loadList();

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
        }

        if (e.getSource() == clientFindByNameFormView.getBtnCancel()) {

            try {

                loadList();

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
        }

        if (e.getSource() == clientFindByNameFormView.getJcbPhones()) {

            setTelephoneInForm();
        }

        if (e.getSource() == clientFindByNameFormView.getJcbStreetDirection()) {

            setAddressInForm();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == clientFindByNameFormView.getJtTableClients()) {

            try {
                getClientSelectedOfTable();

                setFormWithSelectedClient();

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
        }
    }

    /*FUNCTIONS*/
 /*Load information*/
    public void loadList() {
        try {

            refreshTable();

            clearForm();

            listClients = clientServiceImp.findAll();

            listClients(listClients);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    /*Functions to setting data in Form and Table*/
    private void listClients(List<Client> listClients) throws Exception {

        try {

            model = (DefaultTableModel) clientFindByNameFormView.getJtTableClients().getModel();

            for (IClient cl : listClients) {

                Object[] clientObject = {cl.getId(), cl.getName(), cl.getLastName(), cl.getAge(),
                    cl.isAvailability(), cl.getSsn(), cl.getClasification()};

                model.addRow(clientObject);
            }

            this.clientFindByNameFormView.getJtTableClients().setModel(model);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    private boolean searchButton() {

        if (clientFindByNameFormView.getTxtSearch().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Insert Value");

            return true;
        }

        return false;
    } // chequear

    private List<Client> findAllBy(String value) {

        if (!(value.charAt(0) >= 97 && value.charAt(0) <= 122)) {

            return List.of(clientServiceImp.findBySsn(value).get());
        }

        return clientServiceImp.findAllByLastName(value);
    } // chequear 

    /*Functions to manipulate Client*/
    private void editClient(Client client) throws Exception {

        try {

            clientServiceImp.update(client);

            JOptionPane.showMessageDialog(null, "Client edited succesfully");

        } catch (HeadlessException e) {

            JOptionPane.showMessageDialog(null, "Error editing client");

        }
    }

    private void deleteClient(Integer id) throws Exception {

        try {

            clientServiceImp.delete(id);

        } catch (Exception e) {

            System.out.println(e.getMessage());
        }
    }

    private boolean setClientwithDataOfForm() {

        if (clientFindByNameFormView.getTxtName().getText().equals("") || clientFindByNameFormView.getTxtLastname().getText().equals("")
                || clientFindByNameFormView.getTxtAge().getText().equals("") || clientFindByNameFormView.getTxtSsn().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "All fields required");

            return false;
        }

        /*Edicion de entidad IClient*/
        client.setName(clientFindByNameFormView.getTxtName().getText());

        client.setLastName(clientFindByNameFormView.getTxtLastname().getText());

        client.setAge(Integer.valueOf(clientFindByNameFormView.getTxtAge().getText()));

        client.setAvailability(clientFindByNameFormView.getJcbAvailability().isSelected());

        client.setSsn(clientFindByNameFormView.getTxtSsn().getText());

        client.setClasification(clientFindByNameFormView.getTxtClasification().getText());

        client.setAvailability(clientFindByNameFormView.getJcbAvailability().isSelected());

        /*Edicion de la entidad Phone para pasarle a la entidad Clients*/
        client.getTelephone().set(rowTelephoneSelected, telephone);

        client.getTelephone().get(rowTelephoneSelected).setNumberPhone(Integer.valueOf(clientFindByNameFormView.getJcbPhones().getEditor().getItem().toString()));

        client.getTelephone().get(rowTelephoneSelected).setTypePhone(clientFindByNameFormView.getTxtTypePhone().getText());

        /*Edicion de la entidad StandarAddres para pasarle a la entidad Clients*/
        client.getAddress().get(rowStreetDirectionSelected).setStreetDirection(clientFindByNameFormView.getJcbStreetDirection().getEditor().getItem().toString());

        client.getAddress().get(rowStreetDirectionSelected).setStreetNumber(Integer.valueOf(clientFindByNameFormView.getTxtStreetNumber().getText()));

        client.getAddress().get(rowStreetDirectionSelected).setPostalCode(Integer.valueOf(clientFindByNameFormView.getTxtPostalCode().getText()));

        client.getAddress().get(rowStreetDirectionSelected).setCity(clientFindByNameFormView.getTxtCity().getText());

        client.getAddress().get(rowStreetDirectionSelected).setState(clientFindByNameFormView.getTxtState().getText());

        return true;
    }

    private void setTelephoneInForm() {

        Object value = clientFindByNameFormView.getJcbPhones().getSelectedItem();

        if (!(value instanceof String)
                && value != null
                && !(clientFindByNameFormView.getJcbPhones().getEditor().getItem().toString().equals(""))) {

            telephone = (Telephone) value;

            clientFindByNameFormView.getTxtTypePhone().setText(telephone.getTypePhone());

            rowTelephoneSelected = clientFindByNameFormView.getJcbPhones().getSelectedIndex();
        }
    }

    private void setAddressInForm() {

        Object value = clientFindByNameFormView.getJcbStreetDirection().getSelectedItem();

        if (!(value instanceof String) && value != null && !(clientFindByNameFormView.getJcbStreetDirection().getEditor().getItem().toString().equals(""))) {

            address = (Address) value;

            rowStreetDirectionSelected = clientFindByNameFormView.getJcbStreetDirection().getSelectedIndex();

            clientFindByNameFormView.getTxtStreetNumber().setText(String.valueOf(address.getStreetNumber()));

            clientFindByNameFormView.getTxtPostalCode().setText(String.valueOf(address.getPostalCode()));

            clientFindByNameFormView.getTxtCity().setText(address.getCity());

            clientFindByNameFormView.getTxtState().setText(address.getState());
        }
    }

    /*Functions to manipulate UX*/
    private void getClientSelectedOfTable() {

        row = clientFindByNameFormView.getJtTableClients().getSelectedRow();

        client = listClients.get(row);

        id = client.getId();

        System.out.println(client);
    }

    private void setModelJcbPhones() {

        try {

            List<Telephone> phoneList = client.getTelephone();

            clientFindByNameFormView.getJcbPhones().removeAllItems();

            clientFindByNameFormView.getJcbPhones().setEditable(true);

            for (Telephone telephone : phoneList) {

                clientFindByNameFormView.getJcbPhones().addItem(telephone);
            }

        } catch (Exception ex) {

            Logger.getLogger(ClientFindByNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setModelJcbAddress() {

        try {

            List<Address> addressList = client.getAddress();

            clientFindByNameFormView.getJcbStreetDirection().removeAllItems();

            clientFindByNameFormView.getJcbStreetDirection().setEditable(true);

            for (Address address : addressList) {

                clientFindByNameFormView.getJcbStreetDirection().addItem(address);
            }

        } catch (Exception ex) {

            Logger.getLogger(ClientFindByNameController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setFormWithSelectedClient() {

        clientFindByNameFormView.getLblId().setText(String.valueOf(client.getId()));

        clientFindByNameFormView.getTxtName().setText(client.getName());

        clientFindByNameFormView.getTxtLastname().setText(String.valueOf(client.getLastName()));

        clientFindByNameFormView.getTxtAge().setText(String.valueOf(client.getAge()));

        clientFindByNameFormView.getTxtSsn().setText(String.valueOf(client.getSsn()));

        clientFindByNameFormView.getTxtClasification().setText(client.getClasification());

        setModelJcbPhones();

        setModelJcbAddress();

        clientFindByNameFormView.getTxtStreetNumber().setText(String.valueOf(address.getStreetNumber()));

        clientFindByNameFormView.getTxtPostalCode().setText(String.valueOf(address.getPostalCode()));

        clientFindByNameFormView.getTxtCity().setText(address.getCity());

        clientFindByNameFormView.getTxtState().setText(address.getState());

        clientFindByNameFormView.getJcbAvailability().setSelected(client.isAvailability());
    }

    private void refreshTable() {

        for (int i = 0; i < model.getRowCount(); i++) {

            model.removeRow(i);

            i -= 1;
        }
    }

    private void clearForm() {

        clientFindByNameFormView.getLblId().setText("");

        clientFindByNameFormView.getTxtName().setText("");

        clientFindByNameFormView.getTxtLastname().setText("");

        clientFindByNameFormView.getTxtAge().setText("");

        clientFindByNameFormView.getTxtSsn().setText("");

        clientFindByNameFormView.getTxtClasification().setText("");

        clientFindByNameFormView.getJcbStreetDirection().removeAllItems();

        clientFindByNameFormView.getTxtStreetNumber().setText("");

        clientFindByNameFormView.getTxtPostalCode().setText("");

        clientFindByNameFormView.getTxtCity().setText("");

        clientFindByNameFormView.getTxtState().setText("");

        clientFindByNameFormView.getJcbAvailability().setSelected(false);

        clientFindByNameFormView.getTxtTypePhone().setText("");

        clientFindByNameFormView.getJcbPhones().removeAllItems();

        clientFindByNameFormView.getJcbStreetDirection().removeAllItems();

        clientFindByNameFormView.getTxtStreetNumber().setText("");

        clientFindByNameFormView.getTxtPostalCode().setText("");

        clientFindByNameFormView.getTxtCity().setText("");

        clientFindByNameFormView.getTxtState().setText("");

        clientFindByNameFormView.getJcbAvailability().setSelected(false);
    }
}
