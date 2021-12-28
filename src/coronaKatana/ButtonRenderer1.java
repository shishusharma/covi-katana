package coronaKatana;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.time.LocalDate;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

import com.Myconnection.MyConnection;

import api.fun.Mail;
//import apiTest.ParsedJSON;

//Button Renderer Class
@SuppressWarnings("serial")
public class ButtonRenderer1 extends JButton implements TableCellRenderer{
    static String adhar;


    public static String getAdhar() {
        return adhar;
    }

    public static void setAdhar(String aadhar) {
        adhar = aadhar;
    }

    //Constructor
    public ButtonRenderer1() {
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

class ButtonEditor2 extends DefaultCellEditor{
    Connection con=(Connection) MyConnection.getConn();
    protected JButton btn;
    private String lbl;
    private Boolean clicked;

    public ButtonEditor2(JTextField txt) {
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

    String center_id="",centerDtls="";
    LocalDate dtm = LocalDate.now();
    //override a couple of methods
    @Override
    public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
        // TODO Auto-generated method stub
        //set text to button ,set clicked to true, then return the bin object
        lbl=(value==null)?"NA":value.toString();
        btn.setText(lbl);


        return btn;
    }
    String name="",email="";
    @Override



    public Object getCellEditorValue() {
        // TODO Auto-generated method stub
        if(clicked&&!lbl.equals("NA")) {

            Book();
        }
        //set it to false now that its clicked
        clicked=false;
        return new String(lbl);
    }

    public void Book(){
        //show us some message


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


