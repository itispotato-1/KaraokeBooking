package store.Toppings.Food;

import store.CartItem;
import store.Toppings.Toppings;

public class Special implements Toppings {
    @Override
    public double calculatePrice(CartItem item) {
        // TODO Auto-generated method stub
        return (item.getProduct().getPrice()+15.0)*item.getQuantity();
    }
}
