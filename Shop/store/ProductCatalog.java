package store;
import java.util.ArrayList ;
import java.util.List;


public class ProductCatalog {
    private ArrayList<Product> products = new ArrayList<>();

    private void checkRep() {
        if (products == null) {
            throw new RuntimeException("RI violated: products list cannot be null.");
        }
        
        for (int i = 0; i < products.size(); i++) {
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(i).equals(products.get(j))) {
                    throw new RuntimeException("RI violated: catalog contains duplicate products.");
                }
            }
        }
    }

    public ProductCatalog() {
        checkRep();
    }

    public void addProduct(Product product) {
        if (product != null && !products.contains(product)) {
            products.add(product);
        }
        checkRep();
    }

    public Product findById(String productId) throws ProductNotFoundException {
        for (Product p : products) {
            if (p.getProductId().equals(productId)) {
                return p;
            }
        }
        throw new ProductNotFoundException("Product with ID '" + productId + "' not found in catalog.");
    }

    public List<Product> getAllProducts() { 
        return new ArrayList<>(products); 
    }

}
