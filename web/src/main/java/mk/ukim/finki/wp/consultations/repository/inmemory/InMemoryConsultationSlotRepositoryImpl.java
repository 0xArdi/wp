package mk.ukim.finki.wp.consultations.repository.inmemory;

import mk.ukim.finki.wp.consultations.bootstrap.DataHolder;
import mk.ukim.finki.wp.consultations.model.ConsultationSlot;
import mk.ukim.finki.wp.consultations.model.vm.Page;
import mk.ukim.finki.wp.consultations.repository.ConsultationSlotRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class InMemoryConsultationSlotRepositoryImpl implements ConsultationSlotRepository {

    @Override
    public ConsultationSlot save(ConsultationSlot slot) {
        this.findById(slot.getSlotId()).ifPresent(DataHolder.slots::remove);
        DataHolder.slots.add(slot);
        return slot;
    }

    @Override
    public Page<ConsultationSlot> getAllConsultationSlots(int page, int size) {
        return Page.slice(DataHolder.slots, page, size);
    }

    @Override
    public List<ConsultationSlot> searchConsultationSlots(String term) {
        return DataHolder.slots.stream()
                .filter(s -> s.getRoom().matches(term) || s.getProfessor().matches(term))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ConsultationSlot> findById(int slotId) {
        return DataHolder.slots.stream()
                .filter(s -> s.getSlotId() == slotId)
                .findFirst();
    }

    @Override
    public void deleteById(int slotId) {
        this.findById(slotId).ifPresent(DataHolder.slots::remove);
    }
}
