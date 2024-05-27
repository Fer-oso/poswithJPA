package interfaces.entitys.shoppingCart;

import entitys.models.client.Client;
import entitys.models.product.SelectedProduct;
import interfaces.entitys.entity.Entity;
import java.util.Collection;
import java.util.Map;

public interface IShoppingCart<ID> extends Entity<ID> {

    public Client getClient();

    public void setClient(Client client);

    public Map<String,SelectedProduct>getProducts();

    public void setProducts(Map<String,SelectedProduct> products);

    public Double getFinalPrice();

    public void setFinalPrice(Double total);

}
