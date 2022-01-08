package coronaKatana;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.TableCellRenderer;

import com.Myconnection.MyConnection;

import api.fun.Mail;
//import apiTest.ParsedJSON;

//Button Renderer Class
@SuppressWarnings("serial")
public class ButtonRenderer extends JButton implements TableCellRenderer{
	static String adhar;


	public static String getAdhar() {
		return adhar;
	}

	public static void setAdhar(String aadhar) {
		adhar = aadhar;
	}

	//Constructor
	public ButtonRenderer() {
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

class ButtonEditor extends DefaultCellEditor{
	Connection con=(Connection) MyConnection.getConn();
	protected JButton btn;
	private String lbl;
	private Boolean clicked;

	public ButtonEditor(JTextField txt) {
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


		centerDtls=""+table.getModel().getValueAt(row, 0);
		center_id= ""+table.getModel().getValueAt(row, 1);
		System.out.println("center id "+center_id);
		clicked=true;
		int gci=table.getSelectedColumn();
		System.out.println("gci"+gci);
		switch(gci) {
			case 5:dtm=LocalDate.now();break;
			case 6:dtm=LocalDate.now().plusDays(1);break;
			case 7:dtm=LocalDate.now().plusDays(2);break;
			case 8:dtm=LocalDate.now().plusDays(3);break;
			case 9:dtm=LocalDate.now().plusDays(4);break;

		}
		System.out.println("Selected date"+dtm);

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
		int statusv=-2;
		JOptionPane.showConfirmDialog(btn, lbl+"clicked"+ButtonRenderer.getAdhar());

		//code allote vaccine to the patient
		java.sql.Timestamp date = new java.sql.Timestamp(new java.util.Date().getTime());

		try {
			PreparedStatement st=(PreparedStatement) con.prepareStatement("select flogin.name as name,flogin.email,aadhaar_status.status from aadhaar_status,flogin where aadhaar_status.aadhar=flogin.aadhaar AND aadhar="+ButtonRenderer.getAdhar()+"");
			ResultSet rs=st.executeQuery();
			while(rs.next()) {
				name=rs.getString(1);
				email=rs.getString(2);
				statusv=Integer.parseInt(rs.getString(3));
			}


			if(statusv==-1) {
				PreparedStatement stmt=(PreparedStatement) con.prepareStatement("update aadhaar_status set status=?,fDoseBDT=?,fDoseCen=?,fDoseDT=? where aadhar="+ButtonRenderer.getAdhar()+"");
				stmt.setInt(1, 0);//for first dose booking
				stmt.setTimestamp(2,date);
				stmt.setString(3, center_id);
				stmt.setString(4, ""+dtm);
				stmt.executeUpdate();


				JOptionPane.showConfirmDialog(null, "First Dose Booking Completed");
				PreparedStatement stmt1=(PreparedStatement) con.prepareStatement("update allotedvaccine set quantity=? where center_id='"+center_id+"' and date='"+dtm+"'");
				stmt1.setInt(1, Integer.parseInt(lbl)-1);
				stmt1.executeUpdate();
				int check=1;
				String to=email;
				String sub="First Dose Booked Sucessfully";
				String msg="Dear "+name+" You have successfully Boodked your 1st Dose Vaccination.Your Vaccination Center is "+centerDtls.toUpperCase()+" on Date : "+dtm+" ";

				check=Mail.sendMail(msg,sub,to);




			}else if(statusv==1) {
				PreparedStatement stmt=(PreparedStatement) con.prepareStatement("update aadhaar_status set status=?,sDoseBDT=?,sDoseCen=?,sDoseDT=? where aadhar="+ButtonRenderer.getAdhar()+"");
				stmt.setInt(1, 2);//for second dose booking
				stmt.setTimestamp(2,date);
				stmt.setString(3, center_id);
				stmt.setString(4, ""+dtm);
				stmt.executeUpdate();
				stmt.close();

				JOptionPane.showConfirmDialog(null, "Second Dose Booking Completed");
				PreparedStatement stmt1=(PreparedStatement) con.prepareStatement("update allotedvaccine set quantity=? where center_id='"+center_id+"' and date='"+dtm+"'");
				stmt1.setInt(1, Integer.parseInt(lbl)-1);
				stmt1.executeUpdate();
				stmt1.close();

				int check=1;
				String to=email;
				String sub="Second Dose Booked Sucessfully";
				String msg="Dear "+name+" You have successfully Boodked your 2nd Dose Vaccination. Your Vaccination Center is "+centerDtls.toUpperCase()+" on Date : "+dtm+" ";

				check=Mail.sendMail(msg,sub,to);

			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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


