package lib.loginregister;

import java.io.*;

public class LoginRegisterService {
    private static final String FILE_NAME = "./file/UserList.csv";
    private FileReader fr = null;
    private BufferedReader br = null;
    private FileWriter fw = null;
    private BufferedWriter bw = null;

    /**
     * Method สำหรับการหา ID ที่อยู่ท้ายสุดเพื่อให้IDไม่ซ้ำกัน
     * @return Idที่อยู่ท้ายสุด
     */
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

    /**
     * Method สำหรับการเทียบข้อมูล id เพื่อดึงข้อมูลUser ออกมา
     * @param id ที่จะดึงเทียบข้อมูล
     * @return User ที่ข้อมูลตรงกับ id
     */
    public User getUser(int id){
        User user = null;
         try {
            String tempS;
            fr = new FileReader(FILE_NAME);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[,\\|]");
                int idUser = Integer.parseInt(tempSplit[0]);
                String nameUser = tempSplit[1];
                String passUser = tempSplit[2];
                String phoneUser = tempSplit[3];
                if(idUser == id){
                    user = new User(nameUser, passUser, phoneUser);
                    break;
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
        return user;
    }

    /**
     * Method สำหรับการเทียบชื่อและรหัสเพื่อดึงข้อมูลทั้งหมดของUserนั้นๆ
     * @param username ชื่อที่จะเทียบ
     * @param password รหัสผ่านที่จะเทียบ
     * @return ค่าไฟล์ที่เทียบกันแล้วตรงที่อ่านได้
     */
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

    /**
     * Method สำหรับเซ็ตข้อมูล เงิน จากUserเข้าไปในไฟล์
     * @param user ผู้ใช้ที่จะเซ็ตค่า
     */
    public void setMoneyUserInUserList(User user) {
        try {
            String tempS;
            String UserList = "";
            fr = new FileReader(FILE_NAME);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[,\\|]");
                if (tempSplit[1].equals(user.getUsername()) && tempSplit[2].equals(user.getPassword())) {
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

    /**
     * Method สำหรับการเช็กว่าชื่อและรหัสตรงกับข้อมูลใน UserList ไหม (ไว้เช็กตอนRegister)
     * @param username ชื่อข้อมูลที่จะเช็ก
     * @param password รหัสข้อมูลที่จะเช็ก
     * @return true ถ้าเจอข้อมูล, false ถ้าไม่เจอข้อมูล
     */
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

    /**
     * Method สำหรับการเช็กว่าชื่อตรงกับข้อมูลใน UserList ไหม (ไว้เช็กตอนRegister)
     * @param username ชื่อที่จะเช็ก
     * @return ถ้าเจอ true, ถ้าไม่ false
     */
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
            System.out.println(e);
            // ไฟล์อาจยังไม่ถูกสร้าง ถือว่าไม่มีบัญชี
        }
        return false;
    }

    /**
     * Method สำหรับการสมัครรหัสได้ไหม
     * @param username ชื่อที่จะสมัคร
     * @param password รหัสที่จะสมัคร
     * @param phoneNumber เบอร์โทรศัพท์ที่จะสมัคร
     * @return ถ้าสมัครสำเร็จ True, ถ้าไม่ false
     */
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