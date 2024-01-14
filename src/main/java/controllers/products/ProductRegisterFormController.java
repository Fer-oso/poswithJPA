package controllers.products;

import entitys.models.product.Product;
import interfaces.services.ProductService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import lombok.SneakyThrows;
import views.products.ProductRegisterFormView;

public class ProductRegisterFormController extends MouseAdapter implements ActionListener, Serializable {

    private static final long serialVersionUID = 1L;

    private final ProductRegisterFormView productRegisterFormView;

    private final ProductService productServiceImp;

    private DefaultTableModel model = new DefaultTableModel();
    private ArrayList<Product> listProducts;
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

        productRegisterFormView.getBtnDelete().addActionListener(this);

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

        if (e.getSource() == productRegisterFormView.getBtnDelete()) {

            try {

                delete(product.getId());

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

        if (!checkFields()) {

            product = Product.builder()
                    .name(productRegisterFormView.getTxtName().getText())
                    .brand(productRegisterFormView.getTxtBrand().getText())
                    .price(Double.valueOf(productRegisterFormView.getTxtPrice().getText()))
                    .stock(Integer.valueOf(productRegisterFormView.getTxtStock().getText()))
                    .availability(productRegisterFormView.getJcbAvailability().isSelected())
                    .productCode(productRegisterFormView.getTxtProductCode().getText()).build();
        } else {

            JOptionPane.showMessageDialog(null, "All fields are required");
        }
    }

    private Product save() {

        if (productServiceImp.checkDuplicateRegister(product)) {

            JOptionPane.showMessageDialog(null, "Product already registered, can find him with product_code " + product.getProductCode());

            return null;
        }

        JOptionPane.showMessageDialog(null, "Product created successfull");

        return productServiceImp.save(product);
    }

    private void delete(Integer id) {

        int value = JOptionPane.showConfirmDialog(null, "Want delete selected product?");

        if (value == 0) {

            productServiceImp.delete(id);

            JOptionPane.showMessageDialog(null, "Product removed succesfully");
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

        return productRegisterFormView.getTxtName().getText().equals("") || productRegisterFormView.getTxtPrice().getText().equals("")
                || productRegisterFormView.getTxtStock().getText().equals("") || productRegisterFormView.getTxtBrand().getText().equals("")
                || productRegisterFormView.getTxtProductCode().getText().equals("");
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

            i = i - 1;
        }
    }

}
