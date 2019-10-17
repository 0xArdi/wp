package mk.ukim.finki.wp.consultations.model.vm;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@AllArgsConstructor
@Data
public class Page<T> {

    private int page;

    private int totalPages;

    private int pageSize;

    private List<T> content;

}
