package mk.ukim.finki.wp.consultations.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;


@Data
public class ConsultationSlot {

    private ConsultationSlot() {

    }

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private static int slotsCounter = 1;

    private int slotId;

    private Professor professor;

    private Room room;

    private LocalDate date;

    private DayOfWeek dayOfWeek;

    private LocalTime from;

    private LocalTime to;


    public static synchronized ConsultationSlot createRecurringSlot(Professor professor, Room room, DayOfWeek dayOfWeek, LocalTime from, LocalTime to) {
        ConsultationSlot slot = new ConsultationSlot();
        slot.slotId = slotsCounter;
        slotsCounter++;
        slot.professor = professor;
        slot.room = room;
        slot.dayOfWeek = dayOfWeek;
        slot.from = from;
        slot.to = to;
        return slot;
    }

    public static synchronized ConsultationSlot createOneTimeSlot(Professor professor, Room room, LocalDate date, LocalTime from, LocalTime to) {
        ConsultationSlot slot = new ConsultationSlot();
        slot.slotId = slotsCounter;
        slotsCounter++;
        slot.professor = professor;
        slot.room = room;
        slot.date = date;
        slot.from = from;
        slot.to = to;
        return slot;
    }

}
