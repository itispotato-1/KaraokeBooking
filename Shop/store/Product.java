package store;

public final class Product {

    private final String productName;
    private final String productId;
    private final double price;

    public void checkRep() {
        if (productId == null || productId.isBlank()) {
            throw new RuntimeException("RI violated: productId cannot be blank.");
        }
        // if (productId.charAt(0) !='F'||productId.charAt(0)!='D') {
        //     throw new RuntimeException("RI violated: productId not F or D.");
        // }
        if (productName == null || productName.isBlank()) {
            throw new RuntimeException("RI violated: productName cannot be blank.");
        }
        if (price < 0) {
            throw new RuntimeException("RI violated: price cannot be negative.");
        }
    }

    public Product(String productId , String productName, double price) {
        this.productName = productName;
        this.productId = productId;
        this.price = price;
        checkRep();
    }

    public String getProductName() {return this.productName;}
    public String getProductId() {return this.productId;}
    public double getPrice() {return this.price;}

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Product product = (Product) obj;
        return productId.equals(product.productId);
    }

    public int hashCode() {
        return productId.hashCode();
    }
    
}
