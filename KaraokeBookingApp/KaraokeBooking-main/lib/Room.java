package lib;

/**
 *  ADT ค่าที่เปลี่ยนแปลงไม่ได้ (Immutable) ห้องคาราโอเกะที่มี
 */ 
public class Room {
    private final String nameRoom;
    private final int idRoom;
    private final double price;
    //Rep Invariant (RI)
    //  - nameRoom is not null && not blank
    //  - idRoom > 0
    //Abstact Function (AF):
    //  - AF(String nameRoom,int idRoom) สำหรับการตั้งค่าว่าห้องชิ่ออะไร,เลขห้องเท่าไหร่

    /**
     * ตรวจสอบว่า Rep Invariant เป็นจริงหรือไม่
     */
    private void checkRep(){
        if(nameRoom.isBlank()|| nameRoom == null){
            throw new RuntimeException("RI violated: nameRoom is Blank or null");
        }
        if(idRoom <= 0){
            throw new RuntimeException("RI violated: id must be id > 0");
        }
    }

    /**
     * เซ็ตค่าห้องคาราโอเกะ
     * @param nameRoom ชื่อห้อง
     * @param idRoom เลขห้อง
     * @throws IllegalArgumentException หากคุณสมบัติของห้องไม่ถูกต้อง
     */
    public Room(String nameRoom,int idRoom,double price){
        this.nameRoom = nameRoom;
        this.idRoom = idRoom;
        this.price = price;
        checkRep(); 
    }

    /**
     * @return เลขห้อง
     */
    public int getIdRoom() {
        return idRoom;
    }

    /**
     * @return ชื่อห้อง
     */
    public String getNameRoom() {
        return nameRoom;
    }
    public double getPrice() {
        return price;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Room room = (Room) obj;
        return idRoom == room.idRoom;
    }
    @Override
    public String toString(){
        return getNameRoom()+" "+getIdRoom()+" "+getPrice();
    }
}
