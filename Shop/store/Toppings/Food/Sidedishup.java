package store.Toppings.Food;

import store.CartItem;
import store.Toppings.Toppings;

public class Sidedishup implements Toppings {
    
    @Override
    public double calculatePrice(CartItem item) {
        return (item.getProduct().getPrice()+10.0)*item.getQuantity();
    }
}
