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
import javax.swing.JFrame;

import java.awt.event.ActionListener;
import java.security.spec.MGF1ParameterSpec;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.util.Properties;
import java.util.Random;

public class Login extends JPanel {
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
	
	
	
	
	
	
//start Login(int i)	
	public Login(int i) {
		
		setBounds(800,300,300,200);
		setVisible(false);
		setLayout(null);
		setBackground(Color.cyan);
		
		JLabel lblHeading=new JLabel("Login Here");
		lblHeading.setBackground(Color.red);
		lblHeading.setBounds(410,0,90,25);
		add(lblHeading);

		JLabel lblph=new JLabel("Enter Mobile");
		lblph.setBackground(Color.red);
		lblph.setBounds(10,40,90,25);
		add(lblph);
	
		JLabel lblEmail=new JLabel("Enter Email");
		lblEmail.setBackground(Color.red);
		lblEmail.setBounds(10,70,90,25);
		add(lblEmail);
		
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
						LoginPanel.LloginReg.setVisible(false);
						LoginPanel.Llogin.setVisible(false);
						FrontView.SWU.setVisible(false);
						//FrontView.LPanel.setVisible(false);
						FrontView.RRR.setVisible(false);
						FrontView.Llogin.setVisible(false);
						
						
						System.out.println(nm+" "+aadhar+" "+mob+" "+Email+" "+status);
//						FrontView.Logginn.setName(nm);
//						FrontView.Logginn.setAadhar(aadhar);
//						FrontView.Logginn.setPhone(String.valueOf(mob));
//						FrontView.Logginn.setEmail(Email);
//						FrontView.Logginn.setStatus(status);
//						FrontView.Loggin.add(new Loggedin(nm,aadhar,String.valueOf(mob),Email,status));
//						FrontView.Loggin.setVisible(true);
						//FrontView.Logginn.add(new Loggedin());
					//	FrontView.Loggin.setVisible(false);
					//	FrontView.Logginn.setVisible(true);
						System.out.println("xyzzzzzzz");
//						FrontView.Loggin=new Loggedin(nm,aadhar,String.valueOf(mob),Email,status);
//						FrontView.Loggin.setVisible(true);
						Loggedin LLoggin=new Loggedin(nm,aadhar,String.valueOf(mob),Email,status);
						LLoggin.setVisible(true);
						FrontView.f1.add(LLoggin);
						
//						add(LLoggin);
						
//						FrontView.f1.add(LLoggin);
//						LLoggin.setVisible(true);
						LLoggin.setVisible(true);
						
						
						
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

//Ent Login(int i)
	
	
	public Login() {
		setBounds(200,0,1250,720);
		setVisible(false);
		 setLayout(null);
		 //setBackground(Color.red);
		 int y=150;
		 JLabel lbl_header;
		 
		 lbl_header=new JLabel("NEW REGISTRATION",JLabel.CENTER);
	        lbl_header.setBounds(0,0,1250,100);
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
		lblOtpSend.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOtpSend.setForeground(Color.red);		
		lblOtpSend.setBounds(275, 250+y, 195, 20);
		 add(lblOtpSend);
		
		//textField
		txtName = new JTextField();
		txtName.setBounds(206, 46+y, 195, 23);
		 add(txtName);
		txtName.setColumns(10);
		
		txtNumber = new JTextField();
		txtNumber.setBounds(206, 104+y, 195, 20);
		 add(txtNumber);
		txtNumber.setColumns(10);
		
		txtEmail = new JTextField();
		txtEmail.setBounds(206, 162+y, 195, 20);
		 add(txtEmail);
		txtNumber.setColumns(10);
		
		txtAadhaar = new JTextField();
		txtAadhaar.setBounds(206, 220+y, 195, 20);
		add(txtAadhaar);
		txtNumber.setColumns(10);
		
		
		
		JButton btnLogin = new JButton("Register");
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
		btnLogin.setBounds(312, 278+y, 89, 23);
		 add(btnLogin);
		
		JLabel lblOtp = new JLabel("OTP");
		lblOtp.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblOtp.setBounds(40, 314+y, 58, 20);
		 add(lblOtp);
		
		txtOtp = new JTextField();
		txtOtp.setBounds(206,316+y, 195, 23);
		 add(txtOtp);
		txtOtp.setColumns(10);
		
		JButton btnValidateOtp = new JButton("Validate OTP");
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
		 add(btnValidateOtp);
		
		
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
}
