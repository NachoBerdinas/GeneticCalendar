package model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ignacio on 1/23/2017.
 */
public class Calendar {
    public Subject[][] days;
    public List<Subject> subjects;

    public Calendar() {
        days = new Subject[5][48];
        subjects = new ArrayList<>();
    }

    public Calendar(Calendar father, Calendar mother){
        int subjectCount = father.getSubjects().size();

        for(int i = 0; i< subjectCount ; i++){
            if(i%2==0){
                if(!addSubject(father.getSubjects().remove(0))){
                    --i;
                }
            }else {
                if(!addSubject(mother.getSubjects().remove(0))){
                    --i;
                }
            }
        }
        mutate();
        calculateScore();
    }

    private void mutate(){

    }

    private void calculateScore() {

    }


    public boolean addSubject(Subject subject){
        for(int i = subject.getRange().getStart(); i< subject.getRange().getFinish() ;i++){
            if(days[subject.getRange().getDay()][i] != null || subjects.contains(subject)) return false;
            days[subject.getRange().getDay()][i] = subject;
        }
        subjects.add(subject);
        return true;
    }

    public void removeSubject(Subject subject){
        for(int i = subject.getRange().getStart(); i< subject.getRange().getFinish() ;i++){
            days[subject.getRange().getDay()][i] = null;
        }
    }

    public Subject[][] getDays() {
        return days;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
