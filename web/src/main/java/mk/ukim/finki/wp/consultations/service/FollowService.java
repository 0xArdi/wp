package mk.ukim.finki.wp.consultations.service;

import mk.ukim.finki.wp.consultations.model.Student;
import mk.ukim.finki.wp.consultations.model.vm.Page;

public interface FollowService {

    void follow(String studentIndex, String professorId);

    void unFollow(String studentIndex, String professorId);

    Page<Student> getFollowers(int page, int pageSize);
}
