package coronaKatanaGov;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.Myconnection.MyConnection;

import api.fun.DatePicker;

public class allotVaccine extends JPanel{
	
	
	
	
	public allotVaccine() {
		
		int x=0,y=0;
		JLabel add_vac=new JLabel("Add Vaccine");
        add_vac.setFont(new Font("Georgia", Font.BOLD, 18));
        add_vac.setBounds(70+x,0+y,150,70);
        add(add_vac);
        
        JLabel lbl_quntity=new JLabel("Quntity:");
        lbl_quntity.setFont(new Font("Georgia", Font.BOLD, 13));
        lbl_quntity.setBounds(x+0,30+y,150,70);
        add(lbl_quntity);
        
        JLabel lbl_manfDT=new JLabel("Manufacture Date:");
        lbl_manfDT.setFont(new Font("Georgia", Font.BOLD, 13));
        lbl_manfDT.setBounds(x+0,70+y,150,70);
        add(lbl_manfDT);
        
        JLabel lbl_expfDT=new JLabel("Expiry Date:");
        lbl_expfDT.setFont(new Font("Georgia", Font.BOLD, 13));
        lbl_expfDT.setBounds(x+0,110+y,150,70);
        add(lbl_expfDT);
        
        JTextField txt_quntity=new JTextField();
        txt_quntity.setBounds(x+160,50+y,130,25);
        add(txt_quntity);
                
        JTextField txt_manfDT=new JTextField();
        txt_manfDT.setBounds(x+160,90+y,130,25);
        
        add(txt_manfDT);
        
        txt_manfDT.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				final JFrame f = new JFrame();
				txt_manfDT.setText(new DatePicker(f).setPickedDate());
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}  
        });
        
        
        
        JTextField txt_expfDT=new JTextField();
        txt_expfDT.setBounds(x+160,130+y,130,25);
        add(txt_expfDT);
        
        txt_expfDT.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				final JFrame f = new JFrame();
				txt_expfDT.setText(new DatePicker(f).setPickedDate());
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
				
			}
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}  
        });
        
               
        
        JButton add_Vacc=new JButton("ADD");
        add_Vacc.setBounds(150+x,160,70,25);
        add_Vacc.setBackground(new Color(93,173,226));
        add_Vacc.setOpaque(true);
        add(add_Vacc);
        
        add_Vacc.addActionListener(new ActionListener() {

//        	int cnt=Integer.parseInt(txt_quntity.getText());
//        	String manu=txt_manfDT.getText();
//        	String exp=txt_expfDT.getText();
			@Override
			public void actionPerformed(ActionEvent e) {
				if((Integer.parseInt(txt_quntity.getText())>0)&&(txt_manfDT.getText()!=null)&&(txt_expfDT.getText()!=null)) {
				Connection con=MyConnection.getConn();
				PreparedStatement ps;
				int k=0;
				try {
					ps = con.prepareStatement("{call proaddvaccine(?,?,?)}");
					ps.setInt(1, Integer.parseInt(txt_quntity.getText()));
					ps.setString(2, txt_manfDT.getText());
					ps.setString(3, txt_expfDT.getText());
					ps.executeUpdate();
					
					txt_expfDT.setText("");
					txt_quntity.setText("");
					txt_manfDT.setText("");
					k=1;
					
					
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(k==1)
					JOptionPane.showConfirmDialog(null, "Successfully Saved");
					
				
			}
				
			}
        	
        });
        
        JButton btn_reset=new JButton("Reset");
        btn_reset.setBounds(70+x,160,70,25);
        btn_reset.setBackground(new Color(93,173,226));
        btn_reset.setOpaque(true);
        add(btn_reset);
        
        
        btn_reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txt_expfDT.setText("");
				txt_quntity.setText("");
				txt_manfDT.setText("");
				
			}
        	
        });
        
        setLayout(null);
        setBackground(new Color(204,153,255));
        setVisible(true);
        
        setBounds(720,300,300,200);
	}
	
//	public static void main(String[] args) {
//		new allotVaccine();
//		System.out.println("ksdkfj");
//	}
}
