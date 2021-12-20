package hospitalEnd;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.Myconnection.MyConnection;

import api.fun.DatePicker;
import api.fun.getTotalVAccine;
import coronaKatanaGov.allotVaccine;

public class CenterLoggedin extends JFrame{
	static String center_Id,center_State,center_Dist,center_Area,center_NM,center_PIN;
	public static void main(String[] args) {
		new CenterLoggedin();
	}
//	public class InputDialog {
//	    public static void main(String[] args) {
//	        String input = JOptionPane.showInputDialog("Enter Input:");
//	        System.out.println(input);
//	    }
//	}
	public CenterLoggedin() {
		setLayout(null);
		setBounds(0,0,1250,720);
		setVisible(true);
		int len=0;
		String nurse;
		do {
		nurse = JOptionPane.showInputDialog("Enter Nurse Name:");
		len=nurse.length();
		}while(len<3);
		//int len=input.length();
		
		JLabel lbl_header=new JLabel( getCenter_NM()+" , "+getCenter_Id()+" , VACCINE CEENTER "+getCenter_Dist(),JLabel.CENTER);
		add(lbl_header);
		lbl_header.setBounds(0,0,1450,100);		
        lbl_header.setFont(new Font("Serif", Font.BOLD, 20));
        lbl_header.setForeground(new Color(247,249,249));
        lbl_header.setBackground(new Color(46, 134, 193));
        lbl_header.setOpaque(true);
        
        int x=0,y=0;
        JLabel lbl_nurse=new JLabel("Today Nurse : "+nurse);
        add(lbl_nurse);
        lbl_nurse.setBounds(250,110,250,30);
        lbl_nurse.setFont(new Font("Black", Font.BOLD, 20));
        lbl_nurse.setForeground(new Color(247,50,249));       
        lbl_nurse.setOpaque(true); 
        
        
        JLabel lbl_CenterDtl=new JLabel("Center Details :");
        add(lbl_CenterDtl);
        lbl_CenterDtl.setBounds(10+x,110+y,200,30);
        lbl_CenterDtl.setFont(new Font("Black", Font.BOLD, 20));
        lbl_CenterDtl.setForeground(new Color(247,50,249));       
        lbl_CenterDtl.setOpaque(true); 
        
        JLabel lbl_CenterNM=new JLabel("Name : "+getCenter_NM());
        add(lbl_CenterNM);
        lbl_CenterNM.setBounds(20+x,140+y,250,30);
        lbl_CenterNM.setFont(new Font("Black", Font.BOLD, 20));
        lbl_CenterNM.setForeground(new Color(26,50,249)); 
        
        JLabel lbl_CenterID=new JLabel("ID : "+getCenter_Id());
        add(lbl_CenterID);
        lbl_CenterID.setBounds(20+x,170+y,250,30);
        lbl_CenterID.setFont(new Font("Black", Font.BOLD, 20));
        lbl_CenterID.setForeground(new Color(26,50,249));
        
        JLabel lbl_CenterArea=new JLabel("Area : "+getCenter_Area());
        add(lbl_CenterArea);
        lbl_CenterArea.setBounds(20+x,200+y,250,30);
        lbl_CenterArea.setFont(new Font("Black", Font.BOLD, 20));
        lbl_CenterArea.setForeground(new Color(26,50,249));
        
        JLabel lbl_CenterPin=new JLabel("PinCode : "+getCenter_PIN());
        add(lbl_CenterPin);
        lbl_CenterPin.setBounds(20+x,230+y,250,30);
        lbl_CenterPin.setFont(new Font("Black", Font.BOLD, 20));
        lbl_CenterPin.setForeground(new Color(26,50,249));
        
        JLabel lbl_CenterDist=new JLabel("District : "+getCenter_Dist());
        add(lbl_CenterDist);
        lbl_CenterDist.setBounds(20+x,260+y,250,30);
        lbl_CenterDist.setFont(new Font("Black", Font.BOLD, 20));
        lbl_CenterDist.setForeground(new Color(26,50,249));
        
        JLabel lbl_CenterState=new JLabel("Area : "+getCenter_State());
        add(lbl_CenterState);
        lbl_CenterState.setBounds(20+x,290+y,250,30);
        lbl_CenterState.setFont(new Font("Black", Font.BOLD, 20));
        lbl_CenterState.setForeground(new Color(26,50,249));
        
	
	    }
	    
	    
	

	
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//	}

	public static String getCenter_Id() {
		return center_Id;
	}

	public static void setCenter_Id(String center_Id) {
		CenterLoggedin.center_Id = center_Id;
	}

	public static String getCenter_State() {
		return center_State;
	}

	public static void setCenter_State(String center_State) {
		CenterLoggedin.center_State = center_State;
	}

	public static String getCenter_Dist() {
		return center_Dist;
	}

	public static void setCenter_Dist(String center_Dist) {
		CenterLoggedin.center_Dist = center_Dist;
	}

	public static String getCenter_Area() {
		return center_Area;
	}

	public static void setCenter_Area(String center_Area) {
		CenterLoggedin.center_Area = center_Area;
	}

	public static String getCenter_NM() {
		return center_NM;
	}

	public static void setCenter_NM(String center_NM) {
		CenterLoggedin.center_NM = center_NM;
	}

	public static String getCenter_PIN() {
		return center_PIN;
	}

	public static void setCenter_PIN(String center_PIN) {
		CenterLoggedin.center_PIN = center_PIN;
	}

}
