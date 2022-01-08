package coronaKatana;

import com.Myconnection.MyConnection;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;

/*
	class LoggedIn : this class acts as the user dashboard after
					 a user has successfully logged in.
					 Displays all the information of the user and a status for the
					 user whether he has just registered, booked 1st dose , booked 2nd dose or full vaccinated.
					 Butttons are provided to book slots and download vaccination certificates.
 */

public class Loggedin extends JPanel {
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public static String username,aadhaar,mob,email;
	public static int status;
	String fDoseAdd,fDoseVacid,fdosenurse;

	//establishing the connection with database
	Connection con=(Connection) MyConnection.getConn();
	JDialog dialog1;

	//getter methods
	public static String getUsername() {
		return username;
	}
	public static void setUsername(String username) {
		Loggedin.username = username;
	}
	public static String getAadhaar() {
		return aadhaar;
	}
	public static void setAadhaar(String aadhaar) {
		Loggedin.aadhaar = aadhaar;
	}
	public static String getMob() {
		return mob;
	}
	public static void setMob(String mob) {
		Loggedin.mob = mob;
	}
	public static String getEmail() {
		return email;
	}
	public static void setEmail(String email) {
		Loggedin.email = email;
	}
	public static int getStatus() {
		return status;
	}
	public static void setStatus(int status) {
		Loggedin.status = status;
	}


	public Loggedin() {

		//setting up the layout and the dimensions
		setLayout(null);

		setVisible(true);

		//just for testing purpose
		System.out.println("Email "+getEmail());
		System.out.println("hello");



		//adding labels and buttons and their styling
		JLabel lbl_name,lbl_aadhar,lbl_phone,lbl_email,lbl_status,lbl_full;
		JButton btn_fDoseCir,btn_sDoseCir;

		Border blackline = BorderFactory.createLineBorder(Color.black);
		setBounds(200,50,1250,670);
		setBackground(new Color(0, 128, 255));
		setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(70, 0, 0, 0, new Color(0, 128, 255)),
				BorderFactory.createMatteBorder(5, 0, 0, 0, Color.black)));



		int x=0,y=150;

		JLabel lbl_header,lbl_details;
		lbl_header=new JLabel("User Dashboard",JLabel.LEFT);
		add(lbl_header);
		lbl_header.setBounds(100,0,1250,90);
		lbl_header.setFont(new Font("Serif", Font.BOLD, 20));
		lbl_header.setForeground(Color.white);

		//Background Label
		JLabel bg_label=new JLabel();
		bg_label.setBackground(new Color(255, 253, 208));
		bg_label.setBounds(150,120,900,500);
		bg_label.setOpaque(true);
		bg_label.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
		add(bg_label);

//		lbl_details=new JLabel("User Details :",JLabel.RIGHT);
//		lbl_details.setFont(new Font("Georgia", Font.BOLD, 18));
//		lbl_details.setBounds(x,y,150,30);
//		add(lbl_details);
		lbl_details=new JLabel("User Details",JLabel.CENTER);
		add(lbl_details);
		lbl_details.setBounds(100,30,700,30);
		lbl_details.setFont(new Font("Serif", Font.BOLD, 25));
		lbl_details.setForeground(Color.black);
		lbl_details.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black),
				BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white)));
		bg_label.add(lbl_details);

		lbl_name=new JLabel("Name    :     "+getUsername(),JLabel.LEFT);
		lbl_name.setFont(new Font("Serif", Font.BOLD, 20));
		lbl_name.setBounds(50,110,300,30);
		add(lbl_name);
		bg_label.add(lbl_name);

		lbl_aadhar=new JLabel("Aadhar :     "+getAadhaar(),JLabel.LEFT);
		lbl_aadhar.setFont(new Font("Serif", Font.BOLD, 20));
		lbl_aadhar.setBounds(50,150,300,30);
		add(lbl_aadhar);
		bg_label.add(lbl_aadhar);

		lbl_phone=new JLabel("Phone   :     "+getMob(),JLabel.LEFT);
		lbl_phone.setFont(new Font("Serif", Font.BOLD, 20));
		lbl_phone.setBounds(50,190,250,30);
		add(lbl_phone);
		bg_label.add(lbl_phone);

		lbl_email=new JLabel("E-mail  :     "+getEmail(),JLabel.LEFT);
		lbl_email.setFont(new Font("Serif", Font.BOLD, 20));
		lbl_email.setBounds(50,230,400,30);
		add(lbl_email);
		bg_label.add(lbl_email);

		lbl_status=new JLabel("Status  :     "+getStatus(),JLabel.LEFT);
		lbl_status.setFont(new Font("Serif", Font.BOLD, 20));
		lbl_status.setBounds(50,270,300,30);
		add(lbl_status);
		bg_label.add(lbl_status);

		JLabel lbl_action=new JLabel("Action  :     ",JLabel.LEFT);
		lbl_action.setFont(new Font("Serif", Font.BOLD, 20));
		lbl_action.setBounds(450,110,300,30);
		add(lbl_action);
		bg_label.add(lbl_action);

		JLabel lbl_down=new JLabel("Download  :     ",JLabel.LEFT);
		lbl_down.setFont(new Font("Serif", Font.BOLD, 20));
		lbl_down.setBounds(450,170,300,30);
		add(lbl_down);
		bg_label.add(lbl_down);
        /*
            This label will be used if the user is fully Vaccinated.
         */
		lbl_full=new JLabel("",JLabel.CENTER);
		lbl_full.setFont(new Font("Serif", Font.CENTER_BASELINE, 20));
		lbl_full.setForeground(new Color(0,100,0));
		lbl_full.setBounds(x+80,310,600,30);






		btn_fDoseCir=new JButton("First Dose Certificate");
		btn_sDoseCir=new JButton("Second Dose Certificate");
