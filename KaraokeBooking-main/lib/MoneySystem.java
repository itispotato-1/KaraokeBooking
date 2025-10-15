package lib;

import java.io.*;

public class MoneySystem {
    File fileMoney = null;
    FileReader fr = null;
    BufferedReader br = null;
    FileWriter fw = null;
    BufferedWriter bw = null;

    public MoneySystem() {
        fileMoney = new File("./file/Money.csv");
    }

    /**
     * Method สำหรับเพิ่มข้อมูลเงินใน Money.csv
     * 
     * @param money เงินที่จะเพิ่มหรือลด
     */
    public void setProfit(double money) {
        try {
            double total;
            fr = new FileReader(fileMoney);
            br = new BufferedReader(fr);
            total = Double.parseDouble(br.readLine());
            total += money;

            fw = new FileWriter(fileMoney, false);
            bw = new BufferedWriter(fw);
            bw.write(Double.toString(total));
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bw.close();
                fw.close();
                br.close();
                fr.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    public double getProfit() {
        double total = 0;
        try {
            fr = new FileReader(fileMoney);
            br = new BufferedReader(fr);
            total = Double.parseDouble(br.readLine());
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
        return total;
    }
}
