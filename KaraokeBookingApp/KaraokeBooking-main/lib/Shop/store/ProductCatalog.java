package store;
import java.io.*;

import java.util.ArrayList ;
import java.util.List;



public class ProductCatalog {
    // private File fileProduct = null;
    // private FileWriter fw = null;
    // private BufferedWriter bw = null;
    
    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList <toppings> topps = new ArrayList<>(); 

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
        //fileProduct = new File("./file/Order.csv");
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


    public void addtopps(toppings tps) {
        if (topps != null ) {
            topps.add(tps);
        }
    }

    public List<toppings> getAlltopps() { 
        return new ArrayList<>(topps); 
    }


    // public void writerOrder(String use , String product, String top,double Cost) {
    //      try {
    //         fw = new FileWriter(fileProduct,true);
    //         bw = new BufferedWriter(fw);
    //         bw.write(use+" : "+product+", Toppings = "+top+", Cost = "+Cost+"\n"); 
    //     } catch (Exception e) {
    //         System.out.println(e);
    //     } finally {
    //         try {
    //             bw.close();
    //             fw.close();
    //         } catch (Exception e) {
    //             System.out.println(e);
    //         }
    //     }
    // }

}
