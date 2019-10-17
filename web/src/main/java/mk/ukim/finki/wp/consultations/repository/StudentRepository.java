package mk.ukim.finki.wp.consultations.repository;

import mk.ukim.finki.wp.consultations.model.Student;

import java.util.Optional;

public interface StudentRepository {

    Optional<Student> findById(String studentIndex);

    void save(Student student);
}
