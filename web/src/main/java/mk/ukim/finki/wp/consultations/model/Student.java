package mk.ukim.finki.wp.consultations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Student {

    private String index;

    private String firstName;

    private String lastName;

    private List<Professor> following;

    public void follow(Professor professor) {
        this.following.add(professor);
        professor.getFollowers().add(this);
    }

    public void unFollow(Professor professor) {
        this.following.remove(professor);
        professor.getFollowers().remove(this);
    }
}
