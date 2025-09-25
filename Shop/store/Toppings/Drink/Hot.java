package store.Toppings.Drink;

import store.CartItem;
import store.Toppings.Toppings;

public class Hot implements Toppings{
    @Override
    public double calculatePrice(CartItem item) {
        // TODO Auto-generated method stub
        return (item.getProduct().getPrice()-10)*item.getQuantity();
    }
}
