import model.Professor;
import model.Range;
import model.Subject;
import old.DNA;
import random.RandomUtils;
import model.Calendar;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by Ignacio on 1/23/2017.
 */
public class GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        CalendarGUI gui = new CalendarGUI(48, 6);
        gui.init();
        JScrollPane scrollPane = new JScrollPane(gui);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(800,600);
        frame.setVisible(true);

        List<Calendar> calendars = new ArrayList<>();


        for( int i =0; i< 10000;i++) {
            Calendar table = new Calendar();
            java.util.List<String> subjectList = Arrays.asList("Etica", "Databases", "Inv Operativa", "Tecnicas", "Teoria Emp", "LCD", "Lab1");
            Map<String, Professor> map = new HashMap<>();
            List<String> subjects = new ArrayList<>();
            subjects.addAll(subjectList);
            subjectList = subjects;
            Ingenieria ing = new Ingenieria();

            ing.init();
            map.put("Etica", ing.getProfessors().get(0));
            map.put("Databases", ing.getProfessors().get(1));
            map.put("Inv Operativa", ing.getProfessors().get(2));
            map.put("Tecnicas", ing.getProfessors().get(3));
            map.put("Teoria Emp", ing.getProfessors().get(4));
            map.put("LCD", ing.getProfessors().get(5));
            map.put("Lab1", ing.getProfessors().get(6));

            int j = 0;
            while (!subjectList.isEmpty()) {
                int picked = RandomUtils.getInt(0, subjectList.size() - 1);
                int start = RandomUtils.getInt(0, 36);
                Subject subject = new Subject(subjectList.get(picked), new Range(start, start + 12, RandomUtils.getInt(0, 4)));
                //System.out.println("Trying to insert in calendar "+subject);

                if (table.addSubject(subject) && map.get(subject.getName()).addSubject(subject)) {
                    //System.out.println("Insert successful "+subject.getName() + " in range " + subject.getRange());
                    subjectList.remove(picked);
                } else {
                    //System.out.println(j++ + "Cant insert successful " + subject.getName() + " in range " + subject.getRange());
                    table.removeSubject(subject);
                    map.get(subject.getName()).removeSubject(subject);
                }
            }
            System.out.println(i+" Subjects "+table.getSubjects().size());
            calendars.add(table);
        }

        int generation = 0;
        while(true){
            calendars.forEach(Calendar::calculateScore);

            List<Calendar> matingPool = new ArrayList<>();
            for(Calendar c: calendars){
                for(int i =0; i< c.score;i++){
                    matingPool.add(c);
                }
            }

            calendars.clear();
            for (int i = 0; i < 10000; i++) {
                int a = (int) (Math.random() * matingPool.size());
                int b = (int) (Math.random() * matingPool.size());
                Calendar aux = new Calendar(matingPool.get(a), matingPool.get(b));
                if(aux.getSubjects().size() != 7){
                    System.out.println(" BYE");
                    i--;
                }else {
                    calendars.add(aux);
                }
            }
            System.out.println("Mating pool size "+matingPool.size() + "   Generation " + generation++);

            if(generation>200)break;
            matingPool.clear();
        }
        Calendar best = calendars.get(0);
        for(Calendar c: calendars){
            if(c.getStrength()>best.getStrength()) best = c;
        }

        gui.clear();

        best.getSubjects().forEach(gui::addSubject);

        try {
            Thread.sleep(2*generation);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
