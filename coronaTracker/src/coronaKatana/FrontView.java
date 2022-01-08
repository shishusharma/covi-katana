package coronaKatana;

import coronaKatanaGov.AdminLogin;
import hospitalEnd.CenterLogin;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.*;
import java.awt.*;


import java.awt.event.*;

/*
	class FrontView : The execution of the project begins from this  class.
					  It inherits the JFrame class in order to display a frame on the screen.
					  Various panels in this project are displayed on this frame only.
 */

public class FrontView extends JFrame
{



	public static JFrame f1;

	//Making static objects of various classes to be used
	public static LeftPanel LP=new LeftPanel();
	public static Titlebar TB=new Titlebar();

	public static StateWiseUpdate SWU=new StateWiseUpdate();
	public static Login Llogin=new Login();
	//static LoginPanel LPanel=new LoginPanel();
	public static home hm=new home();
	public static Registration RRR=new Registration();

	public static Loggedin LI=new Loggedin();
	public static SlotBook SB=new SlotBook();
	public static AdminLogin AL=new AdminLogin();
	public static CenterLogin CL=new CenterLogin();
	public static contact cnt=new contact();
	//public static javachart JC=new javachart();

	//Creating a Container
	public Container c=getContentPane();


	//Constructor of the FrontView class
	public FrontView() {


		//Hide the default title bar. A custom title bar is made in class Titlebar.
		setUndecorated(true);

		//Defining the layout and dimensions
		setLayout(null);
		setVisible(true);
		TB.setVisible(true);
		f1=this;
		setTitle("Login");

		setMinimumSize(new Dimension(800, 600));
		setBounds(50,50,1450,720);

		//Adding the panels to the Container
		c.add(LP);
		c.add(TB);
		c.add(RRR);
		c.add(Llogin);
		c.add(SB);
		c.add(SWU);
		c.add(hm);
		c.add(AL);
		c.add(CL);
		c.add(cnt);
		c.add(f1=this);

	}

	/*
		The main() function to begin the execution.
	 */
	public static void main(String[] args) {
		new FrontView();


	}
}

/*
	class LeftPanel : Inherits the JPanel class.
					  This class displays the sidebar/menu which helps in navigating
					  through the project.
 */

class LeftPanel extends JPanel
{

	private static final long serialVersionUID = 1L;

	//Custom color variables
	Color clr=new Color(51,54,69);
	Color fnt=new Color(236, 240, 241);


	/*
		Various labels and button added and their styling.
	 */
	JLabel title =new JLabel("COVID \n TRACKER",JLabel.CENTER);


	JButton btnhome = new JButton("Home");
	JButton btnData = new JButton("State Wise Data");
	JButton vaccination = new JButton("Vaccination Slots");
	JButton btnLogin = new JButton("Login/SignUp");
	JButton btnAdministrator = new JButton("Administrator");
	JButton btnCenter = new JButton("Center Login");
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

		btnAdministrator.setBounds(0, 350, w, 50);
		btnAdministrator.setForeground(fnt);
		btnAdministrator.setFont(new Font("Californian FB", Font.BOLD, 18));
		btnAdministrator.setBorderPainted(false);
		btnAdministrator.setBackground(clr);
		btnAdministrator.setOpaque(true);
		btnAdministrator.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnAdministrator.setBackground(new Color(32, 35, 50));

				btnAdministrator.setCursor(cursor);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnAdministrator.setBackground(new Color(51, 54, 69));
			}
		});
		btnAdministrator.setFocusPainted(false);

		btnCenter.setBounds(0, 400, w, 50);
		btnCenter.setForeground(fnt);
		btnCenter.setFont(new Font("Californian FB", Font.BOLD, 18));
		btnCenter.setBorderPainted(false);
		btnCenter.setBackground(clr);
		btnCenter.setOpaque(true);
		btnCenter.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent evt) {
				btnCenter.setBackground(new Color(32, 35, 50));

				btnCenter.setCursor(cursor);
			}
			public void mouseExited(java.awt.event.MouseEvent evt) {
				btnCenter.setBackground(new Color(51, 54, 69));
			}
		});
		btnCenter.setFocusPainted(false);

		btnContact.setBounds(0, 450, w, 50);
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



		//Adding the buttons and labels to the panel.
		add(title);
		add(btnhome);
		add(btnData);
		add(vaccination);
		add(btnLogin);
		add(btnContact);
		add(btnAdministrator);
		add(btnCenter);

		//Action Listeners of all the buttons available in the menu.
		btnhome.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.out.println("actioper");
//
				FrontView.SB.setVisible(false);
				FrontView.CL.setVisible(false);

				FrontView.SWU.setVisible(false);

				FrontView.RRR.setVisible(false);
				FrontView.Llogin.setVisible(false);
				FrontView.hm.setVisible(true);




			}
		});
		btnData.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.out.println("actioper");
