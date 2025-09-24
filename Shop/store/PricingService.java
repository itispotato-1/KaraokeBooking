package store;

import store.Toppings.Food.*;
import store.Toppings.Drink.*;

public class PricingService {

    public double calculateItemPrice(CartItem item){
        if("Riceup".equalsIgnoreCase(item.getTpye()))
            return new Riceup().calculatePrice(item);
        if("Sidedishup".equalsIgnoreCase(item.getTpye()))
            return new Sidedishup().calculatePrice(item);
        if("Special".equalsIgnoreCase(item.getTpye()))
            return new Special().calculatePrice(item);
        if("Default".equalsIgnoreCase(item.getTpye()))
            return new Default().calculatePrice(item);
        if("Cold".equalsIgnoreCase(item.getTpye()))
            return new Cold().calculatePrice(item);
        if("Hot".equalsIgnoreCase(item.getTpye()))
            return new Hot().calculatePrice(item);
        if("Mix".equalsIgnoreCase(item.getTpye()))
            return new Mix().calculatePrice(item);
        throw new IllegalArgumentException("Unknow Type");
    }

    // public double foodPrice(CartItem item){
    //     if("Riceup".equalsIgnoreCase(item.getTpye()))
    //         return new Riceup().calculatePrice(item);
    //     if("Sidedishup".equalsIgnoreCase(item.getTpye()))
    //         return new Sidedishup().calculatePrice(item);
    //     if("Special".equalsIgnoreCase(item.getTpye()))
    //         return new Sidedishup().calculatePrice(item);
    //     if("Default".equalsIgnoreCase(item.getTpye()))
    //         return new Default().calculatePrice(item);
            
    //     throw new IllegalArgumentException("Unknow Type");
    // }

    // public double drinkPrice(CartItem item){
    //     if("Cold".equalsIgnoreCase(item.getTpye()))
    //         return new Cold().calculatePrice(item);
    //     if("Hot".equalsIgnoreCase(item.getTpye()))
    //         return new Hot().calculatePrice(item);
    //     if("Mix".equalsIgnoreCase(item.getTpye()))
    //         return new Mix().calculatePrice(item);
    //     throw new IllegalArgumentException("Unknow Type");
    // }

}
