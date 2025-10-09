package GUI;

import javax.swing.*;

import lib.BookRoom.Room;
import lib.BookRoom.RoomSystem;
import lib.loginregister.*;
import store.Product;
import store.ProductCatalog;
import store.Topping;
import store.toppings;

import java.awt.*;
import java.time.LocalDate;

public class Mainframe extends JFrame {
    private CardLayout cardLayout;
    private JPanel container;
    private User user = new User("", "", "");
    private RoomSystem system;

    private int hourStart = 13;
    private int hourEnd = 4;
    private int minuteStartEnd = 00;
    private int userId;

    private book Book;
    private Login login;
    private Mybooking mybooking;
    private SignUp signUp;
    private menudrink drink;
    private menufood menufood;
    private TOPUP topup;

    private LoginRegisterService service;
    private ProductCatalog catalog;

    public Mainframe() {
        service = new LoginRegisterService();
        setUpLookAndFeel();

        Product fried_rice = new Product("F001", "fried rice", 40.0);
        Product Holy_basil_rice = new Product("F002", "Holy basil rice", 50.0);
        Product Noodles = new Product("F003", "Noodles", 40.0);
        Product garlicPepperPork = new Product("F004", "Garlic Pepper Pork", 40.0);
        Product omelet = new Product("F006", "Omelet", 40.0);
        Product radNa = new Product("F007", "RadNa", 40.0);
        Product chickenRice = new Product("F008", "ChickenRice", 40.0);
        
        Product coffee = new Product("D001", "Coffee", 35.0);
        Product greenTea = new Product("D002", "GreenTea", 35.0);
        Product Cocoa = new Product("D003", "Cocoa", 35.0);
        Product espresso = new Product("D004", "Espresso", 35.0);
        Product americano = new Product("D005", "Americano", 40.0);

        catalog = new ProductCatalog();
        catalog.addProduct(fried_rice);
        catalog.addProduct(Holy_basil_rice);
        catalog.addProduct(Noodles);
        catalog.addProduct(garlicPepperPork);
        catalog.addProduct(omelet);
        catalog.addProduct(radNa);
        catalog.addProduct(chickenRice);
        
        catalog.addProduct(coffee);
        catalog.addProduct(greenTea);
        catalog.addProduct(Cocoa);
        catalog.addProduct(espresso);
        catalog.addProduct(americano);


        toppings rice = new toppings("Rice", 10.0);
        toppings food = new toppings("Food", 20.0);

        toppings hot = new toppings("HOT", 0.0);
        toppings ice = new toppings("ICE", 10.0);
        toppings mix = new toppings("MIX", 20.0);

        catalog.addtopping(Topping.FOOD, rice);
        catalog.addtopping(Topping.FOOD, food);

        catalog.addtopping(Topping.DRINK, hot);
        catalog.addtopping(Topping.DRINK, ice);
        catalog.addtopping(Topping.DRINK, mix);

        system = new RoomSystem();
        for (int i = 0; i < 10; i++) {
            Room a = new Room("1-5", 301 + i, 150);
            system.addRoom(a);
        }
        system.addRoom(new Room("5+", 201, 200));

        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);
        login = new Login(this);
        Book = new book(this);
        mybooking = new Mybooking(this);
        signUp = new SignUp(this);
        drink = new menudrink(this);
        menufood = new menufood(this);
        topup = new TOPUP(this);

        // ใส่ panel ต่าง ๆ
        container.add(login, "login");
        container.add(Book, "book");
        container.add(mybooking, "mybooking");
        container.add(signUp, "signup");
        container.add(drink, "menudrink");
        container.add(menufood, "menufood");
        container.add(topup, "topup");
        container.add(new test(this), "test");

        add(container);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(new Dimension(440, 664));
        setLocationRelativeTo(null);

        showPanel("login");
        setVisible(true);
    }

    // เมธอดใช้สลับหน้า
    public void showPanel(String name) {
        system.ClearRoomTimeBeforeDate(LocalDate.now());
        if (name.equals("book")) {
            Book.reGUI();
        } else if (name.equals("mybooking")) {
            mybooking.reGUI();
        }

        cardLayout.show(container, name);
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public RoomSystem getSystem() {
        return system;
    }

    public int getHourStart() {
        return hourStart;
    }

    public int getHourEnd() {
        return hourEnd;
    }

    public int getMinuteStartEnd() {
        return minuteStartEnd;
    }

    public ProductCatalog getCatalog() {
        return catalog;
    }

    public LoginRegisterService getService() {
        return service;
    }

    private void setUpLookAndFeel() {
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ex) {
            java.util.logging.Logger.getLogger(Mainframe.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        UIManager.put("RootPane.contentMargins", new Insets(0, 0, 0, 0));
        UIManager.put("Panel.contentMargins", new Insets(0, 0, 0, 0));
        UIManager.put("Panel.background", java.awt.Color.WHITE);
    }

    public static void main(String[] args) {
        new Mainframe();
    }

}
