package coronaKatana;

import javax.swing.JPanel;
import javax.swing.JLabel;

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
		setBounds(200,0,600,720);
		
		
		 //setBackground(Color.red);
		 int y=150;
		 JLabel lbl_header;
		 
		 	lbl_header=new JLabel("NEW REGISTRATION",JLabel.CENTER);
	        lbl_header.setBounds(0,0,600,100);
	        lbl_header.setFont(new Font("Serif", Font.BOLD, 20));
	        lbl_header.setForeground(new Color(247,249,249));
	        lbl_header.setBackground(new Color(46, 134, 193));
	        lbl_header.setOpaque(true);
	        add(lbl_header);

		
		//label
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblName.setBounds(41, 41+y, 58, 28);
		 add(lblName);
		
		JLabel lblNumber = new JLabel("Number");
		lblNumber.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNumber.setBounds(41, 98+y, 79, 28);
		 add(lblNumber);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmail.setBounds(41, 155+y, 79, 28);
		 add(lblEmail);
		
		JLabel lblAadhar = new JLabel("Aadhaar No.");
		lblAadhar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblAadhar.setBounds(41, 212+y, 95, 28);
		 add(lblAadhar);
		
		lblOtpSend=new JLabel("");
		 add(lblOtpSend);
			
		lblOtpSend.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOtpSend.setForeground(Color.red);		
		lblOtpSend.setBounds(275, 250+y, 195, 20);
		
		//textField
		txtName = new JTextField();
		 add(txtName);
		txtName.setBounds(206, 46+y, 195, 23);
		
		txtName.setColumns(10);
		
		txtNumber = new JTextField();
		 add(txtNumber);
		txtNumber.setBounds(206, 104+y, 195, 20);
		
		txtNumber.setColumns(10);
		
		txtEmail = new JTextField();
		add(txtEmail);
		txtEmail.setBounds(206, 162+y, 195, 20);
		 
		txtNumber.setColumns(10);
		
		txtAadhaar = new JTextField();
		add(txtAadhaar);
		txtAadhaar.setBounds(206, 220+y, 195, 20);
		
		txtNumber.setColumns(10);
		
		
		
		JButton btnLogin = new JButton("Register");
		add(btnLogin);
		btnLogin.setBounds(312, 278+y, 89, 23);
		btnLogin.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				Random rnd=new Random();
				OTP=rnd.nextInt(99999);
				System.out.println( "Creating message" );
		        String from="otpshishusharma@gmail.com";
		        String to=txtEmail.getText();
		        String sub="Testing javax.mail kancha.";
		        String msg="This is System Generated Mail for COVID Vaccination and OTP is "+OTP+"";
		        lblOtpSend.setText("OTP send to Eamil");
		        sendMail(msg,sub,to,from);
		        try {
					insertValueTofLogin(txtName.getText(),Long.parseLong(txtNumber.getText()),Long.parseLong(txtAadhaar.getText()),txtEmail.getText());
				} catch (NumberFormatException | ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
	
			private void sendMail(String msg, String sub, String to, String from) {
				String host="smtp.gmail.com";
				Properties prop=System.getProperties();
				prop.put("mail.smtp.host", host);
				prop.put("mail.smtp.port", "465");
				prop.put("mail.smtp.ssl.enable", "true");
				prop.put("mail.smtp.auth", "true");
				
				Session session = Session.getDefaultInstance(prop,    
				           new javax.mail.Authenticator() {    
				           protected PasswordAuthentication getPasswordAuthentication() {    
				           return new PasswordAuthentication("otpshishusharma@gmail.com","@Otp1989");  
				           }    
				          });
				
				//session.setDebug(true);
				MimeMessage m= new MimeMessage(session);
				try {
					
					m.setFrom(from);
					m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
					m.setSubject(sub);
					m.setText(msg);
					Transport.send(m);
				} catch (MessagingException e) {
					// TODO Auto-generated catch block
					lblOtpSend.setBounds(240, 250+y, 195, 20);
					lblOtpSend.setText("Please Enter Valid Email");
					e.printStackTrace();
				}
				
			
			}	
			
			
		});
		
		 
		
		JLabel lblOtp = new JLabel("OTP");
		 add(lblOtp);
		lblOtp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOtp.setBounds(40, 314+y, 58, 20);
		
		
		txtOtp = new JTextField();
		add(txtOtp);
		txtOtp.setBounds(206,316+y, 195, 23);
		 
		txtOtp.setColumns(10);
		
		JButton btnValidateOtp = new JButton("Validate OTP");
		 add(btnValidateOtp);
		btnValidateOtp.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				if(Integer.parseInt(txtOtp.getText())==OTP){
					//JOptionPane.showMessageDialog(null, "yes U are login successfully");
					lblOtpSend.setBounds(230, 340+y, 195, 20);
					lblOtpSend.setForeground(Color.green);
					lblOtpSend.setText("OTP Validate Successfully");
//					try {
//						insertValueTofLogin(txtName.getText(),Integer.parseInt(txtNumber.getText()),Integer.parseInt(txtAadhaar.getText()),txtEmail.getText());
//					} catch (NumberFormatException | ClassNotFoundException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
					
				}else{
					//JOptionPane.showMessageDialog(null, "wrong OTP");
					lblOtpSend.setBounds(230, 340+y, 195, 20);
					lblOtpSend.setForeground(Color.red);
					lblOtpSend.setText("UnValid OTP, ReEntered");
				}
			}
		});
		btnValidateOtp.setBounds(284, 370+y, 114, 23);
		
		
		
	}
	public void insertValueTofLogin(String name,long phone,long aadhaar,String email) throws ClassNotFoundException {
		java.util.Date date=new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		Connection con=(Connection) MyConnection.getConn();
		
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement("insert into flogin values(?,?,?,?,?)");
			//PreparedStatement stmt1=(PreparedStatement) con.prepareStatement("INSERT INTO `aadhaar_status` (`aadhar`) VALUES ('"+aadhaar+"')");
			//we comment this because at in databse we already added trigger called after_insertion_flogin
			 
			stmt.setString(1, name);
			stmt.setLong(2, phone);
			stmt.setString(3, email);
			stmt.setLong(4, aadhaar);
			stmt.setDate(5, sqlDate);
			
			stmt.executeUpdate();
			
			//stmt1.executeUpdate();
			con.close();
		}catch(SQLException e) {
		e.getStackTrace();	
		}
		
		
	
		
	}
	
//	public static void main(String[] args) {
//		new Registration();
//		
//	}
//	
	
}
