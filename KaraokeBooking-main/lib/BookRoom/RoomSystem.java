package lib.BookRoom;

import lib.loginregister.*;

import java.io.*;
import java.time.*;
import java.util.*;

/**
 * ระบบการใช้งานการจอง
 */
public class RoomSystem {
    private File fileRoomTime = null;
    private File fileRoom = null;
    private FileReader fr = null;
    private BufferedReader br = null;
    private FileWriter fw = null;
    private BufferedWriter bw = null;
    private ArrayList<Room> rooms = new ArrayList<>();

    public RoomSystem() {
        fileRoomTime = new File("./file/RoomTimes.csv");
        fileRoom = new File("./file/Room.csv");
    }

    /**
     * Method สำหรับลบข้อมูลห้องเก่าที่ผ่านไปแล้วของวันก่อนหน้า
     * 
     * @param dateNow วันที่ที่จะกำหนดเป็นปัจจุบันในการลบ
     */
    public void ClearRoomTimeBeforeDate(LocalDate dateNow) {
        try {
            String tempS;
            String tempRoomTimes = "";
            fr = new FileReader(fileRoomTime);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[;\\-\\:\\)\\(\\s]");
                // [0]101 [1]1 [2]01 [3]10 [4]2025 [5]12 [6]00 [7]00 [8]01 [9]10 [10]2025 [11]13
                // [12]00 [13]00 [14]150.0
                if (!(dateNow.isAfter(LocalDate.of(Integer.parseInt(tempSplit[4]), Integer.parseInt(tempSplit[3]),
                        Integer.parseInt(tempSplit[2]))))) {
                    tempRoomTimes += tempS + "\n";
                }
            }
            fw = new FileWriter(fileRoomTime, false); // เซ็ตว่าให้ลบข้อมูลห้องที่ตรง
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
     * 
     * @param room ห้องที่จะเพิ่ม
     */
    public void addRoom(Room room) throws Exception {
        Boolean error = false;
        try {
            String tempS;
            Boolean found = false;
            fr = new FileReader(fileRoom);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[ ]");
                int idRoom = Integer.parseInt(tempSplit[1]);
                if (idRoom == room.getIdRoom()) {
                    found = true;
                }
            }
            fw = new FileWriter(fileRoom, true);
            bw = new BufferedWriter(fw);
            if (!found) {
                bw.write(room.toString() + "\n");
            } else {
                error = true;
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                br.close();
                fr.close();
                bw.close();
                fw.close();
                sortFileRoom();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        if (error) {
            throw new Exception("Room " + room.getIdRoom() + " is same");
        }
    }

    /**
     * Method สำหรับการลบห้องจากไฟล์Room.csv
     * @param room ห้องที่จะลบ
     */
    public void removeRoom(Room room) {
        try {
            String tempS;
            String tempRoom = "";
            fr = new FileReader(fileRoom);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                if (!(tempS.equals(room.toString()))) {
                    tempRoom += tempS + "\n";
                }
            }
            fw = new FileWriter(fileRoom, false); // เซ็ตว่าให้ลบข้อมูลห้องที่ตรง
            bw = new BufferedWriter(fw);
            bw.write(tempRoom);
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
     * Method สำหรับการดึงข้อมูลห้อง
     * 
     * @return Arrayข้อมูลห้อง
     */
    public ArrayList<Room> getRooms() {
        rooms.clear();
        sortFileRoom();
        try {
            String tempS;
            fr = new FileReader(fileRoom);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[ ]");
                String roomFor = tempSplit[0];
                int idRoom = Integer.parseInt(tempSplit[1]);
                double roomCost = Double.parseDouble(tempSplit[2]);
                rooms.add(new Room(roomFor, idRoom, roomCost));
            }
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                br.close();
                fr.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
        return rooms;
    }

    /**
     * Method สำหรับการจองห้อง
     * 
     * @param room  ใส่ห้องที่จะจอง
     * @param user  ใส่ข้อมูลผู้ใช้
     * @param start เวลาที่เริ่มจอง
     * @param end   เวลาที่จบ
     * @throws Exception ถ้าห้องที่เพิ่มเคยเพิ่มมาแล้ว
     */
    public void addBookRoom(Room room, User user, LocalDateTime start, LocalDateTime end) throws Exception {
        // ต้องเช็กด้วยว่ามีค่านั้นไหม
        if (checkLocalDateTimeIsSame(room, start, end)) {
            throw new Exception("This room has already been reserved.");
        }
        if (LocalDateTime.now().isAfter(start)) {
            throw new Exception("The room at that time was no longer available.");
        }
        try {
            fw = new FileWriter(fileRoomTime, true);
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
            fr = new FileReader(fileRoomTime);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                if (!(roomCheck.toString().equals(tempS))) {
                    tempRoomTimes += tempS + "\n";
                }
            }
            fw = new FileWriter(fileRoomTime, false); // เซ็ตว่าให้ลบข้อมูลห้องที่ตรง
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
     * Method สำหรับการหาห้องที่จองตาม Userที่รับมา
     * @param user1 ผู้ใช้ที่ต้องการหาห้องที่จอง
     * @return Arraylist ห้องที่จองตามUserนั้นๆ
     */
    public ArrayList<RoomTime> getBookTime(User user1) {
        ArrayList<RoomTime> roomTimes = new ArrayList<>();
        try {
            String tempS;
            fr = new FileReader(fileRoomTime);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[;\\-\\:\\)\\(\\s]");
                // [0]101 [1]1 [2]01 [3]10 [4]2025 [5]12 [6]00 [7]00 [8]01 [9]10 [10]2025 [11]13
                // [12]00 [13]00 [14]150.0
                int idRoom = Integer.parseInt(tempSplit[0]);
                int idUser = Integer.parseInt(tempSplit[1]);
                int day = Integer.parseInt(tempSplit[2]);
                int month = Integer.parseInt(tempSplit[3]);
                int year = Integer.parseInt(tempSplit[4]);
                int hourStart = Integer.parseInt(tempSplit[5]);
                int minuteStart = Integer.parseInt(tempSplit[6]);
                int secondStart = Integer.parseInt(tempSplit[7]);
                int hourEnd = Integer.parseInt(tempSplit[11]);
                int minuteEnd = Integer.parseInt(tempSplit[12]);
                int secondEnd = Integer.parseInt(tempSplit[13]);
                double price = Double.parseDouble(tempSplit[14]);

                Room room = new Room("1", idRoom, price);
                User user = new LoginRegisterService().getUser(idUser);

                if (idUser == user1.getUserId()) {
                    LocalDateTime timeStart = LocalDateTime.of(year, month, day, hourStart, minuteStart, secondStart);
                    LocalDateTime timeEnd = LocalDateTime.of(year, month, day, hourEnd, minuteEnd, secondEnd);

                    RoomTime roomTime = new RoomTime(room, user, timeStart, timeEnd);

                    roomTimes.add(roomTime);
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
        return roomTimes;
    }

    /**
     * Method สำหรับการหาเวลาที่จองทั้งหมด
     * @return Arraylist ของเวลาที่จองทั้งหมด
     */
    public ArrayList<RoomTime> getBookTimeAll() {
        ArrayList<RoomTime> roomTimes = new ArrayList<>();
        try {
            String tempS;
            fr = new FileReader(fileRoomTime);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[;\\-\\:\\)\\(\\s]");
                // [0]101 [1]1 [2]01 [3]10 [4]2025 [5]12 [6]00 [7]00 [8]01 [9]10 [10]2025 [11]13
                // [12]00 [13]00 [14]150.0
                int idRoom = Integer.parseInt(tempSplit[0]);
                int idUser = Integer.parseInt(tempSplit[1]);
                int day = Integer.parseInt(tempSplit[2]);
                int month = Integer.parseInt(tempSplit[3]);
                int year = Integer.parseInt(tempSplit[4]);
                int hourStart = Integer.parseInt(tempSplit[5]);
                int minuteStart = Integer.parseInt(tempSplit[6]);
                int secondStart = Integer.parseInt(tempSplit[7]);
                int hourEnd = Integer.parseInt(tempSplit[11]);
                int minuteEnd = Integer.parseInt(tempSplit[12]);
                int secondEnd = Integer.parseInt(tempSplit[13]);
                double price = Double.parseDouble(tempSplit[14]);

                Room room = new Room("1", idRoom, price);
                User user = new LoginRegisterService().getUser(idUser);

                LocalDateTime timeStart = LocalDateTime.of(year, month, day, hourStart, minuteStart, secondStart);
                LocalDateTime timeEnd = LocalDateTime.of(year, month, day, hourEnd, minuteEnd, secondEnd);

                RoomTime roomTime = new RoomTime(room, user, timeStart, timeEnd);
                roomTimes.add(roomTime);
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
        return roomTimes;
    }

    /**
     * Method สำหรับการจัดเรียงข้อมูลในไฟล์Room.csv
     */
    public void sortFileRoom() {
        try {
            String tempS;
            String tempIdRoom = "";
            ArrayList<String> arrayRoom = new ArrayList<>();
            fr = new FileReader(fileRoom);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                arrayRoom.add(tempS);
            }
            arrayRoom.sort((a, b) -> {
                String[] tempA = a.split("[ ]");
                String[] tempB = b.split("[ ]");
                return Integer.compare(Integer.parseInt(tempA[1]), Integer.parseInt(tempB[1]));
            });
            for (String string : arrayRoom) {
                tempIdRoom += string + "\n";
            }
            fw = new FileWriter(fileRoom, false);
            bw = new BufferedWriter(fw);
            bw.write(tempIdRoom);
        } catch (Exception ex) {
            System.out.println(ex);
        } finally {
            try {
                br.close();
                fr.close();
                bw.close();
                fw.close();
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    /**
     * Method สำหรับการเช็กว่าเป็นห้องเดียวกันไหม
     * 
     * @param room      ห้องที่จอง
     * @param timeStart เวลาที่เริ่มจอง
     * @param timeEnd   เวลาที่หมดการจองช่วงนั้น
     * @return true ถ้ามีข้อมูลนั้น, false ถ้าไม่มีข้อมูลนั้น
     */
    public boolean checkLocalDateTimeIsSame(Room room, LocalDateTime timeStart, LocalDateTime timeEnd) {
        boolean tempBool = false;
        try {
            String tempS;
            fr = new FileReader(fileRoomTime);
            br = new BufferedReader(fr);
            while ((tempS = br.readLine()) != null) {
                String[] tempSplit = tempS.split("[;\\-\\:\\)\\(\\s]");
                // [0]101 [1]1 [2]01 [3]10 [4]2025 [5]12 [6]00 [7]00 [8]01 [9]10 [10]2025 [11]13
                // [12]00 [13]00 [14]150.0
                int idRoom = Integer.parseInt(tempSplit[0]);
                int day = Integer.parseInt(tempSplit[2]);
                int month = Integer.parseInt(tempSplit[3]);
                int year = Integer.parseInt(tempSplit[4]);
                int hourStart = Integer.parseInt(tempSplit[5]);
                int minuteStart = Integer.parseInt(tempSplit[6]);
                int hourEnd = Integer.parseInt(tempSplit[11]);
                int minuteEnd = Integer.parseInt(tempSplit[12]);

                LocalDateTime tempDateTimeStart = LocalDateTime.of(year,month, day, hourStart,minuteStart);
                LocalDateTime tempDateTimeEnd = LocalDateTime.of(year, month, day, hourEnd, minuteEnd);
                
                if (room.getIdRoom() == idRoom && tempDateTimeStart.equals(timeStart)
                        && tempDateTimeEnd.equals(timeEnd)) {
                    tempBool = true;
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
        return tempBool;
    }
}
