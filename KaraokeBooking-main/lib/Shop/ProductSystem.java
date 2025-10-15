package lib.Shop;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ProductSystem {// คิดว่าจะเปลี่ยนชื่อเป็นProductSystem
    private File fileOrder = null;
    private File fileFood = null;
    private File fileDrink = null;
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
        } // คิดว่าจะลบ

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

    public ProductSystem() {
        fileOrder = new File("./file/Order.csv");
        fileFood = new File("./file/Food.csv");
        fileDrink = new File("./file/Drink.csv");
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
            fr = new FileReader(fileOrder);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[|]");
                // [0]ID [1]PRODUCT [2]AMOUNT [3]PRICE [4]ID_PRODUCT
                String ID = tempSplit[0];
                String PRODUCT = tempSplit[1];
                int AMOUNT = Integer.parseInt(tempSplit[2].substring(1));
                double PRICE = Double.parseDouble(tempSplit[3]);

                boolean compareIdUser = ID.equals(Integer.toString(idUser));
                boolean compareProductName = PRODUCT.equals(product.getProductName() + toppingAdd);
                if (compareIdUser && compareProductName) {
                    tempOrder += ID + "|" + PRODUCT + "|" + "x" + (amount + AMOUNT) + "|" + (PRICE + price) + "|"
                            + product.getProductId() + "\n";
                    found = true;
                } else {
                    tempOrder += tempS + "\n";
                }
            }

            fw = new FileWriter(fileOrder, false);
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

    /**
     * Method สำหรับลบข้อมูลOrder
     * 
     * @param idUser                idที่จะลบ
     * @param nameProductAndTopping ชื่อProduct+toppingที่จะลบ
     * @param minusAmount           จำนวนที่จะลบ
     */
    public void removeOrder(int idUser, String nameProductAndTopping, int minusAmount) {
        try {
            String tempS;
            String tempOrder = "";
            fr = new FileReader(fileOrder);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[|]");
                // [0]ID [1]PRODUCT [2]AMOUNT [3]PRICE [4]ID_PRODUCT
                String ID = tempSplit[0];
                int intID = Integer.parseInt(tempSplit[0]);
                String PRODUCT = tempSplit[1];
                int AMOUNT = Integer.parseInt(tempSplit[2].substring(1));
                double PRICE = Double.parseDouble(tempSplit[3]);
                String ID_PRODUCT = tempSplit[4];

                if (nameProductAndTopping.equals(PRODUCT) && idUser == intID) {
                    if ((AMOUNT - minusAmount) > 0) {
                        tempOrder += ID + "|" + PRODUCT + "|" + "x" + (AMOUNT - minusAmount) + "|" 
                        + ((PRICE) - ((PRICE / (double)AMOUNT)* minusAmount))
                                + "|" + ID_PRODUCT + "\n";
                    }
                } else {
                    tempOrder += tempS + "\n";
                }
            }

            fw = new FileWriter(fileOrder, false);
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

    /**
     * Method สำหรับการดึงค่าOrderจากในไฟล์Order.csv โดยเทียบกับค่า Id
     * 
     * @param id รหัสผู้ใช้ที่จะดึงOrder
     * @return Arraylist<Order>ของผู้ใช้นั้นๆ
     */
    public ArrayList<String> getOrder(int id) {
        Order.clear();
        try {
            String tempS;
            fr = new FileReader(fileOrder);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[|]");
                // [0]ID [1]PRODUCT [2]AMOUNT [3]PRICE [4]ID_PRODUCT
                String ID = tempSplit[0];

                if (ID.equals(Integer.toString(id))) {
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

    /**
     * Method สำหรับการจัดเรียงข้อมูลOrderใน Order.csv
     */
    public void sortFileOrder() {
        try {
            String tempS;
            String tempOrder = "";
            ArrayList<String> Order = new ArrayList<>();
            fr = new FileReader(fileOrder);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                Order.add(tempS);
            }
            Order.sort((a, b) -> {
                String[] tempA = a.split("[|]");
                String[] tempB = b.split("[|]");
                return tempA[1].compareTo(tempB[1]);//เทียบ สินค้าในOrder
            });
            for (String string : Order) {
                tempOrder += string + "\n";
            }
            fw = new FileWriter(fileOrder, false);
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

    /**
     * Method สำหรับการดึงค่าOrderจากในไฟล์Order.csv
     * 
     * @return Arraylist<Order>ของผู้ใช้ทั้งหมด
     */
    public ArrayList<String> getOrderAll() {
        Order.clear();
        try {
            String tempS;
            fr = new FileReader(fileOrder);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                Order.add(tempS);
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

    /**
     * Method สำหรับการเพิ่มProductในไฟล์Food.csv or Drink.csv
     * 
     * @param product     สินค้าที่จะเพิ่ม
     * @param productEnum ประเภทสินค้า
     */
    public void addCatalogProduct(Product product, ProductEnum productEnum) {
        if (product != null) {
            products.add(product);
        }
        checkRep();

        File file = null;
        if (productEnum == ProductEnum.FOOD) {
            file = fileFood;
        } else if (productEnum == ProductEnum.DRINK) {
            file = fileDrink;
        }
        Boolean error = false;
        try {
            String tempS;
            Boolean found = false;
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[|]");
                String idProduct = tempSplit[1];
                if (idProduct.equals(product.getProductId())) {
                    found = true;
                    break;
                }
            }
            fw = new FileWriter(file, true);
            bw = new BufferedWriter(fw);
            if (!found) {
                bw.write(product.toString() + "\n");
            } else {
                error = true;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                br.close();
                fr.close();
                bw.close();
                fw.close();
                sortFileFoodDrink(productEnum);// เปลี่ยนทีหลัง
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (error) {
            throw new RuntimeException("Product " + product.getProductId() + " is same");
        }
    }

    /**
     * Method สำหรับการลบสินค้า ใน Food.csv or Drink.csv
     * 
     * @param product สินค่าที่จะลบ
     */
    public void removeCatalogProduct(Product product) {
        try {
            String tempS;
            String tempProduct = "";
            File file = null;
            if (product.getProductId().charAt(0) == 'F') {
                file = fileFood;
            } else if (product.getProductId().charAt(0) == 'D') {
                file = fileDrink;
            }
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                if (product.toString().equals(tempS)) {// ลบไฟล์ภาพทิ้ง
                    if (product.getProductId().charAt(0) == 'F') {
                        File tempfile = new File("./GUI/Picture/Food/" + product.getProductId() + ".jpg");
                        tempfile.delete();
                    } else if (product.getProductId().charAt(0) == 'D') {
                        File tempfile = new File("./GUI/Picture/Drink/" + product.getProductId() + ".jpg");
                        tempfile.delete();
                    }
                } else {
                    tempProduct += tempS + "\n";
                }
            }
            fw = new FileWriter(file, false); // เซ็ตว่าให้ลบข้อมูลห้องที่ตรง
            bw = new BufferedWriter(fw);
            bw.write(tempProduct);
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                br.close();
                fr.close();
                bw.close();
                fw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Method สำหรับการหาว่ามี ID ไหนบ้าง
     * 
     * @param productEnum ประเภทสินค้าที่จะหาIDที่ว่าง
     * @return IDที่ว่าง
     */
    public String searchIdAvailable(ProductEnum productEnum) {
        sortFileFoodDrink(productEnum);
        File file = null;
        if (productEnum == ProductEnum.FOOD) {
            file = fileFood;
        } else if (productEnum == ProductEnum.DRINK) {
            file = fileDrink;
        }
        int idAvailable = 0;
        try {
            String tempS;
            int tempIntPrevious = 1;
            Boolean found = false;
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[|]");
                int idProduct = Integer.parseInt(tempSplit[1].substring(1));
                if (idProduct > tempIntPrevious + 1) {// ถ้ามันมีเลขห่างจะทำการไปแทรกตรงนั้น
                    found = true;
                    idAvailable = tempIntPrevious + 1;
                    break;
                }
                tempIntPrevious = idProduct;
            }
            if (!found) {
                idAvailable = tempIntPrevious + 1;
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
        return Integer.toString(idAvailable);
    }

    /**
     * Method สำหรับการเรียงข้อมูลในไฟล์ Food.csv or Drink.csv
     * 
     * @param productEnum เลือกประเภทสินค้า
     */
    public void sortFileFoodDrink(ProductEnum productEnum) {
        File file = null;
        if (productEnum == ProductEnum.FOOD) {
            file = fileFood;
        } else if (productEnum == ProductEnum.DRINK) {
            file = fileDrink;
        }

        try {
            String tempS;
            String tempIdRoom = "";
            ArrayList<String> arrayRoom = new ArrayList<>();
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                arrayRoom.add(tempS);
            }
            arrayRoom.sort((a, b) -> {
                String[] tempA = a.split("[|]");
                String[] tempB = b.split("[|]");
                return Integer.compare(Integer.parseInt(tempA[1].substring(1)),
                        Integer.parseInt(tempB[1].substring(1)));//เทียบID product
            });
            for (String string : arrayRoom) {
                tempIdRoom += string + "\n";
            }
            fw = new FileWriter(file, false);
            bw = new BufferedWriter(fw);
            bw.write(tempIdRoom);
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

    /**
     * Method ดึงค่าสินค้าทั้งหมดใน Food.csv and Drink.csv
     * 
     * @return Arraylist<Product> สินค้าทั้งหมดในไฟล์
     */
    public ArrayList<Product> getAllProducts() {
        ArrayList<Product> tempProducts = new ArrayList<>();
        sortFileFoodDrink(ProductEnum.FOOD);
        sortFileFoodDrink(ProductEnum.DRINK);
        try {
            String tempS;
            fr = new FileReader(fileFood);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[|]");
                String nameProduct = tempSplit[0];
                String idProduct = tempSplit[1];
                double price = Double.parseDouble(tempSplit[2]);
                Product product = new Product(idProduct, nameProduct, price);
                tempProducts.add(product);
            }
            fr = new FileReader(fileDrink);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[|]");
                String nameProduct = tempSplit[0];
                String idProduct = tempSplit[1];
                double price = Double.parseDouble(tempSplit[2]);
                Product product = new Product(idProduct, nameProduct, price);
                tempProducts.add(product);
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        return tempProducts;
    }

    /**
     * Method เพิ่มส่วนเสริม
     * 
     * @param toping  ส่วนเสริม
     * @param topping ประเภทของส่วนเสริม
     */
    public void addtopping(ToppingEnum toping, toppings topping) {
        if (toppingFood != null) {
            if (toping == ToppingEnum.FOOD) {
                toppingFood.add(topping);
            } else if (toping == ToppingEnum.DRINK) {
                toppingDrink.add(topping);
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
