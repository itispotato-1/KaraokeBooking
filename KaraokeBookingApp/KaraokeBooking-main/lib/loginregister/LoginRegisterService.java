package lib.loginregister;

import java.io.*;

public class LoginRegisterService {
    private static final String FILE_NAME = "./file/UserList.csv";
    private FileReader fr = null;
    private BufferedReader br = null;
    private FileWriter fw = null;
    private BufferedWriter bw = null;

    public int getUserIdLast() {
        String tempS;
        int tempInt = 0;
        try {
            fr = new FileReader(FILE_NAME);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[,\\|]");
                    tempInt = Integer.parseInt(tempSplit[0]);
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
        return tempInt;
    }
    public String[] getValueUserList(String username, String password) {
        try {
            String tempS;
            fr = new FileReader(FILE_NAME);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[,\\|]");
                if (tempSplit[1].equals(username) && tempSplit[2].equals(password)) {
                    return tempSplit;
                }
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
        return null;
    }

    public void setMoneyUserInUserList(User user) {
        try {
            String tempS;
            String UserList = "";
            fr = new FileReader(FILE_NAME);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[,\\|]");
                //System.out.println(user.getUsername()+" "+tempSplit[1]);
                //System.out.println(user.getPassword()+" "+tempSplit[2]);
                if (tempSplit[1].equals(user.getUsername()) && tempSplit[2].equals(user.getPassword())) {
                   // System.out.println("check");
                    UserList += (tempSplit[0]+"|"+tempSplit[1]+","+tempSplit[2]+","+tempSplit[3]+","+user.getMoney()+"\n");
                } else {
                    UserList += tempS+"\n";
                }
            }
            fw = new FileWriter(FILE_NAME, false); // เซ็ตว่าให้ลบข้อมูลห้องที่ตรง
            bw = new BufferedWriter(fw);
            bw.write(UserList);
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

    public boolean checkUseramePassword(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("[,\\|]");
                if (parts[1].equals(username) && parts[2].equals(password)) {
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
                String[] parts = line.split("[,\\|]");
                if (parts.length >= 1 && parts[1].equals(username)) {
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
            writer.write((getUserIdLast()+1)+"|"+username + "," + password + "," + phoneNumber + ",0\n");//
            return true;
        } catch (IOException e) {
            System.out.println("Error writing to file");
        }
        return false;
    }
}