package lib.BookRoom;
import lib.loginregister.*;

import java.io.*;
import java.time.*;
import java.util.*;

/**
 * ระบบการใช้งานการจอง
 */
public class RoomSystem {
    private File fileRoomList = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    private ArrayList<Room> rooms = new ArrayList<>();
    

    public RoomSystem() {
        fileRoomList = new File("./file/RoomTimes.csv");
        
    }

    /**
     * Method สำหรับลบข้อมูลห้องเก่าที่ผ่านไปแล้วของวันก่อนหน้า
     * @param dateNow วันที่ที่จะกำหนดเป็นปัจจุบันในการลบ
     */
    public void ClearRoomTimeBeforeDate(LocalDate dateNow){
          try {
            String tempS;
            String tempRoomTimes = "";
            fr = new FileReader(fileRoomList);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[;\\-\\:\\)\\(\\s]");
                //[0]101 [1]1 [2]01 [3]10 [4]2025 [5]12 [6]00 [7]00 [8]01 [9]10 [10]2025 [11]13 [12]00 [13]00 [14]150.0
                if(!(dateNow.isAfter(LocalDate.of(Integer.parseInt(tempSplit[4]),Integer.parseInt(tempSplit[3]),Integer.parseInt(tempSplit[2]))))){ 
                    tempRoomTimes += tempS+"\n";
                }
            }
            fw = new FileWriter(fileRoomList,false); //เซ็ตว่าให้ลบข้อมูลห้องที่ตรง
            bw = new BufferedWriter(fw);
            bw.write(tempRoomTimes);
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
     * Method สำหรับการเพิ่มข้อมูลห้องที่จะให้จอง
     * @param room
     */
    public void addRoom(Room room){
        rooms.add(room);
        Collections.sort(rooms,(r1, r2) -> Integer.compare(r1.getIdRoom(),r2.getIdRoom()));
    }
    /**
     * Method สำหรับการดึงข้อมูลห้อง
     * @return Arrayข้อมูลห้อง
     */
    public ArrayList<Room> getRooms(){
        return rooms;
    }
    /**
     * Method สำหรับการจองห้อง
     * @param room  ใส่ห้องที่จะจอง
     * @param user  ใส่ข้อมูลผู้ใช้
     * @param start เวลาที่เริ่มจอง
     * @param end   เวลาที่จบ
     * @throws Exception ถ้าห้องที่เพิ่มเคยเพิ่มมาแล้ว
     */
    public void addBookRoom(Room room, User user, LocalDateTime start, LocalDateTime end) throws Exception{
        //ต้องเช็กด้วยว่ามีค่านั้นไหม
        if(checkLocalDateTimeIsSame(room, start,end)){
            throw new Exception("This room has already been reserved.");
        }
        if(LocalDateTime.now().isAfter(start)){
            throw new Exception("The room at that time was no longer available.");
        }
        try {
            fw = new FileWriter(fileRoomList, true);
            bw = new BufferedWriter(fw);
            bw.write(new RoomTime(room, user, start, end).toString() + "\n"); // เขียนไฟล์ในRoomTimes.csv
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bw.close();
                fw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    /**
     * Method สำหรับการลบข้อมูลการจอง
     * 
     * @param room  ใส่ห้องที่จะจอง
     * @param user  ใส่ข้อมูลผู้ใช้
     * @param start เวลาที่เริ่มจอง
     * @param end   เวลาที่จบ
     */
    public void removeBookRoom(Room room, User user, LocalDateTime start, LocalDateTime end) {
        try {
            String tempS;
            String tempRoomTimes = "";
            RoomTime roomCheck = new RoomTime(room, user, start, end);
            fr = new FileReader(fileRoomList);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                if(!(roomCheck.toString().equals(tempS))){ 
                    tempRoomTimes += tempS+"\n";
                }
            }
            fw = new FileWriter(fileRoomList,false); //เซ็ตว่าให้ลบข้อมูลห้องที่ตรง
            bw = new BufferedWriter(fw);
            bw.write(tempRoomTimes);
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
     * Method ในการคำนวณว่าผู้ใช้คนนั้นๆต้องจ่ายเงินเท่าไหร่
     * 
     * @return ผลรวมทั้งหมด
     */
    public double CalculatorRoom(User user) {
        double sum = 0;
        try {
            String tempS;
            fr = new FileReader(fileRoomList);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[;\\-\\:\\)\\(\\s]");
                //[0]101 [1]1 [2]01 [3]10 [4]2025 [5]12 [6]00 [7]00 [8]01 [9]10 [10]2025 [11]13 [12]00 [13]00 [14]150.0
                sum = sum + Double.parseDouble(tempSplit[14]);//เลือกแค่Price
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
        return sum;
    }

    /**
     * Method สำหรับการเช็กว่าเป็นห้องเดียวกันไหม
     * @param room ห้องที่จอง
     * @param timeStart เวลาที่เริ่มจอง
     * @param timeEnd เวลาที่หมดการจองช่วงนั้น
     * @return true ถ้ามีข้อมูลนั้น, false ถ้าไม่มีข้อมูลนั้น
     */
    public boolean checkLocalDateTimeIsSame(Room room,LocalDateTime timeStart,LocalDateTime timeEnd) {
        boolean tempBool = false;
        try {
            String tempS;
            fr = new FileReader(fileRoomList);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[;\\-\\:\\)\\(\\s]");
                //[0]101 [1]1 [2]01 [3]10 [4]2025 [5]12 [6]00 [7]00 [8]01 [9]10 [10]2025 [11]13 [12]00 [13]00 [14]150.0
                LocalDateTime tempDateTimeStart = LocalDateTime.of(Integer.parseInt(tempSplit[4]), Integer.parseInt(tempSplit[3]), Integer.parseInt(tempSplit[2]), Integer.parseInt(tempSplit[5]), Integer.parseInt(tempSplit[6]));
                LocalDateTime tempDateTimeEnd = LocalDateTime.of(Integer.parseInt(tempSplit[10]), Integer.parseInt(tempSplit[9]), Integer.parseInt(tempSplit[8]), Integer.parseInt(tempSplit[11]), Integer.parseInt(tempSplit[12]));
                if(room.getIdRoom() == Integer.parseInt(tempSplit[0]) && tempDateTimeStart.equals(timeStart) && tempDateTimeEnd.equals(timeEnd)){
                    tempBool = true;
                }
                // if( ( (String.valueOf(room.getIdRoom()))+" "+(String.valueOf(timeStart.getDayOfMonth()))+"-"+(String.valueOf(timeStart.getMonthValue()))+"-"+String.valueOf(timeStart.getYear())+ " "+String.valueOf() ).equals(timeEnd) )
                // if((String.valueOf(timeStart.getHour()).equals(tempSplit[5])) && room.getIdRoom() == Integer.parseInt(tempSplit[0]) ){ 
                //    tempBool = true;
                // }
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
        return tempBool;
    }
}
