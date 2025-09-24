package store.Toppings.Food;

import store.CartItem;
import store.Toppings.Toppings;

public class Default implements Toppings{

    @Override
    public double calculatePrice(CartItem item) {
        // TODO Auto-generated method stub
        return item.getProduct().getPrice()*item.getQuantity();
    }
    
}