package store;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private ArrayList<CartItem> items;
    private PricingService pricingService;
    private ProductCatalog productCatalog;

    private void checkRep() {
        if (items == null || pricingService == null || productCatalog == null) {
            throw new RuntimeException("RI violated: core components cannot be null.");
        }
        ArrayList<Product> seenProducts = new ArrayList<>();
        for (CartItem item : items) {
            if (item == null) {
                throw new RuntimeException("RI violated: cart contains a null item.");
            }
            if (seenProducts.contains(item.getProduct())) {
                throw new RuntimeException("RI violated: duplicate product found in cart: " + item.getProduct().getProductId());
            }
            seenProducts.add(item.getProduct());
        }
    }

    public ShoppingCart(PricingService pricingService, ProductCatalog productCatalog) {
        this.items = new ArrayList<>();
        this.pricingService = pricingService;
        this.productCatalog = productCatalog;
        checkRep();
    }

    public void addItem(String productId, int quantity,String tpye) throws ProductNotFoundException {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive.");
        }
        
        Product p = productCatalog.findById(productId);

        for (CartItem item : items) {
            if (item.getProduct().equals(p)) {
                item.increaseQuantity(quantity);
                return;
            }
        }
        items.add(new CartItem(p, quantity, tpye));
        checkRep();
    }

    public void removeItem(String productId) throws InvalidOperationException {
        if (productId == null) {
             throw new IllegalArgumentException("Product ID cannot be null.");
        }

        CartItem itemToRemove = null;
        for (CartItem item : items) {
            if (item.getProduct().getProductId().equals(productId)) {
                itemToRemove = item;
                break;
            }
        }
        if (itemToRemove != null) {
            items.remove(itemToRemove);
            checkRep();
            return ;
        }
        
        throw new InvalidOperationException("Cannot remove item. Product ID '" + productId + "' not found in cart.");
    }

    public double getTotalPrice() {
        double total = 0.0;
        for (CartItem item : items) {
            total += pricingService.calculateItemPrice(item);
        }
        return total;
    }
    
    public int getItemCount() { return items.size(); }
    
    public void clearCart() {
        items.clear();
        checkRep();
    }

    public List<CartItem> getItems() { 
        return new ArrayList<>(items);
}
}
