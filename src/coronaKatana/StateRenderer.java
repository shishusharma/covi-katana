package coronaKatana;

import com.Myconnection.MyConnection;

import javax.swing.*;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

//public class StateRenderer {
//}
//import apiTest.ParsedJSON;

//Button Renderer Class
@SuppressWarnings("serial")
public class StateRenderer extends JButton implements TableCellRenderer {
    //Constructor
    public StateRenderer() {
        //set Button properties
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        // TODO Auto-generated method stub
        setText((value==null)?"NA":value.toString());
        return this;
    }

}

class ButtonEditorState extends DefaultCellEditor{
    Connection con=(Connection) MyConnection.getConn();
    protected JButton btn;
    private String lbl;
    private Boolean clicked;

    public ButtonEditorState(JTextField txt) {
        super(txt);
        // TODO Auto-generated constructor stub
        btn=new JButton();
        btn.setOpaque(true);

        //when button is clicked
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub

                fireEditingStopped();
            }

        });
    }

    String stateNM,totalINF,totalDeath,totalREC,totalACT;
    //override a couple of methods
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
//        table.getColumnModel().getColumn(1).setMinWidth(0);
//        table.getColumnModel().getColumn(1).setMaxWidth(0);
        lbl=(value==null)?"":value.toString();
        btn.setText(lbl);

        stateNM= ""+table.getModel().getValueAt(row, 0);
        totalACT= ""+table.getModel().getValueAt(row, 1);
        totalINF= ""+table.getModel().getValueAt(row, 2);
        totalREC= ""+table.getModel().getValueAt(row, 3);
        totalDeath= ""+table.getModel().getValueAt(row, 4);
//
        javachart.setA1(Double.parseDouble(totalACT));
        javachart.setB1(Double.parseDouble(totalINF));
        javachart.setC1(Double.parseDouble(totalREC));
        javachart.setD1(Double.parseDouble(totalDeath));
        javachart.setStatenm(stateNM);
//        javachart.setStatenm(stateNM);
        JOptionPane jop = new JOptionPane();
        JDialog dialog = jop.createDialog(""+stateNM+"");
        dialog.setSize(600, 475);
        dialog.setLocationRelativeTo(null);
        dialog.setContentPane(new javachart());
        dialog.setVisible(true);

        clicked=true;

        return btn;
    }

    @Override
    public Object getCellEditorValue() {
        // TODO Auto-generated method stub
        if(clicked&&!lbl.equals("NA")) {
            //show us some message
            int statusv=-2;


        }
        //set it to false now that its clicked
        clicked=false;
        return new String(lbl);
    }

    @Override
    public boolean stopCellEditing() {
        // TODO Auto-generated method stub
        clicked=false;
        return super.stopCellEditing();

    }
    @Override
    protected void fireEditingStopped() {
        // TODO Auto-generated method stub
        super.fireEditingStopped();
    }


}


