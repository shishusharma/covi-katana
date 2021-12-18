package coronaKatana;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;


public class Loggedin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Loggedin() {}
	public static void main(String[] args) {
		new Loggedin("shishu","996480701485","7519308095","shishus808@gmail.com",0);
	}
	SlotBook SB;
	public Loggedin(String name, String aadhar, String phone, String email, int status) {
			setVisible(true);
			System.out.println("hello");
			JLabel lbl_name,lbl_aadhar,lbl_phone,lbl_email,lbl_status,lbl_full;
		    JButton btn_vac;
		    
		    Border blackline = BorderFactory.createLineBorder(Color.black);
	        setBounds(200,0,1450,720);
	        setBackground(new Color(215, 189, 226));
	        
	        setLayout(null);

	        setVisible(true);

			 JLabel lbl_header,lbl_details;
			 	lbl_header=new JLabel("USER DASHBOARD",JLabel.CENTER);
		        lbl_header.setBounds(0,0,1450,100);
		        lbl_header.setFont(new Font("Serif", Font.BOLD, 20));
		        lbl_header.setForeground(new Color(247,249,249));
		        lbl_header.setBackground(new Color(46, 134, 193));
		        lbl_header.setOpaque(true);
		        add(lbl_header);
		        
		        int x=0,y=150;
		        lbl_details=new JLabel("User Details :",JLabel.RIGHT);
		        lbl_details.setFont(new Font("Georgia", Font.BOLD, 18));
		        lbl_details.setBounds(x,y,150,30);
		        add(lbl_details);
	        
	        lbl_name=new JLabel("Name   :     "+name,JLabel.LEFT);
	        lbl_name.setFont(new Font("Georgia", Font.BOLD, 18));
	        lbl_name.setBounds(x+30,y+30,400,30);
	        add(lbl_name);

	        lbl_aadhar=new JLabel("Aadhar :     "+aadhar,JLabel.LEFT);
	        lbl_aadhar.setFont(new Font("Georgia", Font.BOLD, 18));
	        lbl_aadhar.setBounds(x+30,y+70,400,30);
	        add(lbl_aadhar);

	        lbl_phone=new JLabel("Phone  :     "+phone,JLabel.LEFT);
	        lbl_phone.setFont(new Font("Georgia", Font.BOLD, 18));
	        lbl_phone.setBounds(x+30,y+110,400,30);
	        add(lbl_phone);

	        lbl_email=new JLabel("E-mail :     "+email,JLabel.LEFT);
	        lbl_email.setFont(new Font("Georgia", Font.BOLD, 18));
	        lbl_email.setBounds(x+30,y+150,400,30);
	        add(lbl_email);

	        lbl_status=new JLabel("Status :     "+status,JLabel.LEFT);
	        lbl_status.setFont(new Font("Georgia", Font.BOLD, 18));
	        lbl_status.setBounds(x+30,y+190,400,30);
	        add(lbl_status);

	        /*
	            This label will be used if the user is fully Vaccinated.
	         */
	        lbl_full=new JLabel("You are fully vaccinated!",JLabel.LEFT);
	        lbl_full.setFont(new Font("Georgia", Font.CENTER_BASELINE, 18));
	        lbl_full.setForeground(new Color(0,100,0));
	        lbl_full.setBounds(x+80,y+230,300,30);

	        btn_vac=new JButton();
	        add(btn_vac);
	        if(status==0)
	        {
	            btn_vac.setText("Get Vaccinated");
	            btn_vac.addActionListener(new ActionListener() {
	            	public void actionPerformed(ActionEvent arg0) {
	            		LoginPanel.LloginReg.setVisible(false);
						LoginPanel.Llogin.setVisible(false);
						FrontView.SWU.setVisible(false);
						FrontView.RRR.setVisible(false);
						FrontView.Llogin.setVisible(false);
						
	            		setVisible(false);
	            		SB=new SlotBook(aadhar);
	            		SB.setVisible(true);
						FrontView.f1.add(SB);
	            		
	            	}
	            });
	        }
	        else if(status==1)
	        {
	            btn_vac.setText("Get 2nd Dose");
	        }
	        else
	        {
	            btn_vac.setVisible(false);
	            add(lbl_full);
	        }
	        btn_vac.setFont(new Font("Arial", Font.BOLD, 18));
	        btn_vac.setBounds(x+80,y+230,200,30);
	        btn_vac.setBackground(new Color(93,173,226));
	        btn_vac.setHideActionText(true);
	        btn_vac.setOpaque(true);
	        btn_vac.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					new SlotBook();
					
				}
	        	
	        });
	        
	        btn_vac.addMouseListener(new java.awt.event.MouseAdapter() {
	            public void mouseEntered(java.awt.event.MouseEvent evt) {
	                btn_vac.setBackground(new Color(46,134,193));
	            }

	            public void mouseExited(java.awt.event.MouseEvent evt) {
	                btn_vac.setBackground(new Color(93,173,226));
	            }
	        });
	        btn_vac.setFocusPainted(true);
	        
	           
	      
		        
	}

	
}





