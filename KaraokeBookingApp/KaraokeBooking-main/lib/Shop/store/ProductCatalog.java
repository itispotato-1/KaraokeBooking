package store;

import java.io.*;

import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {
    // private File fileProduct = null;
    // private FileWriter fw = null;
    // private BufferedWriter bw = null;

    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<toppings> toppingFood = new ArrayList<>();
    private ArrayList<toppings> toppingDrink = new ArrayList<>();

    private void checkRep() {
        if (products == null) {
            throw new RuntimeException("RI violated: products list cannot be null.");
        }

        for (int i = 0; i < products.size(); i++) {
            for (int j = i + 1; j < products.size(); j++) {
                //System.out.println(j+"|"+products.get(i).getProductId() +":"+products.get(j).getProductId());
                if (products.get(i).getProductId().equals(products.get(j).getProductId())) {
                    throw new RuntimeException("RI violated: catalog contains duplicate products.");
                }
            }
        }

        for (int i = 0; i< toppingDrink.size()-1 ;i++) {
            if(toppingDrink.get(i).getTop().equals(toppingDrink.get(i+1).getTop())){
                throw new RuntimeException("RI violated: toppingDrink Same");
            }
        }
        for (int i = 0; i< toppingFood.size()-1 ;i++) {
            if(toppingFood.get(i).getTop().equals(toppingFood.get(i+1).getTop())){
                throw new RuntimeException("RI violated: toppingFood Same");
            }
        }
    }

    public ProductCatalog() {
        // fileProduct = new File("./file/Order.csv");
        checkRep();
    }

    public void addProduct(Product product) {
        if (product != null ) {
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

    public void addtopping(Topping toping, toppings tps) {
        if (toppingFood != null) {
            if (toping == Topping.FOOD) {
                toppingFood.add(tps);
            }else if(toping == Topping.DRINK){
                toppingDrink.add(tps);
            }
        }
        checkRep();
    }

    public List<toppings> getAllTopFood() {
        return new ArrayList<>(toppingFood);
    }

    public List<toppings> getAllTopDrink(){
        return new ArrayList<>(toppingDrink);
    }
}
