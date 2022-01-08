package coronaKatana;

import javax.swing.*;

import java.awt.Font;
import java.awt.Color;

import com.Myconnection.MyConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;

import api.fun.Mail;
import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.util.Random;

/*
	class Login : for the login of the user for slot booking
					the class uses mail api for OTP validation
 */

public class Login extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	static int OTP;

	private JTextField txtName;
	private JTextField txtNumber;
	private JTextField txtOtp;
	private JTextField txtAadhaar;
	private JTextField txtEmail;
	private JLabel lblOtpSend;


	static JDialog dialog;



	public Login() {
		//setting up the layout and the dimensions
		int y=150;
		setBounds(830,50,626,670);
		setVisible(false);
		setLayout(null);
		//setBorder(BorderFactory.createLineBorder(new Color(51,54,69),40));
		setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(170, 80, 50, 80, new Color(0, 128, 255)),
				BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black)));
		setBackground(new Color(220, 208, 255));


		//adding required labels, textfields and buttons and their styling
		JLabel lblHeading=new JLabel("USER LOGIN",JLabel.CENTER);
		lblHeading.setBounds(80,70,466,100);
		lblHeading.setFont(new Font("Serif", Font.BOLD, 22));
		lblHeading.setForeground(Color.white);
		lblHeading.setBackground(Color.black);
		lblHeading.setOpaque(true);
		add(lblHeading);

		JLabel lblph=new JLabel("Contact No.       :");
		lblph.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblph.setBounds(121,100+y,150,28);
		add(lblph);

		JLabel lblEmail=new JLabel("Email              :");
		lblEmail.setFont(new Font("Verdana", Font.BOLD, 16));
		lblEmail.setBounds(121,160+y,150,28);
		add(lblEmail);

		JLabel lblOtp=new JLabel("Enter OTP       :");
		lblOtp.setFont(new Font("Verdana", Font.BOLD, 16));
		lblOtp.setBounds(121,280+y,150,28);
		add(lblOtp);

		txtNumber=new JTextField();
		txtNumber.setBounds(300,105+y,195,25);
		txtNumber.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtNumber.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237),1));
		add(txtNumber);

		txtEmail=new JTextField();
		txtEmail.setBounds(300,165+y,195,25);
		txtEmail.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtEmail.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237),1));
		add(txtEmail);

		txtOtp=new JTextField();
		txtOtp.setBounds(300,285+y,195,23);
		txtOtp.setFont(new Font("Verdana", Font.PLAIN, 14));
		txtOtp.setBorder(BorderFactory.createLineBorder(new Color(100, 149, 237),1));
		add(txtOtp);

		JLabel lbl_otp=new JLabel("");
		add(lbl_otp);
		lbl_otp.setBounds(230,200+y,130,20);
		lblOtpSend=new JLabel("");
		add(lblOtpSend);


		JButton btnotp=new JButton("Get OTP");
		add(btnotp);
		btnotp.setBounds(230,220+y,150,30);
		btnotp.setFont(new Font("Verdana", Font.BOLD, 15));
		btnotp.setForeground(Color.white);
		btnotp.setBackground(Color.black);
		btnotp.setOpaque(true);
		btnotp.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnotp.setBackground(Color.darkGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnotp.setBackground(Color.black);
			}
		});
		btnotp.setFocusPainted(false);
		lbl_otp.setForeground(Color.red);

		// btnotp's action listener
		btnotp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println("-->1234");
				String mob=txtNumber.getText().trim();
				String Email=txtEmail.getText().trim();
				Connection con=(Connection) MyConnection.getConn();
				int k=-1;
				if((mob.length()==10)&&(Email.length()>8)) {
					try {

						PreparedStatement stmt=(PreparedStatement) con.prepareStatement("select * from flogin where phone='"+mob+"' and email='"+Email+"'");
						stmt.executeQuery();
						lbl_otp.setText("");
						k=0;
					}catch(Exception e) {
						k=1;
						lbl_otp.setBounds(230,200+y,130,20);
						lbl_otp.setText("Please Enter Correct Deratils");
						System.out.println(e);
					}

				}else {
					k=1;
					lbl_otp.setBounds(230,200+y,130,20);
					lbl_otp.setText("Please Enter All Fields");

				}


				if(k==0) {
					Random rnd=new Random();
					OTP=rnd.nextInt(99999);
					System.out.println( "Creating message" );
					//String from="otpshishusharma@gmail.com";
					String to=txtEmail.getText();
					String sub="Testing javax.mail kancha.";
					String msg="This is System Generated Mail for COVID Vaccination and OTP is "+OTP+"";
					lblOtpSend.setBounds(300, 200+y, 195, 20);
					int check=Mail.sendMail(msg,sub,to);
					if(check==0) {

						lblOtpSend.setText("Please Enter Valid Email");
					}else {
						lblOtpSend.setText("OTP send to Eamil");
					}

				}
			}


		});



		JButton btnVali=new JButton("Login");
		btnVali.setBounds(230,340+y,150,30);
		add(btnVali);
		btnVali.setFont(new Font("Verdana", Font.BOLD, 15));
		btnVali.setForeground(Color.white);
		btnVali.setBackground(Color.black);
		btnVali.setOpaque(true);
		btnVali.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnVali.setBackground(Color.darkGray);
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnVali.setBackground(Color.black);
			}
		});
		btnVali.setFocusPainted(false);

		//btnVali's action listener
		btnVali.addActionListener(new ActionListener() {


			public void actionPerformed(ActionEvent arg0) {


				String aadhar = "";
				String nm = null;
				int status=0;
				if(Integer.parseInt(txtOtp.getText())==OTP){


					String mob=txtNumber.getText().trim();
					String Email=txtEmail.getText().trim();

					//Connecting to the database through the class MyConnection in com.MyConnection package
					Connection con=(Connection) MyConnection.getConn();

					try {

						//Verifying the user : user's entered data with the data already in the database
						ResultSet rs=con.prepareStatement("SELECT flogin.name as name,flogin.aadhaar as aadhaar ,"
								+ "aadhaar_status.status as stat FROM aadhaar_status INNER "
								+ "JOIN flogin WHERE flogin.phone='"+mob+"' and flogin.email='"+Email+"' "
								+ "and flogin.aadhaar=aadhaar_status.aadhar").executeQuery();



						//if successfully logged in, the user is displayed the user dashboard panel
						if(rs.next()) {


							aadhar=rs.getString("aadhaar");
							nm=rs.getString("name");
							status=rs.getInt("stat");


						}

						System.out.println("mob- "+mob+"email- "+Email+" Addahr- "+aadhar);
						FrontView.SWU.setVisible(false);
						FrontView.RRR.setVisible(true);
						FrontView.hm.setVisible(false);
						FrontView.SB.setVisible(false);
						FrontView.CL.setVisible(false);
						FrontView.cnt.setVisible(false);
						Loggedin.setUsername(nm);
						Loggedin.setAadhaar(aadhar);
						Loggedin.setMob(""+mob);
						Loggedin.setEmail(Email);
						Loggedin.setStatus(status);


						System.out.println(nm+" "+aadhar+" "+mob+" "+Email+" "+status);
//													  Loggedin LLL=new Loggedin();
//													  FrontView.f1.add(LLL);
//													  LLL.setVisible(true);
						JOptionPane jop = new JOptionPane();
						dialog = jop.createDialog("User : "+nm+"");
						dialog.setSize(1250, 730);
						dialog.setLocationRelativeTo(null);
						dialog.setContentPane(new Loggedin());
						dialog.setVisible(true);
						clearField();

					}catch(Exception e) {
						e.printStackTrace();
						System.out.println(e);
					}

				}else{
					//Informing the user in case of a wrong OTP entered
					FrontView.SB.setVisible(false);
					lbl_otp.setBounds(230,310+y,150,20);
					lbl_otp.setForeground(Color.red);
					lbl_otp.setText("UnValid OTP, ReEntered");
				}

			}


		});



	}

	//clearing the textfields after login completed
	public void clearField() {
		txtEmail.setText("");
		txtNumber.setText("");
		txtOtp.setText("");
		lblOtpSend.setText("");
	}



}
