package model;

/**
 * Created by Ignacio on 1/23/2017.
 */
public class Range {
    private int start;
    private int finish;
    private int day;

    public Range(int start, int finish, int day) {
        this.start = start;
        this.finish = finish;
        this.day = day;
    }

    public boolean overlaps(Range other) {
        return Math.max(start, other.start) <= Math.min(finish, other.finish);
    }

    public int getStart() {
        return start;
    }

    public int getFinish() {
        return finish;
    }

    public int getDay() {
        return day;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Range range = (Range) o;

        if (start != range.start) return false;
        if (finish != range.finish) return false;
        return day == range.day;

    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + finish;
        result = 31 * result + day;
        return result;
    }
}
