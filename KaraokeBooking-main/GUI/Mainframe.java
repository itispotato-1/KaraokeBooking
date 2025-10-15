package GUI;

import javax.swing.*;

import lib.MoneySystem;
import lib.BookRoom.RoomSystem;
import lib.loginregister.*;
import lib.Shop.*;

import java.awt.*;
import java.time.LocalDate;

public class Mainframe extends JFrame {
    private CardLayout cardLayout;
    private JPanel container;
    private User user = new User("", "", "");

    private int hourStart = 13;
    private int hourEnd = 4;
    private int minuteStartEnd = 00;
    private int userId;

    private book Book;
    private Login login;
    private Mybooking mybooking;
    private SignUp signUp;
    private menudrink menudrink;
    private menufood menufood;
    private TOPUP topup;
    private MyOrder myOrder;
    private Admin_Book admin_Book;
    private Admin_AddAndRemove admin_AddAndRemove;
    private Admin_Order admin_Order;
    private Admin_Profit admin_Profit;

    private RoomSystem System;
    private LoginRegisterService service;
    private ProductSystem ProductSystem;
    private MoneySystem SystemMoney;

    public Mainframe() {
        service = new LoginRegisterService();
        ProductSystem = new ProductSystem();
        System = new RoomSystem();
        SystemMoney = new MoneySystem();

        setUpLookAndFeel();
        toppings rice = new toppings("Rice", 10.0);
        toppings food = new toppings("Food", 20.0);

        toppings hot = new toppings("HOT", 0.0);
        toppings ice = new toppings("ICE", 10.0);
        toppings mix = new toppings("MIX", 20.0);

        ProductSystem.addtopping(ToppingEnum.FOOD, rice);
        ProductSystem.addtopping(ToppingEnum.FOOD, food);

        ProductSystem.addtopping(ToppingEnum.DRINK, hot);
        ProductSystem.addtopping(ToppingEnum.DRINK, ice);
        ProductSystem.addtopping(ToppingEnum.DRINK, mix);

        cardLayout = new CardLayout();
        container = new JPanel(cardLayout);
        container.setBackground(Color.WHITE);

        login = new Login(this);
        Book = new book(this);
        mybooking = new Mybooking(this);
        signUp = new SignUp(this);
        menudrink = new menudrink(this);
        menufood = new menufood(this);
        topup = new TOPUP(this);
        myOrder = new MyOrder(this);
        admin_Book = new Admin_Book(this);
        admin_AddAndRemove = new Admin_AddAndRemove(this);
        admin_Order = new Admin_Order(this);
        admin_Profit = new Admin_Profit(this);

        // ใส่ panel ต่าง ๆ
        container.add(login, "login");
        container.add(Book, "book");
        container.add(mybooking, "mybooking");
        container.add(signUp, "signup");
        container.add(menudrink, "menudrink");
        container.add(menufood, "menufood");
        container.add(topup, "topup");
        container.add(myOrder, "myorder");
        container.add(admin_Book, "admin_Book");
        container.add(admin_AddAndRemove, "admin_AddAndRemove");
        container.add(admin_Book, "admin_Book");
        container.add(admin_Order, "admin_Order");
        container.add(admin_Profit, "admin_Profit");

        container.add(new test(this), "test");//ไว้ใช้test GUIก่อนลงจริง

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
        System.ClearRoomTimeBeforeDate(LocalDate.now());
        if (name.equals("book")) {
            Book.reGUI();
        } else if (name.equals("mybooking")) {
            mybooking.reGUI();
        } else if (name.equals("myorder")) {
            myOrder.reGUI();
        } else if (name.equals("admin_AddAndRemove")) {
            admin_AddAndRemove.reGUI();
        } else if (name.equals("admin_Book")) {
            admin_Book.reGUI();
        } else if (name.equals("menufood")) {
            menufood.reGUI();
        } else if (name.equals("menudrink")) {
            menudrink.reGUI();
        } else if (name.equals("admin_Order")) {
            admin_Order.reGUI();
        } else if(name.equals("admin_Profit")){
            admin_Profit.reGUI();
        }

        cardLayout.show(container, name);
    }

    public MoneySystem getSystemMoney() {
        return SystemMoney;
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
        return System;
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

    public ProductSystem getProductSystem() {
        return ProductSystem;
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
