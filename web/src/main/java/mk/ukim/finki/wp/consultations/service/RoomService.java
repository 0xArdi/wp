package mk.ukim.finki.wp.consultations.service;

import mk.ukim.finki.wp.consultations.model.Building;
import mk.ukim.finki.wp.consultations.model.Room;

import java.util.List;

public interface RoomService {

    Room createRoom(String name, Building building, String description);

    List<Room> getAllRooms();

    List<Room> searchRooms(String term);

    Room updateRoom(String oldName, String name, Building building, String description);

    void deleteRoom(String name);


}
