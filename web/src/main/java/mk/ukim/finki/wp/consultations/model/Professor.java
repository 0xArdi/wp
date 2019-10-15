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

}
