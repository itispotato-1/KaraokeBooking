package lib;
import lib.loginregister.*;

import java.time.*;
import java.time.format.DateTimeFormatter;

/**
 * ADI ค่าที่เปลี่ยนแปลงได้ (Mutable) ห้องคาราโอเกะ+เวลาของห้องนั้นๆ
 */
public class RoomTime {
    private final Room room;
    private final LocalDateTime timeStart;
    private final LocalDateTime timeEnd;
    private final User user;
    //Rep Invariant (RI)
    //  - room is not null
    //  - timeStart >= 00:00 && timeStart <= 24:00 && นาทีต้องเป็น 0
    //Abstract Function (AF):
    //  - RoomList(Room room, LocalTime localTime) ใส่ห้องและเวลาของห้องนั้น

    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */
    private void checkRep(){
        if(room == null){
            throw new RuntimeException("RI violated: Room cannot be null.");
        }
    }

    /**
     * ตั้งค่าห้องคาราโอเกะ
     * @param room 
     * @param timeStart
     */
    public RoomTime(Room room,User user ,LocalDateTime timeStart,LocalDateTime timeEnd){
        this.room = room;
        this.timeStart = timeStart;
        this.timeEnd = timeEnd;
        this.user = user;
        checkRep();
    }

    /**
     * @return ห้องคาราโอเกะ
     */
    public Room getRoom() {
        return room;
    }

    /**
     * @return เวลาของห้องนั้นๆ
     */
    public LocalDateTime getTimeStart() {
        return timeStart;
    }
    public LocalDateTime getTimeEnd() {
        return timeEnd;
    }
    public User getUser() {
        return user;
    }

    @Override
    public String toString(){
        return room.getIdRoom()+"("+user.getUserId()+")"+//แก้
        timeStart.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))
        +";"+(timeEnd.format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss"))+";"
        +room.getPrice());
        //IdRoom(UserId)01-10-2025 12:00:00;01-10-2025 15:00:00;price
    }


}
