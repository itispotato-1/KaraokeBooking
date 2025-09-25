package store.Toppings.Drink;

import store.CartItem;
import store.Toppings.Toppings;

public class Cold implements Toppings{

    @Override
    public double calculatePrice(CartItem item) {
        // TODO Auto-generated method stub
        return item.getProduct().getPrice()*item.getQuantity();
    }
    
}
