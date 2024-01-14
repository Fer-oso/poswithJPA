package entitys.models.shop.checkout;

import entitys.models.shop.ShoppingCart;
import interfaces.entitys.checkout.ICheckOut;
import interfaces.entitys.paymentMethod.PaymentMethod;
import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Tolerate;

@Entity
@Builder
@Getter
@Setter
public class CheckOut implements ICheckOut<Integer> {

    private static final long serialVersionUID = 1L;

    @Id        
    Integer id;
    
    ShoppingCart shoppingCar;
    
    ArrayList<PaymentMethod> paymentMethods;
    
    boolean state; 

    @Tolerate
    public CheckOut() {
    }
    
    
}
