package store;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ProductCatalog {// คิดว่าจะเปลี่ยนชื่อเป็นProductSystem
    private File fileProduct = null;
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    private FileReader fr = null;
    private BufferedReader br = null;

    private ArrayList<Product> products = new ArrayList<>();
    private ArrayList<String> Order = new ArrayList<>();
    private ArrayList<toppings> toppingFood = new ArrayList<>();
    private ArrayList<toppings> toppingDrink = new ArrayList<>();

    private void checkRep() {
        if (products == null) {
            throw new RuntimeException("RI violated: products list cannot be null.");
        }

        for (int i = 0; i < products.size(); i++) {
            for (int j = i + 1; j < products.size(); j++) {
                if (products.get(i).getProductId().equals(products.get(j).getProductId())) {
                    throw new RuntimeException("RI violated: catalog contains duplicate products.");
                }
            }
        }

        for (int i = 0; i < toppingDrink.size() - 1; i++) {
            if (toppingDrink.get(i).getTop().equals(toppingDrink.get(i + 1).getTop())) {
                throw new RuntimeException("RI violated: toppingDrink Same");
            }
        }
        for (int i = 0; i < toppingFood.size() - 1; i++) {
            if (toppingFood.get(i).getTop().equals(toppingFood.get(i + 1).getTop())) {
                throw new RuntimeException("RI violated: toppingFood Same");
            }
        }
    }

    public ProductCatalog() {
        fileProduct = new File("./file/Order.csv");
        checkRep();
    }

    /**
     * Method สำหรับการสั่งอาหาร
     * 
     * @param idUser     ใส่Idที่สั่ง
     * @param product    ใส่ของที่สั่ง
     * @param toppingAdd ใส่สิ่งที่เพิ่มเติม
     * @param price      ใส่ราคาของของนั้น
     * @param amount     ใส่จำนวนของนั้น
     */
    public void addOrder(int idUser, Product product, String toppingAdd, double price, int amount) {
        try {
            String tempS;
            String tempOrder = "";
            boolean found = false;
            fr = new FileReader(fileProduct);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[|]");
                // [0]ID [1]PRODUCT [2]AMOUNT [3]PRICE [4]ID_PRODUCT
                boolean compareIdUser = tempSplit[0].equals(Integer.toString(idUser));
                boolean compareProductName = tempSplit[1].equals(product.getProductName() + toppingAdd);
                if (compareIdUser && compareProductName) {
                    tempOrder += tempSplit[0] + "|" + tempSplit[1] + "|"
                            + "x" + (amount + Integer.parseInt(tempSplit[2].substring(1))) + "|"
                            + (Double.parseDouble(tempSplit[3]) + price) + "|" + product.getProductId() + "\n";
                    found = true;
                } else {
                    tempOrder += tempS + "\n";
                }
            }

            fw = new FileWriter(fileProduct, false);
            bw = new BufferedWriter(fw);
            if (!found) {
                tempOrder += (idUser + "|" + product.getProductName() + toppingAdd + "|x" + amount + "|" + price
                        + "|" + product.getProductId() + "\n");
            }
            bw.write(tempOrder);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                br.close();
                fr.close();
                bw.close();
                fw.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        sortFileOrder();
    }

    public void removeOrder(int idUser, String nameProductAndTopping, int minusAmount) {
        try {
            String tempS;
            String tempOrder = "";
            boolean found = false;
            fr = new FileReader(fileProduct);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[|]");
                // [0]ID [1]PRODUCT [2]AMOUNT [3]PRICE [4]ID_PRODUCT
                if (nameProductAndTopping.equals(tempSplit[1]) && idUser == Integer.parseInt(tempSplit[0])) {
                    // System.out.println((Integer.parseInt(tempSplit[2].substring(1)) -
                    // minusAmount));
                    if ((Integer.parseInt(tempSplit[2].substring(1)) - minusAmount) > 0) {
                        tempOrder += tempSplit[0] + "|" + tempSplit[1] + "|"
                                + "x" + (Integer.parseInt(tempSplit[2].substring(1)) - minusAmount) + "|"
                                + (Double.parseDouble(tempSplit[3])
                                        - ((Double.parseDouble(tempSplit[3])
                                                / Double.parseDouble(tempSplit[2].substring(1)))
                                                * minusAmount))
                                + "|" + tempSplit[4] + "\n";
                    }
                } else {
                    tempOrder += tempS + "\n";
                }
            }

            fw = new FileWriter(fileProduct, false);
            bw = new BufferedWriter(fw);
            bw.write(tempOrder);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                br.close();
                fr.close();
                bw.close();
                fw.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        sortFileOrder();
    }

    public void sortFileOrder() {
        try {
            String tempS;
            String tempOrder = "";
            ArrayList<String> Order = new ArrayList<>();
            fr = new FileReader(fileProduct);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                Order.add(tempS);
            }
            Order.sort((a, b) -> {
                String[] tempA = a.split("[|]");
                String[] tempB = b.split("[|]");
                return tempA[1].compareTo(tempB[1]);
            });
            for (String string : Order) {
                tempOrder += string + "\n";
            }
            fw = new FileWriter(fileProduct, false);
            bw = new BufferedWriter(fw);
            bw.write(tempOrder);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                br.close();
                fr.close();
                bw.close();
                fw.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    public ArrayList<String> getOrder(int id) {
        Order.clear();
        try {
            String tempS;
            fr = new FileReader(fileProduct);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[|]");
                // [0]ID [1]PRODUCT [2]AMOUNT [3]PRICE [4]ID_PRODUCT
                if (tempSplit[0].equals(Integer.toString(id))) {
                    Order.add(tempS);
                }
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return Order;
    }

    public void addProduct(Product product) {
        if (product != null) {
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
            } else if (toping == Topping.DRINK) {
                toppingDrink.add(tps);
            }
        }
        checkRep();
    }

    public List<toppings> getAllTopFood() {
        return new ArrayList<>(toppingFood);
    }

    public List<toppings> getAllTopDrink() {
        return new ArrayList<>(toppingDrink);
    }
}
