package GUI;

import javax.swing.*;

import lib.*;
import lib.loginregister.*;

import java.awt.*;

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
    private menufood food;
    private TOPUP topup;

    public Mainframe() {
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
        food = new menufood(this);
        topup = new TOPUP(this);

        // ใส่ panel ต่าง ๆ
        container.add(login, "login");
        container.add(Book, "book");
        container.add(mybooking, "mybooking");
        container.add(signUp, "signup");
        container.add(drink, "menudrink");
        container.add(food, "menufood");
        container.add(topup, "topup");

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
        //Book.initComponents();
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

    public static void main(String[] args) {
        new Mainframe();
    }
}
