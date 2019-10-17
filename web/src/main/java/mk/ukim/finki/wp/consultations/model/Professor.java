package mk.ukim.finki.wp.consultations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Professor {

    private String id;

    private String title;

    private String firstName;

    private String lastName;

    private List<Student> followers;

    public boolean matches(String term) {
        return this.firstName.matches(term) ||
                this.lastName.matches(term) ||
                this.title.matches(term);
    }
}