//		status=3;

		JButton btn_vac=new JButton();
		add(btn_vac);
		btn_vac.setFont(new Font("Serif", Font.BOLD, 18));
		btn_vac.setBounds(560,110,200,30);
		btn_vac.setBackground(new Color(93,173,226));
		btn_vac.setOpaque(true);
		btn_vac.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
		bg_label.add(btn_vac);

		btn_vac.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_vac.setBackground(new Color(46,134,193));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btn_vac.setBackground(new Color(93,173,226));
			}
		});
		btn_vac.setFocusPainted(true);

		if(status==-1)
		{
			btn_vac.setText("Book 1st Dose");
			lbl_full.setText("Get your First Dose Now!");

		}else if(status==0){
			lbl_full.setText("First Dose Booked Check Your Mail For more Details");
			btn_vac.setVisible(false);
		}
		else if(status==1)
		{

			btn_vac.setText("Book 2nd Dose");
			lbl_full.setText("First Dose Received!");
		}else if(status==3) {
			lbl_full=new JLabel("You are fully vaccinated!",JLabel.LEFT);
			add(lbl_full);
			btn_vac.setVisible(false);
			lbl_full.setFont(new Font("Georgia", Font.CENTER_BASELINE, 18));
			lbl_full.setForeground(new Color(0,100,0));
			lbl_full.setBounds(x+80,y+230,300,30);
			lbl_full.setBorder(new CompoundBorder(
					BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black),
					BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white)));
		}
		else
		{

			btn_vac.setVisible(false);
		}

