import model.Professor;
import model.Range;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by matias on 1/23/17.
 */
public class Ingenieria {
    private List<Professor> professors;

    public Ingenieria() {
        this.professors = new ArrayList<>();
    }

    public void init() {
        professors.add(new Professor("Alicia", Arrays.asList(new Range(0, 20, 0), new Range(0, 20, 2))));
        professors.add(new Professor("Alberto", Arrays.asList(new Range(0, 20, 1), new Range(0, 20, 3))));
        professors.add(new Professor("Cassol", Arrays.asList(new Range(0, 20, 0), new Range(0, 20, 2), new Range(0, 20, 4), new Range(0, 20, 1))));
        professors.add(new Professor("Cecilia", Arrays.asList(new Range(0, 20, 4), new Range(0, 20, 2))));
        professors.add(new Professor("Lupanni", Arrays.asList(new Range(0, 20, 3), new Range(0, 20, 4))));
        professors.add(new Professor("Colunga", Arrays.asList(new Range(0, 20, 2), new Range(0, 20, 2))));
        professors.add(new Professor("Vivian", Arrays.asList(new Range(0, 20, 1), new Range(0, 20, 0))));
    }

    public List<Professor> getProfessors() {
        return professors;
    }
}
