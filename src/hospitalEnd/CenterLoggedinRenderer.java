package hospitalEnd;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

import com.Myconnection.MyConnection;

import coronaKatana.ButtonRenderer;

public class CenterLoggedinRenderer extends JButton implements TableCellRenderer  {

    public CenterLoggedinRenderer() {
        // TODO Auto-generated constructor stub
        setOpaque(true);
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        // TODO Auto-generated method stub
        setText((value==null)?"":value.toString());
        return this;
    }

    static class ButtonEditor1 extends DefaultCellEditor{
        Connection con=(Connection) MyConnection.getConn();
        protected JButton btn;
        private String lbl;
        private Boolean clicked;

        public ButtonEditor1(JTextField txt) {
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

        String aadhaar="",status="";

        //override a couple of methods
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            // TODO Auto-generated method stub
            //set text to button ,set clicked to true, then return the bin object
            lbl=(value==null)?"":value.toString();
            btn.setText(lbl);
            clicked=true;
            //get aadhar no. from CenterLoggeding JTable
            aadhaar=""+table.getModel().getValueAt(row, 1);
            //get status from CenterLoggeding JTable
            status=""+table.getModel().getValueAt(row, 2);
            System.out.println("status == "+status);

            return btn;
        }
        Connection con1=(Connection) MyConnection.getConn();

        @Override
        public Object getCellEditorValue() {
            // TODO Auto-generated method stub
            String vac_id="";
            java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

            if(clicked) {
                System.out.println("clicked check");
                try {
                    ResultSet rs=con1.prepareStatement("SELECT vac_id FROM vaccine where vace_dt>=CURRENT_DATE AND alloted_cen='998869' and dose=0 LIMIT 1;").executeQuery();
                    if(rs.next())
                        vac_id=rs.getString("vac_id");
                    System.out.println(vac_id);
                } catch (SQLException e) {
                    // TODO Auto-generated catch block
                    System.out.println("Vac ID");
                    e.printStackTrace();
                }

                //for update Status fDoseDT,sDoseDT in aadhaar_status table\
                if(status.equals("First")) {
                    try {
                        System.out.println("status checked");
                        PreparedStatement stmt=(PreparedStatement) con1.prepareStatement("update aadhaar_status set status=?,fDoseDT=? where aadhar="+aadhaar+"");
                        stmt.setInt(1, 1);//for first dose booking
                        stmt.setTimestamp(2,date);
                        stmt.executeUpdate();
                    }catch (SQLException e) {
                        // TODO: handle exception
                        System.out.println("fist dose vaccine_status Update");
                        e.printStackTrace();
                    }
                    try {
                        PreparedStatement stmt1=(PreparedStatement) con1.prepareStatement("update vaccine set dose=?,alloted_per_id=? where vac_id="+vac_id+"");
                        stmt1.setInt(1, 1);//for first dose booking
                        stmt1.setString(2,aadhaar);
                        stmt1.executeUpdate();
                        con.close();
                        //show us some message
                        System.out.println("Your first Dose Vaccination Done");
                        JOptionPane.showConfirmDialog(btn, lbl+"Your first Dose Vaccination Done");
                    }catch (SQLException e) {
                        System.out.println("fist dose vaccine table Update");
                        e.printStackTrace();
                    }

                }else if(status.equals("Second")) {
                    try {
                        PreparedStatement stmt=(PreparedStatement) con1.prepareStatement("update aadhaar_status set status=?,fDoseDT=? where aadhar="+aadhaar+"");
                        stmt.setInt(1, 3);//for second dose booking
                        stmt.setTimestamp(2,date);
                        stmt.executeUpdate();
                    }catch (SQLException e) {
                        // TODO: handle exception
                        System.out.println("second dose vaccine_status Update");
                        e.printStackTrace();
                    }
                    try {
                        PreparedStatement stmt1=(PreparedStatement) con1.prepareStatement("update vaccine set dose=?,alloted_per_id=? where vac_id="+vac_id+"");
                        stmt1.setInt(1, 2);//for second dose booking
                        stmt1.setString(2,aadhaar);
                        stmt1.executeUpdate();
                        con.close();
                        //show us some message
                        System.out.println("Your second Dose Vaccination Done");
                        JOptionPane.showConfirmDialog(btn, lbl+"Your Second Dose Vaccination Done");
                    }catch (SQLException e) {
                        // TODO: handle exception
                        System.out.println("second dose vaccine table Update");
                        e.printStackTrace();
                    }
                }





            }else {

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

}
