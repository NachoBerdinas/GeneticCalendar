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
        boolean inside = ranges.stream().anyMatch(r -> subject.getRange().isInside(r));
        if(subjects.contains(subject) || overlaps || !inside){
            //System.out.println("Cant insert subject to professor "+name +" " + subjects.contains(subject) +" "+ overlaps + " "+ !inside);
            return false;
        }
        subjects.add(subject);
        return true;
    }

    public void removeSubject(Subject subject){
        subjects.remove(subject);
    }

    public void addRange(Range range){
        ranges.add(range);
    }
}
