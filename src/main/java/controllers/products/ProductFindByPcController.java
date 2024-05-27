package controllers.products;

import entitys.models.product.Product;
import interfaces.services.ProductService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.table.DefaultTableModel;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import lombok.SneakyThrows;
import views.products.ProductFindByPcFormView;

public class ProductFindByPcController extends MouseAdapter implements ActionListener {

    private final ProductFindByPcFormView productFindByPcFormView;

    private final ProductService productServiceImp;

    private DefaultTableModel model = new DefaultTableModel();

    private List<Product> listProducts;
    private int row;
    private int id;
    private Product product;

    /*Constructors*/
    public ProductFindByPcController(ProductFindByPcFormView productFindByPcFormView, ProductService productServiceImp) {

        this.productFindByPcFormView = productFindByPcFormView;

        this.productServiceImp = productServiceImp;

        addACtionsListeners();
    }

    /*Actions*/
    private void addACtionsListeners() {

        this.productFindByPcFormView.getJtTableProducts().addMouseListener(this);

        this.productFindByPcFormView.getBtnSearch().addActionListener(this);

        this.productFindByPcFormView.getBtnEdit().addActionListener(this);

        this.productFindByPcFormView.getBtnDelete().addActionListener(this);

        this.productFindByPcFormView.getBtnCancel().addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == productFindByPcFormView.getBtnSearch()) {

            if (!searchButton()) {

                refreshTable();

                listProducts = findByValue();

                listProducts(listProducts);

                clearForm();

                System.out.println(listProducts);
                
            }else {
            
            JOptionPane.showMessageDialog(null, "Input search value");
        }
        }

        if (e.getSource() == productFindByPcFormView.getBtnEdit()) {

            try {

                if (setProductWithDataOfForm()) {

                    editProduct();
                }

                loadList();

            } catch (Exception ex) {

                Logger.getLogger(ProductFindByPcController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        if (e.getSource() == productFindByPcFormView.getBtnDelete()) {

            deleteProduct();

            loadList();
        }

        if (e.getSource() == productFindByPcFormView.getBtnCancel()) {

            loadList();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        if (e.getSource() == productFindByPcFormView.getJtTableProducts()) {

            getProductSelectedOfTable();

            setFormWithSelectedProduct();
        }
    }

    @SneakyThrows
    private void listProducts(List<Product> listProducts) {

        try {
            model = (DefaultTableModel) this.productFindByPcFormView.getJtTableProducts().getModel();

            for (var pr : listProducts) {

                Object[] productObject = {pr.getId(), pr.getName(), pr.getPrice(),
                    pr.getStock(), pr.isAvailability(), pr.getBrand(), pr.getProductCode()};

                model.addRow(productObject);
            }

            this.productFindByPcFormView.getJtTableProducts().setModel(model);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadList() {
        try {
            refreshTable();
            clearForm();
            listProducts = productServiceImp.findAll();
            listProducts(listProducts);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @SneakyThrows
    private Product editProduct() throws Exception {

        setProductWithDataOfForm();

        return productServiceImp.update(product);
    }

    @SneakyThrows
    private void deleteProduct() {

        productServiceImp.delete(id);
    }

    private List<Product> findByValue() {

        var productCode = this.productFindByPcFormView.getTxtSearch().getText();

        return productServiceImp.findByValue(productCode);
    }

    private void getProductSelectedOfTable() {

        row = this.productFindByPcFormView.getJtTableProducts().getSelectedRow();

        product = listProducts.get(row);

        id = product.getId();
    }

    private boolean setProductWithDataOfForm() {

        if (productFindByPcFormView.getTxtName().getText().equals("") || productFindByPcFormView.getTxtPrice().getText().equals("")
                || productFindByPcFormView.getTxtStock().getText().equals("") || productFindByPcFormView.getTxtBrand().getText().equals("") || productFindByPcFormView.getTxtCode().getText().equals("")) {

            JOptionPane.showMessageDialog(null, "All fields required");

            return false;
        }

        product.setName(productFindByPcFormView.getTxtName().getText());

        product.setPrice(Double.valueOf(productFindByPcFormView.getTxtPrice().getText()));

        product.setStock(Integer.valueOf(productFindByPcFormView.getTxtStock().getText()));

        product.setAvailability(productFindByPcFormView.getJcbAvailability().isSelected());

        product.setBrand(productFindByPcFormView.getTxtBrand().getText());

        product.setProductCode(productFindByPcFormView.getTxtCode().getText());

        return true;
    }

    private void setFormWithSelectedProduct() {

        this.productFindByPcFormView.getLblId().setText(String.valueOf(product.getId()));

        this.productFindByPcFormView.getTxtName().setText(product.getName());

        this.productFindByPcFormView.getTxtPrice().setText(String.valueOf(product.getPrice()));

        this.productFindByPcFormView.getTxtStock().setText(String.valueOf(product.getStock()));

        this.productFindByPcFormView.getJcbAvailability().setSelected(product.isAvailability());

        this.productFindByPcFormView.getTxtBrand().setText(product.getBrand());

        this.productFindByPcFormView.getTxtCode().setText(product.getProductCode());
    }

    private void refreshTable() {

        for (int i = 0; i < model.getRowCount(); i++) {

            model.removeRow(i);

            i -= 1;
        }
    }

    private void clearForm() {

        this.productFindByPcFormView.getLblId().setText("");

        this.productFindByPcFormView.getTxtName().setText("");

        this.productFindByPcFormView.getTxtPrice().setText("");

        this.productFindByPcFormView.getTxtStock().setText("");

        this.productFindByPcFormView.getJcbAvailability().setSelected(false);

        this.productFindByPcFormView.getTxtBrand().setText("");

        this.productFindByPcFormView.getTxtCode().setText("");

        this.productFindByPcFormView.getTxtSearch().setText("");
    }

    private boolean searchButton() {

        return productFindByPcFormView.getTxtSearch().getText().equals("");
    }

}
