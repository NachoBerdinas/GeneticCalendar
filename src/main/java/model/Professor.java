package model;

import java.util.List;

/**
 * Created by Ignacio on 1/23/2017.
 */
public class Professor {
    private String name;
    private List<Subject> subjects;
    private List<Range> ranges;

    public Professor(String name) {
        this.name = name;
    }

    public Professor(String name, List<Subject> subjects, List<Range> ranges) {
        this.name = name;
        this.subjects = subjects;
        this.ranges = ranges;
    }

    public void addSubject(Subject subject){
        subjects.add(subject);
    }

    public void addRange(Range range){
        ranges.add(range);
    }
}
