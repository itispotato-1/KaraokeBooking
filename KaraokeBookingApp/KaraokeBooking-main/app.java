import java.awt.*;
import java.time.*;
import java.util.*;

import javax.swing.*;

import lib.*;

public class app extends JFrame{
    public app(){
        setResizable(false);
        setSize(new Dimension(390,664));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public static void main(String[] args) {
        //new app();
        RoomSystem system = new RoomSystem();
        Room room1 = new Room("1-5", 101, 150);
        User user1 = new User(1,150);
        try{
        system.addBookRoom(room1, user1, LocalDateTime.of(2025, 10, 1, 12, 0, 0),
        LocalDateTime.of(2025, 10, 1, 13, 0, 0));
        system.addBookRoom(room1, user1, LocalDateTime.of(2025, 8, 1, 12, 0, 0),
        LocalDateTime.of(2025, 10, 1, 14, 0, 0));
        system.addBookRoom(room1, user1, LocalDateTime.of(2025, 8, 1, 12, 0, 0),
        LocalDateTime.of(2025, 10, 1, 15, 0, 0));
        // system.removeBookRoom(room1, user1, LocalDateTime.of(2025, 10, 1, 12, 0, 0),
        // LocalDateTime.of(2025, 10, 1, 15, 0, 0));
        system.ClearRoomTimeBeforeDate(LocalDate.now());
        }catch(Exception e){ 
            System.out.println(e);
        }

    }
}
