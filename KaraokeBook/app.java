import java.time.*;
import java.util.*;

import lib.*;


public class app {
    public static void main(String[] args) {
        RoomSystem system = new RoomSystem();
        Room room1 = new Room("1-5", 101, 150);
        User user1 = new User(1);
        system.addBookRoom(room1, user1, LocalDateTime.of(2025, 10, 1, 12, 0, 0), LocalDateTime.of(2025, 10, 1, 13, 0, 0));
        system.addBookRoom(room1, user1, LocalDateTime.of(2025, 10, 1, 12, 0, 0), LocalDateTime.of(2025, 10, 1, 14, 0, 0));
        system.addBookRoom(room1, user1, LocalDateTime.of(2025, 10, 1, 12, 0, 0), LocalDateTime.of(2025, 10, 1, 15, 0, 0));
        system.removeBookRoom(room1, user1, LocalDateTime.of(2025, 10, 1, 12, 0, 0), LocalDateTime.of(2025, 10, 1, 15, 0, 0));
    }
}

