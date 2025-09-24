package lib.loginregister;
import java.io.*;

public class LoginRegisterService {
    private static final String FILE_NAME = "./file/UserList.csv";
    public boolean checkCredentials(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file");
        }
        return false;
    }

    public boolean isUsernameExists(String username) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 1 && parts[0].equals(username)) {
                    return true;
                }
            }
        } catch (IOException e) {
            // ไฟล์อาจยังไม่ถูกสร้าง ถือว่าไม่มีบัญชี
        }
        return false;
    }

   public boolean registerAccount(String username, String password, String phoneNumber) {
    if (isUsernameExists(username)) {
        return false;
    }
    try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
        writer.write(username + "," + password + "," + phoneNumber + ",0\n");
        return true;
    } catch (IOException e) {
        System.out.println("Error writing to file");
    }
    return false;
    }
}