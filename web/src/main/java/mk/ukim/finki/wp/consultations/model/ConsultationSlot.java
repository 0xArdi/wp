package mk.ukim.finki.wp.consultations.model;

import lombok.Data;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;


@Data
public class ConsultationSlot {

    private ConsultationSlot() {

    }

    private Professor professor;

    private Room room;

    private LocalDate date;

    private DayOfWeek dayOfWeek;

    private LocalTime from;

    private LocalTime to;


    public static ConsultationSlot createRecurringSlot(Professor professor, Room room, DayOfWeek dayOfWeek, LocalTime from, LocalTime to) {
        ConsultationSlot slot = new ConsultationSlot();
        slot.professor = professor;
        slot.room = room;
        slot.dayOfWeek = dayOfWeek;
        slot.from = from;
        slot.to = to;
        return slot;
    }

    public static ConsultationSlot createOnTimeSlot(Professor professor, Room room, LocalDate date, LocalTime from, LocalTime to) {
        ConsultationSlot slot = new ConsultationSlot();
        slot.professor = professor;
        slot.room = room;
        slot.date = date;
        slot.from = from;
        slot.to = to;
        return slot;
    }

}
