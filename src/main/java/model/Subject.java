package model;

/**
 * Created by Ignacio on 1/23/2017.
 */
public class Subject {
    private String name;
    private Range range;

    public Subject(String name, Range range) {
        this.name = name;
        this.range = range;
    }


    public String getName() {
        return name;
    }

    public Range getRange() {
        return range;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Subject subject = (Subject) o;

        if (name != null ? !name.equals(subject.name) : subject.name != null) return false;
        return range != null ? range.equals(subject.range) : subject.range == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (range != null ? range.hashCode() : 0);
        return result;
    }
}
