package controllers.shop.checkoutformcontroller;

import entitys.models.product.SelectedProduct;
import entitys.models.shop.ShoppingCart;
import entitys.models.shop.checkout.CheckOut;
import entitys.models.shop.paymentmethod.Cash;
import entitys.models.shop.paymentmethod.CreditCard;
import interfaces.entitys.paymentMethod.PaymentMethod;
import interfaces.services.CheckOutService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import views.shop.CheckOutFormView;

public class CheckOutFormController implements ActionListener {

    private final CheckOutFormView checkOutFormView;

    private final CheckOutService checkOutServiceImp;

    private final ShoppingCart shoppingCart;

    private DefaultTableModel model = new DefaultTableModel();

    private Double inputCash;

    List<PaymentMethod> paymentMethodsList = new ArrayList<>();

    Cash cash;

    CreditCard creditCard;

    CheckOut checkOut;

    public CheckOutFormController(CheckOutFormView checkOutFormView, ShoppingCart shoppingCart, CheckOutService checkOutServiceImp) {

        this.checkOutFormView = checkOutFormView;

        this.checkOutServiceImp = checkOutServiceImp;

        this.shoppingCart = shoppingCart;

        checkOutFormView.getTxtCash().setEditable(false);

        addActionsListeners();

        listProductsCarshop();

        setLblInfo();
    }

    private void addActionsListeners() {

        checkOutFormView.getJrbCash().addActionListener(this);

        checkOutFormView.getJrbCreditCard().addActionListener(this);

        checkOutFormView.getTxtCash().addActionListener(this);

        checkOutFormView.getJcbCuotes().addActionListener(this);

        checkOutFormView.getTxtCreditCardQuantity().addActionListener(this);
    }

    int row;

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == checkOutFormView.getTxtCash()) {

            inputCash();
        }

        if (e.getSource() == checkOutFormView.getJrbCash()) {

            jrbCashButtonActions();
        }

        if (e.getSource() == checkOutFormView.getJrbCreditCard()) {

            row = jrbCreditCardButtonActions();

            selectedFees(row);
        }

        if (e.getSource() == checkOutFormView.getJcbCuotes()) {

            row = jrbCreditCardButtonActions();

            selectedFees(row);
        }

        if (e.getSource() == checkOutFormView.getTxtCreditCardQuantity()) {

            selectedFees(row);
        }
    }

    private int jrbCreditCardButtonActions() {

        if (checkOutFormView.getJrbCreditCard().isSelected()) {

            checkOutFormView.getJcbCuotes().setEnabled(true);

            checkOutFormView.getTxtFinalPriceCc().setVisible(true);

        } else {

            checkOutFormView.getTxtFinalPriceCc().setVisible(false);
        }
        return checkOutFormView.getJcbCuotes().getSelectedIndex();
    }

    private void jrbCashButtonActions() {

        if (checkOutFormView.getJrbCash().isSelected()) {

            checkOutFormView.getTxtCash().setEditable(true);

        } else {

            checkOutFormView.getTxtCash().setEditable(false);
        }
    }

    private void setLblInfo() {

        checkOutFormView.getLblClientName().setText(shoppingCart.getClient().getName() + " " + shoppingCart.getClient().getLastName());

        checkOutFormView.getLblTotalPrice().setText(String.valueOf(shoppingCart.getFinalPrice()));
    }

    private void inputCash() {

        inputCash = Double.valueOf(checkOutFormView.getTxtCash().getText());
    }

    private void listProductsCarshop() {

        List<SelectedProduct> listProductsShoppingCart = shoppingCart.getProducts();

        model = (DefaultTableModel) checkOutFormView.getjTableCheckOut().getModel();

        for (SelectedProduct psc : listProductsShoppingCart) {

            Object[] objectProduct = {psc.getProductCode(), psc.getProductName(), psc.getProductBrand(),
                psc.getProductQuantity(), psc.getProductPrice(), psc.getFinalPrice()};

            model.addRow(objectProduct);
        }
    }

    private void selectedFees(int row) {

        Double creditCardPriceByFee = 0.0;

        Double creditCardQuantity = 0.0;

        System.out.println("este es el row antes del switch" + row);

        switch (row) {

            case 0 -> {

                if (checkOutFormView.getTxtCreditCardQuantity().getText().equals("")) {

                    creditCardPriceByFee = shoppingCart.getFinalPrice() * 1.06;

                } else {

                    creditCardQuantity = Double.valueOf(checkOutFormView.getTxtCreditCardQuantity().getText());

                    creditCardPriceByFee = creditCardQuantity * 1.06;
                }
            }

            case 1 -> {

                if (checkOutFormView.getTxtCreditCardQuantity().getText().equals("")) {

                    creditCardPriceByFee = shoppingCart.getFinalPrice() * 1.11;

                } else {

                    creditCardQuantity = Double.valueOf(checkOutFormView.getTxtCreditCardQuantity().getText());

                    creditCardPriceByFee = creditCardQuantity * 1.11;
                }
            }

            case 2 -> {

                if (checkOutFormView.getTxtCreditCardQuantity().getText().equals("")) {

                    creditCardPriceByFee = shoppingCart.getFinalPrice() * 1.18;

                } else {

                    creditCardQuantity = Double.valueOf(checkOutFormView.getTxtCreditCardQuantity().getText());

                    creditCardPriceByFee = creditCardQuantity * 1.18;
                }
            }

            case 3 -> {

                if (checkOutFormView.getTxtCreditCardQuantity().getText().equals("")) {

                    creditCardPriceByFee = shoppingCart.getFinalPrice() * 1.24;

                } else {

                    creditCardQuantity = Double.valueOf(checkOutFormView.getTxtCreditCardQuantity().getText());

                    creditCardPriceByFee = creditCardQuantity * 1.24;
                }
            }

            default ->

                creditCardPriceByFee = shoppingCart.getFinalPrice() * 1.06;
        }

        checkOutFormView.getTxtFinalPriceCc().setText(String.format("%.2f", creditCardPriceByFee));
    }
}
