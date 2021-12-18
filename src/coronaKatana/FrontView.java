package coronaKatana;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class FrontView extends JFrame
{
	public static JFrame f1;
	public Container c=getContentPane();
	static LeftPanel LP=new LeftPanel();
	static StateWiseUpdate SWU=new StateWiseUpdate();
	static Login LloginReg=new Login();
	static Login Llogin=new Login(1);
	//static LoginPanel LPanel=new LoginPanel();
	static Registration RRR=new Registration();
	//static Loggedin Loggin=new Loggedin(null,null,null,null,0);
	//=new Loggedin(null,null,null,null,0);
	
	public FrontView() {
		setLayout(null);
		setVisible(true);
		c.add(RRR);
		c.add(Llogin);
		f1=this;
		//c.add(f1=this);
	//	Loggin.setVisible(false);
		LloginReg.setVisible(false);
		//FrontView.Loggin.setVisible(false);
				LoginPanel.Llogin.setVisible(false);
				LoginPanel.LloginReg.setVisible(false);
				//Loggin.setVisible(false);
		setTitle("Login");
		//setExtendedState(JFrame.MAXIMIZED_BOTH);
		setMinimumSize(new Dimension(800, 600));
		setBounds(0,0,1450,720);
		c.add(LP);
		c.add(SWU);
		//c.add(LPanel);
		c.add(LoginPanel.LloginReg);
		
	//	c.add(Loggin);
	//	c.add(Loggin);
		//c.remove(Loggin);
		//c.add(Login.llll);
		
		
		//FrontView.Loggin.setVisible(false);
		LoginPanel.Llogin.setVisible(false);
		LoginPanel.LloginReg.setVisible(false);
		//Loggin.setVisible(false);
		
		c.add(f1=this);
		
	}
	
	public static void main(String[] args) {
		new FrontView();
	}
}

//start LeftPanel
	class LeftPanel extends JPanel {

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		
		Color clr=new Color(51,54,69);
		Color fnt=new Color(236, 240, 241);
		JLabel title =new JLabel("COVID \n TRACKER",JLabel.CENTER);
		
		
		JButton btnhome = new JButton("Home");
		
		JButton btnData = new JButton("State Wise Data");
		JButton vaccination = new JButton("Vaccination");
		JButton btnLogin = new JButton("Login/SignUp");
		JButton btnContact = new JButton("Contact Us");

		Cursor cursor=new Cursor(Cursor.HAND_CURSOR);
		public LeftPanel() {
			int w = 200;
			setLayout(null);
			setBounds(0, 0, w, 720);
			setBackground(clr);

			title.setBounds(0,0,w,100);
			title.setBackground(new Color(100, 149, 237));
			title.setForeground(Color.white);
			title.setFont(new Font("Serif", Font.BOLD, 20));

			btnhome.setBounds(0,150,w,50);
			btnhome.setForeground(fnt);
			add(btnhome);
			btnhome.setFont(new Font("Californian FB", Font.BOLD, 18));
			btnhome.setBorderPainted(false);
			btnhome.setBackground(clr);
			btnhome.setOpaque(true);
			btnhome.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					btnhome.setBackground(new Color(32, 35, 50));

					btnhome.setCursor(cursor);
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
					btnhome.setBackground(new Color(51, 54, 69));
				}
			});
			btnhome.setFocusPainted(false);
		
			btnData.setBounds(0, 200, w, 50);
			btnData.setForeground(fnt);
			btnData.setFont(new Font("Californian FB", Font.BOLD, 18));
			btnData.setBorderPainted(false);
			btnData.setBackground(clr);
			btnData.setOpaque(true);
			btnData.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					btnData.setBackground(new Color(32, 35, 50));

					btnData.setCursor(cursor);
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
					btnData.setBackground(new Color(51, 54, 69));
				}
			});
			btnData.setFocusPainted(false);

			vaccination.setBounds(0, 250, w, 50);
			vaccination.setForeground(fnt);
			vaccination.setFont(new Font("Californian FB", Font.BOLD, 18));
			vaccination.setBorderPainted(false);
			vaccination.setBackground(clr);
			vaccination.setOpaque(true);
			vaccination.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					vaccination.setBackground(new Color(32, 35, 50));
					vaccination.setCursor(cursor);
				}

				public void mouseExited(java.awt.event.MouseEvent evt) {
					vaccination.setBackground(new Color(51, 54, 69));
				}
			});
			vaccination.setFocusPainted(false);

			btnLogin.setBounds(0, 300, w, 50);
			btnLogin.setForeground(fnt);
			btnLogin.setFont(new Font("Californian FB", Font.BOLD, 18));
			btnLogin.setBorderPainted(false);
			btnLogin.setBackground(new Color(51, 54, 69));
			btnLogin.setOpaque(true);
			btnLogin.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					btnLogin.setBackground(new Color(32, 35, 50));
					btnLogin.setCursor(cursor);
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
					btnLogin.setBackground(new Color(51, 54, 69));
				}
			});
			btnLogin.setFocusPainted(false);


			btnContact.setBounds(0, 350, w, 50);
			btnContact.setForeground(fnt);
			btnContact.setFont(new Font("Californian FB", Font.BOLD, 18));
			btnContact.setBorderPainted(false);
			btnContact.setBackground(clr);
			btnContact.setOpaque(true);
			btnContact.addMouseListener(new java.awt.event.MouseAdapter() {
				public void mouseEntered(java.awt.event.MouseEvent evt) {
					btnContact.setBackground(new Color(32, 35, 50));

					btnContact.setCursor(cursor);
				}
				public void mouseExited(java.awt.event.MouseEvent evt) {
					btnContact.setBackground(new Color(51, 54, 69));
				}
			});
			btnContact.setFocusPainted(false);

			add(title);
			add(btnhome);
			add(btnData);
			add(vaccination);
			add(btnLogin);
			add(btnContact);

			btnhome.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					System.out.println("actioper");
//					HPLoginS.setVisible(false);
//					HP.setVisible(true);
					LoginPanel.LloginReg.setVisible(false);
					LoginPanel.Llogin.setVisible(false);
					FrontView.SWU.setVisible(true);
					//FrontView.LPanel.setVisible(false);
				//	FrontView.Loggin.setVisible(false);
					FrontView.RRR.setVisible(false);
					FrontView.Llogin.setVisible(false);
					
					
					
				
				}
			});
			vaccination.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					System.out.println("actioper");
//					HPLoginS.setVisible(false);
//					HP.setVisible(false);
//					HPChar.setVisible(true);
					System.out.println("1234");
					FrontView.SWU.setVisible(false);
					//FrontView.LPanel.setVisible(false);
				//FrontView.Loggin.setVisible(false);
					FrontView.RRR.setVisible(false);
					FrontView.Llogin.setVisible(false);
					
					
				}
			});

			btnLogin.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					System.out.println("actioper");
//					HP.setVisible(false);
//					HPLoginS.setVisible(true);
					FrontView.SWU.setVisible(false);
					//FrontView.LPanel.setVisible(true);
					FrontView.RRR.setVisible(true);
					FrontView.Llogin.setVisible(true);
					
				}
			});
		}
	}
//End LeftPanel
