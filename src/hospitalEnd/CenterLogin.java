package hospitalEnd;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;

import com.Myconnection.MyConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.security.spec.MGF1ParameterSpec;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.util.Properties;
import java.util.Random;

public class CenterLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static int OTP=1234;

	private JTextField txtName;
	private JTextField txtCenter_id;
	private JTextField txtOtp;
	private JTextField txtAadhaar;
	private JTextField txtPincode;
	private JLabel lblOtpSend;
	
	public static void main(String[] args) {
		new CenterLogin();
	}
	
	
	
	
//start Login(int i)	
	public CenterLogin() {
		
		setBounds(800,300,300,200);
		setVisible(true);
		setLayout(null);
		setBackground(Color.cyan);
		
		JLabel lblHeading=new JLabel("Center Login");
		add(lblHeading);
		lblHeading.setBackground(Color.red);
		lblHeading.setBounds(410,0,90,25);
		

		JLabel lblph=new JLabel("UserName");
		add(lblph);
		lblph.setBackground(Color.red);
		lblph.setBounds(10,40,90,25);
		
	
		JLabel lblPincode=new JLabel("PassWord");
		add(lblPincode);
		lblPincode.setBackground(Color.red);
		lblPincode.setBounds(10,70,90,25);
		
		
		
		txtCenter_id=new JTextField();
		add(txtCenter_id);
		txtCenter_id.setBounds(110,40,150,20);
		
		
		txtPincode=new JTextField();
		add(txtPincode);
		txtPincode.setBounds(110,70,150,20);
		
		txtOtp=new JTextField();
		add(txtOtp);
		txtOtp.setBounds(100,135,60,20);
		
		
		JLabel lbl_msg=new JLabel("");
		add(lbl_msg);
		lbl_msg.setBounds(10,100,130,20);
		
		
		
		JButton btnlogin=new JButton("LOGIN");
		add(btnlogin);
		btnlogin.setBounds(160,100,90,20);
		
		
		
		btnlogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				long centerid=Long.parseLong(txtCenter_id.getText().trim());
				long centerpin=Long.parseLong(txtPincode.getText().trim());
					
				Connection con=(Connection) MyConnection.getConn();
				
				try {
					PreparedStatement stmt=(PreparedStatement) con.prepareStatement("select * from addvaccinecenter where center_id='"+centerid+"' and center_Pincode='"+centerpin+"'");
					ResultSet rs=stmt.executeQuery();
					if(rs.next()) {
						System.out.println(rs.getString("center_Dist"));
						CenterLoggedin.setCenter_Id(rs.getString(1));
						CenterLoggedin.setCenter_State(rs.getString(2));
						CenterLoggedin.setCenter_Dist(rs.getString(3));
						CenterLoggedin.setCenter_Area(rs.getString(4));
						CenterLoggedin.setCenter_NM(rs.getString(5));
						CenterLoggedin.setCenter_PIN(rs.getString(6));
						new CenterLoggedin();
						
					}else {
						lbl_msg.setText("Wrong Credensial");
						System.out.println("worng detatils");
						
					}
					
				}catch(Exception e) {
					e.printStackTrace();
					
					System.out.println(e);
				}
									
			
				
				
				
				
			}
	
			
			
		});
		
		
		
		
	}

	
	
}
