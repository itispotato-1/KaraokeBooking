package store;

public class CartItem {

    private final Product product;
    private int quantity;
    private String tpye;

    private void checkRep() {
        if (product == null) {
            throw new RuntimeException("RI violated: product cannot be null.");
        }
        if (quantity <= 0) {
            throw new RuntimeException("RI violated: quantity must be positive.");
        }
    }

    public CartItem(Product product,int quantity,String tpye) {
        this.product = product;
        this.quantity = quantity;
        this.tpye = tpye;
        checkRep();
    }

    public Product getProduct() {return this.product;}
    public int  getQuantity() {return this.quantity;}
    public String getTpye() {return this.tpye;}

    public void increaseQuantity(int amount){
        if (amount > 0)
            this.quantity = this.quantity+amount;
        checkRep();
    }

}