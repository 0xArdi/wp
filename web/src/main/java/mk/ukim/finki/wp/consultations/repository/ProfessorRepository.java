package mk.ukim.finki.wp.consultations.repository;

import mk.ukim.finki.wp.consultations.model.Professor;
import mk.ukim.finki.wp.consultations.model.Student;
import mk.ukim.finki.wp.consultations.model.vm.Page;

import java.util.Optional;

public interface ProfessorRepository {

    Optional<Professor> findById(String professorId);

    Professor save(Professor professor);

    Page<Student> getFollowers(String professorId, int page, int pageSize);
}