//					HPLoginS.setVisible(false);
//					HP.setVisible(true);

				FrontView.CL.setVisible(false);

				FrontView.SB.setVisible(false);
				FrontView.SWU.setVisible(true);
				FrontView.hm.setVisible(false);
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
				FrontView.CL.setVisible(false);
				FrontView.hm.setVisible(false);
				//FrontView.LPanel.setVisible(false);
				//FrontView.Loggin.setVisible(false);
				FrontView.RRR.setVisible(false);
				FrontView.Llogin.setVisible(false);
				FrontView.SB.setVisible(true);


			}
		});

		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.out.println("actioper");

				FrontView.SWU.setVisible(false);
				FrontView.CL.setVisible(false);
				//FrontView.LPanel.setVisible(true);
				FrontView.SB.setVisible(false);
				FrontView.RRR.setVisible(true);
				FrontView.Llogin.setVisible(true);
				FrontView.hm.setVisible(false);
				FrontView.AL.setVisible(false);

			}
		});

		btnAdministrator.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.out.println("actioper");
//					HP.setVisible(false);
//					HPLoginS.setVisible(true);
				FrontView.SB.setVisible(false);
				FrontView.SWU.setVisible(false);
				//FrontView.LPanel.setVisible(true);
				FrontView.RRR.setVisible(false);
				FrontView.Llogin.setVisible(false);
				FrontView.hm.setVisible(false);
				FrontView.CL.setVisible(false);
				FrontView.AL.setVisible(true);

			}
		});
		btnCenter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.out.println("actioper");
//					HP.setVisible(false);
//					HPLoginS.setVisible(true);
				FrontView.SB.setVisible(false);
				FrontView.SWU.setVisible(false);
				//FrontView.LPanel.setVisible(true);
				FrontView.RRR.setVisible(false);
				FrontView.Llogin.setVisible(false);
				FrontView.hm.setVisible(false);
				FrontView.AL.setVisible(false);
				FrontView.CL.setVisible(true);

			}
		});
		btnContact.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
//				System.out.println("actioper");
//					FrontView.HP.setVisible(false);
//					HPLoginS.setVisible(true);
				FrontView.SWU.setVisible(false);
				FrontView.RRR.setVisible(false);
				FrontView.Llogin.setVisible(false);
				FrontView.hm.setVisible(false);
				FrontView.SB.setVisible(false);
				FrontView.AL.setVisible(false);
				FrontView.CL.setVisible(false);
				FrontView.SB.setVisible(false);
				FrontView.SWU.setVisible(false);

				FrontView.cnt.setVisible(true);

			}
		});
	}
}
	/*
		class Titlebar : inherits the JPanel class.
						 This class is to make a custom title bar for the project having
						 the drag feature and a close button.

	 */
class Titlebar extends JPanel{
		static Point compcords;
	public Titlebar()
	{
		setLayout(null);
		setVisible(true);
		setBounds(200, 0, 1250, 50);
		setBackground(Color.white);
		compcords=null;

		//Mouse events to implement the drag feature of the title bar
		this.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				compcords=null;
			}

			@Override
			public void mousePressed(MouseEvent e) {
				compcords=e.getPoint();
			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}
		});

		this.addMouseMotionListener(new MouseMotionListener() {
			@Override
			public void mouseDragged(MouseEvent e) {
				Point curcords=e.getLocationOnScreen();
				FrontView.f1.setLocation(curcords.x-compcords.x,curcords.y-compcords.y);
			}

			@Override
			public void mouseMoved(MouseEvent e) {

			}
		});


		//Custom titlebar heading
		JLabel mainhead=new JLabel("#UniteToFightCorona",JLabel.CENTER);
		mainhead.setBounds(30,0,300,40);
		mainhead.setFont(new Font("Serif", Font.BOLD, 22));
		mainhead.setForeground(Color.black);
		mainhead.setBackground(Color.white);
		mainhead.setOpaque(true);
		add(mainhead);


		//Adding a custom close button with the help of a label.
		JLabel l1=new JLabel();
		l1.setBounds(1200,10,40,30);
		l1.setForeground(Color.white);
		l1.setBackground(Color.white);
		l1.setOpaque(true);
		//l1.setBorder(BorderFactory.createLineBorder(new Color(	51,54,69),5));
		Imagescale icon = new Imagescale( new ImageIcon(FrontView.class.getResource("/close48.png")));
		l1.setIcon( icon );
		//l1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\LEO\\Desktop\\close48.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
		add(l1);

		l1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				l1.setBackground(Color.red);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				l1.setBackground(Color.white);
			}
		});


	}
}

//End LeftPanel
