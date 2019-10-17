package mk.ukim.finki.wp.consultations.service.impl;

import mk.ukim.finki.wp.consultations.model.Professor;
import mk.ukim.finki.wp.consultations.model.Student;
import mk.ukim.finki.wp.consultations.model.exceptions.InvalidProfessorId;
import mk.ukim.finki.wp.consultations.model.exceptions.InvalidStudentIndex;
import mk.ukim.finki.wp.consultations.model.vm.Page;
import mk.ukim.finki.wp.consultations.repository.ProfessorRepository;
import mk.ukim.finki.wp.consultations.repository.StudentRepository;
import mk.ukim.finki.wp.consultations.service.FollowService;
import org.springframework.stereotype.Service;

@Service
public class FollowServiceImpl implements FollowService {

    private final ProfessorRepository professorRepository;

    private final StudentRepository studentRepository;

    public FollowServiceImpl(ProfessorRepository professorRepository, StudentRepository studentRepository) {
        this.professorRepository = professorRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public void follow(String studentIndex, String professorId) {
        Student student = this.studentRepository.findById(studentIndex).orElseThrow(InvalidStudentIndex::new);
        Professor professor = this.professorRepository.findById(professorId).orElseThrow(InvalidProfessorId::new);
        student.follow(professor);
        this.studentRepository.save(student);
        this.professorRepository.save(professor);
    }

    @Override
    public void unFollow(String studentIndex, String professorId) {
        Student student = this.studentRepository.findById(studentIndex).orElseThrow(InvalidStudentIndex::new);
        Professor professor = this.professorRepository.findById(professorId).orElseThrow(InvalidProfessorId::new);
        student.unFollow(professor);
        this.studentRepository.save(student);
        this.professorRepository.save(professor);
    }

    @Override
    public Page<Student> getFollowers(int page, int pageSize) {
        return this.professorRepository.getFollowers(page, pageSize);
    }
}
