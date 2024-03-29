package mk.ukim.finki.wp.consultations.repository;

import mk.ukim.finki.wp.consultations.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomRepository {

    Room save(Room room);

    List<Room> findAll();

    List<Room> searchRooms(String term);

    Optional<Room> findById(String name);

    void deleteById(String name);
}