//
		bg_label.add(lbl_full);




		btn_vac.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				//Logged In panel closes and slot book panel is visible to the users
				Login.dialog.dispose();
				FrontView.SWU.setVisible(false);
				FrontView.RRR.setVisible(true);

				setVisible(false);
				SlotBook.setAadhaar(getAadhaar());




				JOptionPane jop = new JOptionPane();
				JDialog dialog = jop.createDialog("");
				dialog.setSize(1250, 730);
				dialog.setLocationRelativeTo(null);
				SlotBook.setStat(1);
				dialog.setContentPane(new SlotBook());
				dialog.setVisible(true);


				Loggedin.setUsername(getUsername());
				Loggedin.setAadhaar(getAadhaar());
				Loggedin.setMob(getMob());
				Loggedin.setEmail(getEmail());
				try {
					ResultSet rs=con.prepareStatement("select status from aadhaar_status").executeQuery();
					if(rs.next())
						Loggedin.setStatus(Integer.parseInt(rs.getString(1)));
				}catch (Exception ex){
					System.out.println(ex);
				}
				dialog.dispose();

				JOptionPane jop1 = new JOptionPane();
				dialog1 = jop1.createDialog("");
				dialog1.setSize(1250, 730);
				dialog1.setLocationRelativeTo(null);
				dialog1.setContentPane(new Loggedin());
				dialog1.setVisible(true);


			}
		});





		//for download first dose certificate
		btn_fDoseCir.setEnabled(false);
		btn_sDoseCir.setEnabled(false);
		if(status>=1) {
			btn_fDoseCir.setEnabled(true);
		}
		if(status>=3) {
			btn_sDoseCir.setEnabled(true);
			btn_fDoseCir.setEnabled(true);
		}
		add(btn_fDoseCir);
		btn_fDoseCir.setFont(new Font("Arial", Font.BOLD, 18));
		btn_fDoseCir.setBounds(560,170,250,30);
		btn_fDoseCir.setBackground(new Color(93,173,226));
		btn_fDoseCir.setHideActionText(true);
		bg_label.add(btn_fDoseCir);
		btn_fDoseCir.setOpaque(true);
		bg_label.add(btn_fDoseCir);
		btn_fDoseCir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPdfdetails();
				setFistDose();
				try {
					new PdfGenerator();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showConfirmDialog(null, "First Dose Cirtificate");

				JOptionPane.showConfirmDialog(null, "First Dose Certificate");

			}

		});

		btn_fDoseCir.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_fDoseCir.setBackground(new Color(46,134,193));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btn_fDoseCir.setBackground(new Color(93,173,226));
			}
		});
		btn_fDoseCir.setFocusPainted(true);


		//for download Second dose certificate
		add(btn_sDoseCir);
		btn_sDoseCir.setFont(new Font("Arial", Font.BOLD, 18));
		btn_sDoseCir.setBounds(560,220,250,30);
		btn_sDoseCir.setBackground(new Color(93,173,226));
		btn_sDoseCir.setHideActionText(true);
		btn_sDoseCir.setOpaque(true);
		bg_label.add(btn_sDoseCir);
		btn_sDoseCir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPdfdetails();
				setFistDose();
				setPdfdetails();
				try {
					new PdfGenerator();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showConfirmDialog(null, "Second Dose Cirtificate");


				JOptionPane.showConfirmDialog(null, "Second Dose Certificate");

			}

		});

		btn_sDoseCir.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btn_sDoseCir.setBackground(new Color(46,134,193));
			}

			public void mouseExited(java.awt.event.MouseEvent evt) {
				btn_sDoseCir.setBackground(new Color(93,173,226));
			}
		});
		btn_sDoseCir.setFocusPainted(true);

		JButton logout =new JButton("Logout");
		add(logout);
		logout.setBounds(1100,30,100,30);

		logout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Login.dialog.dispose();
				dialog1.dispose();

			}
		});



	}

	//setting up the details which will be present in the vaccination certificate
	public void setPdfdetails() {
		try {
			PreparedStatement stmt=(PreparedStatement)con.prepareStatement("SELECT flogin.name as name,flogin.email as email,flogin.aadhaar as aadhaar"
					+ ",STATUS as stat,fDoseDT,sDoseDT FROM flogin"
					+ " INNER JOIN aadhaar_status ass ON flogin.aadhaar=ass.aadhar AND ass.aadhar='"+aadhaar+"' ");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				PdfGenerator.setName(rs.getString("name"));
				PdfGenerator.setEmail(rs.getString("email"));
				PdfGenerator.setAadhaar(rs.getString("aadhaar"));
				PdfGenerator.setVaccince_Status(rs.getString("stat"));
				PdfGenerator.setfDoseDT(rs.getString("fDoseDT"));
				PdfGenerator.setsDoseDt(rs.getString("sDoseDT"));
				System.out.println("just chaek "+rs.getString(2));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void setFistDose() {
		try {
			PreparedStatement stmt=(PreparedStatement)con.prepareStatement("SELECT adv.center_Name as centernm,adv.center_Area as area,adv.center_Pincode as pincode,adv.center_state as state,vac_id as vacid,vaccine.vaccinated_By as nurse FROM vaccine\r\n"
					+ "INNER JOIN addvaccinecenter adv ON vaccine.alloted_cen=adv.center_id AND vaccine.alloted_per_id='"+aadhaar+"' ORDER BY dose ASC LIMIT 1; ");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				fDoseAdd=rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(4)+" "+rs.getString(3)+" ";
				PdfGenerator.setfDoseVacBy(rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(4)+" "+rs.getString(3)+" ");
				fdosenurse=rs.getString("nurse");
				PdfGenerator.setfDoseVacBy(rs.getString("nurse"));
				fDoseVacid=rs.getString("vacid");

			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void setSecDose() {
		try {
			PreparedStatement stmt=(PreparedStatement)con.prepareStatement("SELECT adv.center_Name as centernm,adv.center_Area as area,adv.center_Pincode as pincode,adv.center_state as state,vac_id as vacid,vaccine.vaccinated_By as nurse FROM vaccine\r\n"
					+ "INNER JOIN addvaccinecenter adv ON vaccine.alloted_cen=adv.center_id AND vaccine.alloted_per_id='"+aadhaar+"' ORDER BY dose ASC LIMIT 1; ");
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				PdfGenerator.setsDoseAdd(fDoseAdd+"  "+rs.getString(1)+" "+rs.getString(2)+" "+rs.getString(4)+" "+rs.getString(3)+" ");
				PdfGenerator.setfDoseVacBy(fdosenurse+"    "+rs.getString("nurse"));
				PdfGenerator.setfDoseVacId(fDoseVacid);
				PdfGenerator.setsDoseVacId(rs.getString("vacid"));
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}



}





