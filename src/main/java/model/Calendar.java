package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Ignacio on 1/23/2017.
 */
public class Calendar {
    public Subject[][] days;
    public List<Subject> subjects;
    public int score=1;

    public Calendar() {
        days = new Subject[5][48];
        subjects = new ArrayList<>();
    }

    public Calendar(Calendar father, Calendar mother){
        days = new Subject[5][48];
        subjects = new ArrayList<>();

        father.getSubjects().get(0);
        father.getSubjects().get(1);
        father.getSubjects().get(2);

        for(int j = 0;j<mother.getSubjects().size();j++){
            addSubject(mother.getSubjects().get(j));
        }

        mutate();
        calculateScore();
    }

    private void mutate(){

    }

    public void calculateScore() {
        score = 1;
        for(int i = 0; i<5;i++){
            if(days[i][0] !=null) score++;
        }

        boolean emptyFriday = true;
        for(int i = 0; i<48;i++){
            if(days[4][i] != null) emptyFriday = false;
        }

        if(emptyFriday) score = (int)Math.pow(score,5);

        for(int i = 0; i<5;i++){
            for(int j = 12; j< 16;j++){
                if(days[i][j] == null) score++;
            }
        }
    }

    public int getStrength() {
        return score;
    }

    public boolean addSubject(Subject subject){
        if(subjects.contains(subject)) return false;
        for(int i = subject.getRange().getStart(); i< subject.getRange().getFinish() ;i++){
            if(days[subject.getRange().getDay()][i] != null) return false;
        }
        for(int i = subject.getRange().getStart(); i< subject.getRange().getFinish() ;i++){
            days[subject.getRange().getDay()][i] = subject;
        }
        subjects.add(subject);
        return true;
    }

    public void removeSubject(Subject subject){
        if(!subjects.contains(subject)) return;
        for(int i = subject.getRange().getStart(); i< subject.getRange().getFinish() ;i++){
            days[subject.getRange().getDay()][i] = null;
        }
        subjects.remove(subject);
    }

    public Subject[][] getDays() {
        return days;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }


}
