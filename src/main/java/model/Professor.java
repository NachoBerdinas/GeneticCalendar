package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ignacio on 1/23/2017.
 */
public class Professor {
    private String name;
    private List<Subject> subjects;
    private List<Range> ranges;

    public Professor(String name, List<Range> ranges) {
        this.name = name;
        this.ranges = ranges;
        this.subjects = new ArrayList<>();
    }

    public Professor(String name, List<Subject> subjects, List<Range> ranges) {
        this.name = name;
        this.subjects = subjects;
        this.ranges = ranges;
    }

    public boolean addSubject(Subject subject){
        boolean overlaps = subjects.stream().map(Subject::getRange).anyMatch(r -> r.overlaps(subject.getRange()));
        if(subjects.contains(subject) || overlaps) return false;
        subjects.add(subject);
        return true;
    }

    public void addRange(Range range){
        ranges.add(range);
    }
}
