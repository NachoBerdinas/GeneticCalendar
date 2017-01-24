import model.Subject;

import javax.swing.*;
import javax.swing.table.TableColumn;
import java.util.Vector;

/**
 * Created by Ignacio on 1/23/2017.
 */
public class CalendarGUI extends JTable {

    public CalendarGUI(int numRows, int numColumns) {
        super(numRows, numColumns);
    }

    public void init (){

        Vector<String> columnNames = new Vector<String>();
        columnNames.addElement("Horarios");
        columnNames.addElement("Lunes");
        columnNames.addElement("Martes");
        columnNames.addElement("Miercoles");
        columnNames.addElement("Jueves");
        columnNames.addElement("Viernes");

        for (int i = 0; i < 48; i++) {
            String cero = i%4 == 0 ? "0" : "";
            getModel().setValueAt((i/4 + 9) + ":" + i%4 * 15 + cero, i, 0);
        }

        for(int i=0;i<getColumnCount();i++) {
            TableColumn column1 = getTableHeader().getColumnModel().getColumn(i);
            column1.setHeaderValue(columnNames.get(i));
        }
    }

    public void addSubject(Subject subject){
        for(int i = subject.getRange().getStart(); i< subject.getRange().getFinish() ;i++){
            getModel().setValueAt(subject.getName(),i,subject.getRange().getDay()+1);
        }
    }

    public void removeSubject(Subject subject){
        for(int i = subject.getRange().getStart(); i< subject.getRange().getFinish() ;i++){
            getModel().setValueAt("",i,subject.getRange().getDay()+1);
        }
    }

    public void clear(){
        for(int i =1; i < 6 ;i++){
            for(int j = 0; j< 48 ;j++){
                getModel().setValueAt("",j,i);
            }
        }
    }

}
