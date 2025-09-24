package lib.loginregister;

public class User {
    private final String username;
    private final String password;
    private final String phoneNumber;
    private double money=0;
    private static int userId;

    // Constructors
    public User(String username, String password, String phoneNumber) {
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;

    }

    // Getters
    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static void plusUserId(){

    }
    public static int getUserId() {
        return userId;
    }
    public double getMoney() {
        return money;
    }
    public void setMoney(double money) {
        this.money = money;
    }

}