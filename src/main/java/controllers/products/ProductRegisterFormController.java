package controllers.products;

import entitys.models.product.Product;
import interfaces.services.ProductService;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import lombok.SneakyThrows;
import views.products.ProductRegisterFormView;

public class ProductRegisterFormController extends MouseAdapter implements ActionListener {

    private final ProductRegisterFormView productRegisterFormView;

    private final ProductService productServiceImp;

    private DefaultTableModel model = new DefaultTableModel();
    private List<Product> listProducts;
    private Product product;

    /*Constructors*/
    public ProductRegisterFormController(ProductRegisterFormView productRegisterFormView, ProductService productServiceImp) {

        this.productRegisterFormView = productRegisterFormView;

        this.productServiceImp = productServiceImp;

        addACtionsListeners();
    }

    /*Actions*/
    private void addACtionsListeners() {

        productRegisterFormView.getJtTableProducts().addMouseListener(this);

        productRegisterFormView.getBtnSave().addActionListener(this);

        productRegisterFormView.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == productRegisterFormView.getBtnSave()) {

            try {

                createNewProduct();

                save();

                clearForm();

                refreshTable();

                listProducts();

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
        }

        if (e.getSource() == productRegisterFormView.getBtnCancel()) {

            try {

                clearForm();

                refreshTable();

                listProducts = productServiceImp.findAll();

                listProducts();

            } catch (Exception ex) {

                System.out.println(ex.getMessage());
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == productRegisterFormView.getJtTableProducts()) {

            getProductSelectedOfTable();

            setFormWithSelectedProduct();
        }
    }

    /*Functions*/
    @SneakyThrows
    private void createNewProduct() {

        try {

            if (checkFields()) {

                product = Product.builder()
                        .name(productRegisterFormView.getTxtName().getText())
                        .brand(productRegisterFormView.getTxtBrand().getText())
                        .price(Double.valueOf(productRegisterFormView.getTxtPrice().getText()))
                        .stock(Integer.valueOf(productRegisterFormView.getTxtStock().getText()))
                        .availability(productRegisterFormView.getJcbAvailability().isSelected())
                        .productCode(productRegisterFormView.getTxtProductCode().getText()).build();
            }

        } catch (HeadlessException | NumberFormatException e) {
            
            throw new Exception(e.getMessage());
        }
    }

    private void save() {

        if (productServiceImp.checkDuplicateRegister(product)) {

            JOptionPane.showMessageDialog(null, "Product already registered, can find him with product_code " + product.getProductCode());

        } else {

            product = productServiceImp.save(product);

            JOptionPane.showMessageDialog(null, "Product created successfull");

        }
    }

    public void listProducts() {

        listProducts = productServiceImp.findAll();

        model = (DefaultTableModel) this.productRegisterFormView.getJtTableProducts().getModel();

        for (var pr : listProducts) {

            Object[] productObject = {pr.getId(), pr.getName(), pr.getPrice(),
                pr.getStock(), pr.isAvailability(), pr.getBrand(), pr.getProductCode()};

            model.addRow(productObject);
        }

        this.productRegisterFormView.getJtTableProducts().setModel(model);
    }

    private void getProductSelectedOfTable() {

        var row = this.productRegisterFormView.getJtTableProducts().getSelectedRow();

        product = listProducts.get(row);
    }

    private void setFormWithSelectedProduct() {

        this.productRegisterFormView.getLblId().setText(String.valueOf(product.getId()));

        this.productRegisterFormView.getTxtName().setText(product.getName());

        this.productRegisterFormView.getTxtPrice().setText(String.valueOf(product.getPrice()));

        this.productRegisterFormView.getTxtStock().setText(String.valueOf(product.getStock()));

        checkAvailability();

        this.productRegisterFormView.getTxtBrand().setText(product.getBrand());

        this.productRegisterFormView.getTxtProductCode().setText(product.getProductCode());
    }

    private void checkAvailability() {

        if (product.isAvailability()) {

            this.productRegisterFormView.getJcbAvailability().setSelected(true);

        } else {

            this.productRegisterFormView.getJcbAvailability().setSelected(false);
        }
    }

    private boolean checkFields() {

        if (productRegisterFormView.getTxtName().getText().equals("") || productRegisterFormView.getTxtPrice().getText().equals("")
                || productRegisterFormView.getTxtStock().getText().equals("") || productRegisterFormView.getTxtBrand().getText().equals("")
                || productRegisterFormView.getTxtProductCode().getText().equals("")) {
            JOptionPane.showMessageDialog(productRegisterFormView, "All fields required");

            return false;
        }
        return true;
    }

    private void clearForm() {

        this.productRegisterFormView.getLblId().setText("");

        this.productRegisterFormView.getTxtName().setText("");

        this.productRegisterFormView.getTxtPrice().setText("");

        this.productRegisterFormView.getTxtStock().setText("");

        this.productRegisterFormView.getJcbAvailability().setSelected(false);

        this.productRegisterFormView.getTxtBrand().setText("");

        this.productRegisterFormView.getTxtProductCode().setText("");
    }

    public void refreshTable() {

        for (int i = 0; i < model.getRowCount(); i++) {

            model.removeRow(i);

            i -= 1;
        }
    }

}
