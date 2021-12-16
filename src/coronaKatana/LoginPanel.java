package coronaKatana;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class LoginPanel extends JPanel {
	static Login LloginReg=new Login();
	static Login Llogin=new Login(1);
	
	
	public LoginPanel() {
		setLayout(null);
		setVisible(true);
		setBounds(200,0,1250,720);
		Llogin.setVisible(true);
		//LloginReg.setVisible(true);
		
		
		
		
//		JButton NewReg = new JButton("New Registration");
//		NewReg.setBounds(100, 0, 200, 50);
//		NewReg.setBackground(Color.red);
//		add(NewReg);
//		
//		NewReg.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				System.out.println("NewReg");
//				setVisible(false);
//				LoginPanel.Llogin.setVisible(false);
//				LoginPanel.LloginReg.setVisible(true);
//				
//				
//			}
//		});

//		JButton clientLogin = new JButton("Login");
//		clientLogin.setBounds(400, 0, 200, 50);
//		clientLogin.setBackground(Color.blue);
//		add(clientLogin);
//		
//		
//		clientLogin.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent arg0) {
//				System.out.println("clientLogin");
//				setVisible(false);
//				LoginPanel.LloginReg.setVisible(false);
//				LoginPanel.Llogin.setVisible(true);
//				
//				
//			}
//		});
	}
}
