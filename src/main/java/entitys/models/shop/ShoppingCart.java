package entitys.models.shop;

import entitys.models.client.Client;
import entitys.models.product.SelectedProduct;
import interfaces.entitys.shoppingCart.IShoppingCart;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Tolerate;
import lombok.extern.jackson.Jacksonized;

@Builder
@Getter
@Setter
@ToString
@Jacksonized
public class ShoppingCart implements IShoppingCart<Integer> {

    private Integer id;

    private Client client;

    private Map<String,SelectedProduct> products;
    
    private Double finalPrice;

    @Tolerate
    public ShoppingCart() {
        
    }
    
}
