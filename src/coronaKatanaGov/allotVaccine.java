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

import javax.swing.*;
import javax.swing.border.CompoundBorder;

import api.fun.getTotalVAccine;
import com.Myconnection.MyConnection;

import api.fun.DatePicker;

public class allotVaccine extends JPanel {
	
	
	public allotVaccine() {
		
		int x=0,y=0;
		JLabel add_vac=new JLabel("Add Vaccines to the Inventory:");
        add_vac.setFont(new Font("Georgia", Font.BOLD, 18));
        add_vac.setBounds(60+x,10+y,350,50);
        add(add_vac);
        
        JLabel lbl_quntity=new JLabel("Quantity:");
        lbl_quntity.setFont(new Font("Georgia", Font.BOLD, 16));
        lbl_quntity.setBounds(75,60+y,150,30);
        add(lbl_quntity);
        
        JLabel lbl_manfDT=new JLabel("Manufacture Date:");
        lbl_manfDT.setFont(new Font("Georgia", Font.BOLD, 16));
        lbl_manfDT.setBounds(350,60+y,180,30);
        add(lbl_manfDT);
        
        JLabel lbl_expfDT=new JLabel("Expiry Date:");
        lbl_expfDT.setFont(new Font("Georgia", Font.BOLD, 16));
        lbl_expfDT.setBounds(700,60+y,150,30);
        add(lbl_expfDT);
        
        JTextField txt_quntity=new JTextField();
        txt_quntity.setBounds(170,65+y,80,25);
        add(txt_quntity);
                
        JTextField txt_manfDT=new JTextField();
        txt_manfDT.setBounds(530,65+y,100,25);
        
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
        txt_expfDT.setBounds(830,63+y,100,25);
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
        
               
        
        JButton add_Vacc=new JButton("Add to Inventory");
        add_Vacc.setBounds(450+x,100,200,25);
		add_Vacc.setFont(new Font("Georgia", Font.BOLD, 18));
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
				if(k==1){
//					getTotalVAccine gtv=new getTotalVAccine();
//					AddVaccines.vacPanel.lbl_qty.setText("Available : "+gtv.getTotalVaccine());
					JOptionPane.showConfirmDialog(null, "Successfully Saved");
				}
				
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
        
        setBounds(80,525,1070,140);
		setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(0, 0, 0,0, Color.pink),
				BorderFactory.createMatteBorder(5, 0, 0, 0, Color.black)));
	}
	
//	public static void main(String[] args) {
//		new allotVaccine();
//		System.out.println("ksdkfj");
//	}
}
