package hospitalEnd;

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
	private JTextField txtNumber;
	private JTextField txtOtp;
	private JTextField txtAadhaar;
	private JTextField txtEmail;
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
		
		JLabel lblHeading=new JLabel("Login Here");
		add(lblHeading);
		lblHeading.setBackground(Color.red);
		lblHeading.setBounds(410,0,90,25);
		

		JLabel lblph=new JLabel("Enter Mobile");
		add(lblph);
		lblph.setBackground(Color.red);
		lblph.setBounds(10,40,90,25);
		
	
		JLabel lblEmail=new JLabel("Enter Email");
		add(lblEmail);
		lblEmail.setBackground(Color.red);
		lblEmail.setBounds(10,70,90,25);
		
		
		JLabel lblOtp=new JLabel("Enter OTP");
		lblOtp.setBackground(Color.red);
		lblOtp.setBounds(10,135,70,25);
		add(lblOtp);
		
		txtNumber=new JTextField();
		txtNumber.setBounds(110,40,150,20);
		add(txtNumber);
		
		txtEmail=new JTextField();
		txtEmail.setBounds(110,70,150,20);
		add(txtEmail);
		
		txtOtp=new JTextField();
		txtOtp.setBounds(100,135,60,20);
		add(txtOtp);
		
		JLabel lbl_otp=new JLabel("");
		add(lbl_otp);
		lbl_otp.setBounds(10,100,130,20);
		
		
		
		JButton btnotp=new JButton("GET OTP");
		btnotp.setBounds(160,100,130,20);
		add(btnotp);
		
		
		btnotp.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("1234");
				long mob=Long.parseLong(txtNumber.getText().trim());
				String Email=txtEmail.getText().trim();
				Connection con=(Connection) MyConnection.getConn();
				
				try {
					PreparedStatement stmt=(PreparedStatement) con.prepareStatement("select * from flogin where phone='"+mob+"' and email='"+Email+"'");
					stmt.executeQuery();
					
				}catch(Exception e) {
					lbl_otp.setText("Please Enter Correct Deratils");
					System.out.println(e);
				}
				
				
				//Random rnd=new Random();
				//OTP=rnd.nextInt(99999);
				System.out.println( "Creating message" );
		        String from="otpshishusharma@gmail.com";
		        String to=txtEmail.getText();
		        String sub="Testing javax.mail kancha.";
		        String msg="This is System Generated Mail for COVID Vaccination and OTP is "+OTP+"";
		        lbl_otp.setText("OTP send to Eamil");
		        sendMail(msg,sub,to,from);
		       
				
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
					lbl_otp.setText("Please Enter Valid Email");
					e.printStackTrace();
				}

			
			}
			
		});
		
		
		
		JButton btnVali=new JButton("Validate");
		btnVali.setBounds(175,135,80,20);
		add(btnVali);
		
		btnVali.addActionListener(new ActionListener() {
			
			
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("archit");
				setVisible(false);
				
				
				String aadhar = "";
				String nm = null;
				int status=0;
				if(Integer.parseInt(txtOtp.getText())==OTP){
					//JOptionPane.showMessageDialog(null, "yes U are login successfully");
					lbl_otp.setBounds(10,175,150,20);
					lbl_otp.setForeground(Color.green);
					lbl_otp.setText("OTP Validate Successfully");
					
					long mob=Long.parseLong(txtNumber.getText().trim());
					String Email=txtEmail.getText().trim();
					Connection con=(Connection) MyConnection.getConn();
					
					try {
						PreparedStatement stmt=(PreparedStatement) con.prepareStatement("select * from flogin where phone='"+mob+"' or email='"+Email+"'");
						
						ResultSet rs=stmt.executeQuery();
						if(rs.next()) {
							aadhar=rs.getString("aadhaar");
							nm=rs.getString("name");
							
						}
						PreparedStatement stmt1=(PreparedStatement) con.prepareStatement("select status from aadhaar_status where aadhar='"+aadhar+"'");
						
						rs=stmt1.executeQuery();
						if(rs.next()) {
							status=rs.getInt("status");
						}
						
						System.out.println("mob- "+mob+"email- "+Email+" Addahr- "+aadhar);
						//new FrontView(new Loggedin(nm,aadhar,String.valueOf(mob),Email,status));
						//FrontView.Loggin=new Loggedin(nm,aadhar,String.valueOf(mob),Email,status);
						//FrontView.Loggin=null;
						//FrontView.Loggin.add(new Loggedin());
						
						System.out.println(nm+" "+aadhar+" "+mob+" "+Email+" "+status);
						
					}catch(Exception e) {
						e.printStackTrace();
						System.out.println(e);
					}
										
				}else{
					//JOptionPane.showMessageDialog(null, "wrong OTP");
					lbl_otp.setBounds(10,175,150,20);
					lbl_otp.setForeground(Color.red);
					lbl_otp.setText("UnValid OTP, ReEntered");
				}
				//FrontView.Loggin.setVisible(true);
			}
			
		
		});
		
		//FrontView.Loggin.setVisible(true);
		
		
	}

	
	
}
