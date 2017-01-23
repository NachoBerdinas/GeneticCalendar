import model.Range;
import model.Subject;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Ignacio on 1/23/2017.
 */
public class GUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        CalendarGUI table = new CalendarGUI(48,5);
        table.init();
        table.addSubject(new Subject("Alice",new Range(0,12,2)));

        JScrollPane scrollPane = new JScrollPane(table);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.setSize(800,600);
        frame.setVisible(true);
    }
}
