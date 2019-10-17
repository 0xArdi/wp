package mk.ukim.finki.wp.consultations.repository;

import mk.ukim.finki.wp.consultations.model.ConsultationSlot;
import mk.ukim.finki.wp.consultations.model.vm.Page;

import java.util.List;
import java.util.Optional;

public interface ConsultationSlotRepository {

    ConsultationSlot save(ConsultationSlot slot);

    Page<ConsultationSlot> getAllConsultationSlots(int page, int size);

    List<ConsultationSlot> searchConsultationSlots(String term);

    Optional<ConsultationSlot> findById(int slotId);

    void deleteById(int slotId);
}
