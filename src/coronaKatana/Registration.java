package coronaKatana;

import javax.swing.*;

import java.awt.*;


import api.fun.Mail;
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
import javax.swing.border.CompoundBorder;

import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.util.Properties;
import java.util.Random;

public class Registration extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static int OTP=1234;

	private JTextField txtName;
	private JTextField txtNumber;
	private JTextField txtOtp;
	private JTextField txtAadhaar;
	private JTextField txtEmail;
	private JLabel lblOtpSend;
	
	
	
	
	
	
	
	
	public Registration() {
		setVisible(false);
		 setLayout(null);

		//setBorder(BorderFactory.createLineBorder(new Color(	51,54,69),40));
		setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(170, 80, 50, 80, new Color(0, 128, 255)),
				BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black)));
		setBounds(200,50,630,670);
		
		
		 setBackground(new Color(220, 208, 255));
		 int y=150;
		 JLabel lbl_header;
		 
		 	lbl_header=new JLabel("NEW REGISTRATION",JLabel.CENTER);
	        lbl_header.setBounds(80,70,470,100);
	        lbl_header.setFont(new Font("Serif", Font.BOLD, 22));
	        lbl_header.setForeground(Color.white);
	        lbl_header.setBackground(Color.black);
	        lbl_header.setOpaque(true);
	        add(lbl_header);


		JLabel lblName = new JLabel("Name               :",JLabel.LEFT);;
		lblName.setFont(new Font("Verdana", Font.BOLD, 16));
		lblName.setBounds(121, 41+y, 150, 28);
		add(lblName);

		
		JLabel lblNumber = new JLabel("Contact No.     :");
		lblNumber.setFont(new Font("Verdana", Font.BOLD, 16));
		lblNumber.setBounds(121, 98+y, 150, 28);
		 add(lblNumber);
		
		JLabel lblEmail = new JLabel("Email               :");
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 16));
		lblEmail.setBounds(121, 155+y, 150, 28);
		 add(lblEmail);
		
		JLabel lblAadhar = new JLabel("Aadhaar No.    :");
		lblAadhar.setFont(new Font("Verdana", Font.BOLD, 16));
		lblAadhar.setBounds(121, 212+y, 140, 28);
		 add(lblAadhar);
		
		lblOtpSend=new JLabel("");
		 add(lblOtpSend);
			
		lblOtpSend.setFont(new Font("Verdana", Font.BOLD, 14));
		lblOtpSend.setForeground(Color.red);		
		lblOtpSend.setBounds(360, 250+y, 195, 20);

		//textField
		txtName = new JTextField();
		 add(txtName);
		txtName.setBounds(296, 46+y, 195, 25);
		txtName.setFont(new Font("Verdana", Font.PLAIN, 14));
		//txtName.setBackground(Color.cyan);
		txtName.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237),1));


		txtName.setColumns(10);
		
		txtNumber = new JTextField();
		 add(txtNumber);
		txtNumber.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtNumber.setBounds(296, 104+y, 195, 25);
		txtNumber.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237),1));
		
		txtNumber.setColumns(10);
		
		txtEmail = new JTextField();
		add(txtEmail);
		txtEmail.setBounds(296, 162+y, 195, 25);
		txtEmail.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtEmail.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237),1));
		txtNumber.setColumns(10);
		
		txtAadhaar = new JTextField();
		add(txtAadhaar);
		txtAadhaar.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtAadhaar.setBounds(296, 220+y, 195, 25);
		txtAadhaar.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237),1));
		txtNumber.setColumns(10);
		
		
		
		JButton btnLogin = new JButton("Register");
		add(btnLogin);
		btnLogin.setBounds(222, 278+y, 150, 30);
		btnLogin.setFont(new Font("Verdana", Font.BOLD, 15));
		btnLogin.setForeground(Color.white);
		btnLogin.setBackground(Color.black);
		btnLogin.setOpaque(true);
		btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnLogin.setBackground(Color.darkGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnLogin.setBackground(Color.black);
			}
		});
		btnLogin.setFocusPainted(false);
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Random rnd=new Random();
				OTP=rnd.nextInt(99999);
				System.out.println( "Creating message" );
				//String from="otpshishusharma@gmail.com";
				String to=txtEmail.getText();
				String sub="OTP For Vaccine Registration";
				String msg="This is System Generated Mail for COVID Vaccination and OTP is "+OTP+"";
				lblOtpSend.setText("OTP send to Eamil");
				int check= Mail.sendMail(msg, sub, to);
				if(check==0) {
					lblOtpSend.setBounds(300, 250+y, 195, 20);
					lblOtpSend.setText("Please Enter Valid Email");
				}
				
			}
	
			
			
		});
		
		 
		
		JLabel lblOtp = new JLabel("OTP                :");
		 add(lblOtp);
		lblOtp.setFont(new Font("Verdana", Font.BOLD, 16));
		lblOtp.setBounds(121, 334+y, 150, 20);
		
		
		txtOtp = new JTextField();
		add(txtOtp);
		txtOtp.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtOtp.setBounds(296,336+y, 195, 25);
		txtOtp.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237),1));
		txtOtp.setColumns(10);
		
		JButton btnValidateOtp = new JButton("Validate OTP");
		 add(btnValidateOtp);
		btnValidateOtp.setBounds(222, 390+y, 150, 30);
		btnValidateOtp.setFont(new Font("Verdana", Font.BOLD, 15));
		btnValidateOtp.setForeground(Color.white);
		btnValidateOtp.setBackground(Color.black);
		btnValidateOtp.setOpaque(true);
		btnValidateOtp.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnValidateOtp.setBackground(Color.darkGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnValidateOtp.setBackground(Color.black);
			}
		});
		btnValidateOtp.setFocusPainted(false);

		btnValidateOtp.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				if(Integer.parseInt(txtOtp.getText())==OTP){
					//JOptionPane.showMessageDialog(null, "yes U are login successfully");
					lblOtpSend.setBounds(260, 370+y, 250, 20);
					lblOtpSend.setForeground(Color.green);
					lblOtpSend.setText("OTP Validate Successfully");

					try {
						insertValueTofLogin(txtName.getText().trim(),txtNumber.getText().trim(),txtAadhaar.getText().trim(),txtEmail.getText().trim());
					} catch (NumberFormatException | ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}else{
					//JOptionPane.showMessageDialog(null, "wrong OTP");
					lblOtpSend.setBounds(270, 360+y, 195, 20);
					lblOtpSend.setForeground(Color.red);
					lblOtpSend.setText("UnValid OTP, ReEntered");
				}
			}

		});

		
		
		
	}
	public void insertValueTofLogin(String name,String phone,String aadhaar,String email) throws ClassNotFoundException {
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		Connection con=(Connection) MyConnection.getConn();
		
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement("insert into flogin values(?,?,?,?,?)");
			//PreparedStatement stmt1=(PreparedStatement) con.prepareStatement("INSERT INTO `aadhaar_status` (`aadhar`) VALUES ('"+aadhaar+"')");
			//we comment this because at in databse we already added trigger called after_insertion_flogin
			 
			stmt.setString(1, name);
			stmt.setString(2, phone);
			stmt.setString(3, email);
			stmt.setString(4, aadhaar);
			stmt.setDate(5, sqlDate);
			
			stmt.executeUpdate();
			
			//stmt1.executeUpdate();
			con.close();
			//calling clear function
			clearField();
			int check=1;
			String to=email;
			String sub="Successfully Registered to Covi-Katana";
			String msg="Dear "+name+", You have successfully Registered on the Covi-katana App. Login to Book your First Dose of Vaccination";

			check=Mail.sendMail(msg,sub,to);
			System.out.println("check Mail After Registrain "+check);

		}catch(SQLException e) {
		e.getStackTrace();	
		}
		
		
	
		
	}

	//after registration it is clear all field
	public void clearField() {
		txtAadhaar.setText("");
		txtEmail.setText("");
		txtName.setText("");
		txtNumber.setText("");
		txtOtp.setText("");
	}


//	public static void main(String[] args) {
//		new Registration();
//		
//	}
//	
	
}
