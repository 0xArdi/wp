package mk.ukim.finki.wp.consultations.service.impl;

import mk.ukim.finki.wp.consultations.model.ConsultationSlot;
import mk.ukim.finki.wp.consultations.model.Professor;
import mk.ukim.finki.wp.consultations.model.Room;
import mk.ukim.finki.wp.consultations.model.exceptions.InvalidConsultationSlotId;
import mk.ukim.finki.wp.consultations.model.exceptions.InvalidProfessorId;
import mk.ukim.finki.wp.consultations.model.exceptions.InvalidRoomName;
import mk.ukim.finki.wp.consultations.model.vm.Page;
import mk.ukim.finki.wp.consultations.repository.ConsultationSlotRepository;
import mk.ukim.finki.wp.consultations.repository.ProfessorRepository;
import mk.ukim.finki.wp.consultations.repository.RoomRepository;
import mk.ukim.finki.wp.consultations.service.ConsultationSlotService;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class ConsultationSlotServiceImpl implements ConsultationSlotService {

    private final ConsultationSlotRepository consultationSlotRepository;

    private final ProfessorRepository professorRepository;

    private final RoomRepository roomRepository;

    public ConsultationSlotServiceImpl(ConsultationSlotRepository consultationSlotRepository,
                                       ProfessorRepository professorRepository,
                                       RoomRepository roomRepository) {
        this.consultationSlotRepository = consultationSlotRepository;
        this.professorRepository = professorRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public ConsultationSlot createSlot(String professorId, String roomName, DayOfWeek dayOfWeek, LocalDate date, LocalTime from, LocalTime to) {
        if (dayOfWeek == null && date == null) {
            throw new IllegalArgumentException();
        }
        ConsultationSlot slot;
        Professor professor = this.professorRepository.findById(professorId).orElseThrow(InvalidProfessorId::new);
        Room room = this.roomRepository.findById(roomName).orElseThrow(InvalidRoomName::new);
        if (dayOfWeek != null) {
            slot = ConsultationSlot.createRecurringSlot(professor, room, dayOfWeek, from, to);
        } else {
            slot = ConsultationSlot.createOneTimeSlot(professor, room, date, from, to);
        }
        return this.consultationSlotRepository.save(slot);
    }

    @Override
    public Page<ConsultationSlot> getAllConsultationSlots(int page, int size) {
        return this.consultationSlotRepository.getAllConsultationSlots(page, size);
    }

    @Override
    public List<ConsultationSlot> searchConsultationSlots(String term) {
        return this.consultationSlotRepository.searchConsultationSlots(term);
    }

    @Override
    public ConsultationSlot updateSlot(int slotId, String professorId, String roomName, DayOfWeek dayOfWeek, LocalDate date, LocalTime from, LocalTime to) {
        ConsultationSlot slot = this.consultationSlotRepository.findById(slotId).orElseThrow(InvalidConsultationSlotId::new);
        Professor professor = this.professorRepository.findById(professorId).orElseThrow(InvalidProfessorId::new);
        Room room = this.roomRepository.findById(roomName).orElseThrow(InvalidRoomName::new);
        slot.setProfessor(professor);
        slot.setRoom(room);
        slot.setDayOfWeek(dayOfWeek);
        slot.setDate(date);
        slot.setFrom(from);
        slot.setTo(to);
        return this.consultationSlotRepository.save(slot);
    }

    @Override
    public void deleteSlot(int slotId) {
        this.consultationSlotRepository.deleteById(slotId);
    }
}
