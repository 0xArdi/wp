package mk.ukim.finki.wp.consultations.service.impl;

import mk.ukim.finki.wp.consultations.model.Building;
import mk.ukim.finki.wp.consultations.model.Room;
import mk.ukim.finki.wp.consultations.model.exceptions.InvalidRoomName;
import mk.ukim.finki.wp.consultations.repository.RoomRepository;
import mk.ukim.finki.wp.consultations.service.RoomService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {

    private final RoomRepository roomRepository;

    public RoomServiceImpl(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    @Override
    public Room createRoom(String name, Building building, String description) {
        Room room = new Room(name, building, description);
        return this.roomRepository.save(room);
    }

    @Override
    public List<Room> getAllRooms() {
        return this.roomRepository.findAll();
    }

    @Override
    public List<Room> searchRooms(String term) {
        return this.roomRepository.searchRooms(term);
    }

    @Override
    public Room updateRoom(String oldName, String name, Building building, String description) {
        Room room = this.roomRepository.findById(oldName).orElseThrow(InvalidRoomName::new);
        room.setName(name);
        room.setBuilding(building);
        room.setDescription(description);
        return this.roomRepository.save(room);
    }

    @Override
    public void deleteRoom(String name) {
        this.roomRepository.deleteById(name);
    }
}
