package mk.ukim.finki.wp.consultations.model;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class Room {

    private String name;

    private Building building;

    private String description;
}
