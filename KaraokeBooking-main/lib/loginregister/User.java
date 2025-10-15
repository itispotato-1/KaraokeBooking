package lib.loginregister;

public class User {
    private final String username;
    private final String password;
    private final String phoneNumber;
    private double money = 0;
    private int userId;

    // Constructors
    public User(String username, String password, String phoneNumber) {
        LoginRegisterService service = new LoginRegisterService();
        String[] temp = service.getValueUserList(username, password);
        if (temp != null) {
            this.userId = Integer.parseInt(temp[0]);
        }// น่าจะลบ
        this.username = username;
        this.password = password;
        this.phoneNumber = phoneNumber;

    }

    /**
     * @return Username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * @return money
     */
    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

}