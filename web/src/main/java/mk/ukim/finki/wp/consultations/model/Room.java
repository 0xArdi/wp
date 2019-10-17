package mk.ukim.finki.wp.consultations.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {

    private String name;

    private Building building;

    private String description;

    public boolean matches(String term) {
        return this.name.contains(term) ||
                this.description.contains(term) ||
                this.building.getDescription().contains(term);
    }
}
