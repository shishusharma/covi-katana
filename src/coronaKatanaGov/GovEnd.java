package coronaKatanaGov;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Map;
import java.util.TreeMap;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;

import com.Myconnection.MyConnection;

import api.fun.ApiFun;


@SuppressWarnings("serial")
public class GovEnd extends JFrame
{
    GovEndPanel jpanel=new GovEndPanel();
    Container c=getContentPane();

    public GovEnd()
    {
        c.add(jpanel);
        setBounds(0,0,1450,720);
        setVisible(true);
        setLayout(null);

    }


    public static void main(String[] args) {
    	System.out.println("sdfdf");
        new GovEnd();

    }
}
@SuppressWarnings("serial")
class GovEndPanel extends JPanel
{
    JLabel lbl_header,lbl_centName,lbl_distName,lbl_pin,lbl_area,lbl_stateName;
    JTextField tf_centName,tf_stateName,tf_pin,tf_area,tf_district;
    JButton btn_addCentre;
    JComboBox<String> cmb_state = new JComboBox<String>();
    JComboBox<String> cmb_dist = new JComboBox<String>();
		
      
     
    public GovEndPanel()
    {
        setBounds(0,0,1450,720);
        setVisible(true);
        setLayout(null);


        lbl_header=new JLabel("ADD VACCINATION CENTER",JLabel.CENTER);
        lbl_header.setBounds(0,0,1450,100);
        lbl_header.setFont(new Font("Serif", Font.BOLD, 20));
        lbl_header.setForeground(new Color(247,249,249));
        lbl_header.setBackground(new Color(46, 134, 193));
        lbl_header.setOpaque(true);
        add(lbl_header);


        lbl_stateName=new JLabel("State Name :",JLabel.RIGHT);
        lbl_stateName.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_stateName.setBounds(500,190,150,30);
        add(lbl_stateName);

        lbl_distName=new JLabel("District Name :",JLabel.RIGHT);
        lbl_distName.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_distName.setBounds(500,230,150,30);
        add(lbl_distName);

        lbl_area=new JLabel("Area Name :",JLabel.RIGHT);
        lbl_area.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_area.setBounds(500,270,150,30);
        add(lbl_area);

        lbl_centName=new JLabel("Center Name :",JLabel.RIGHT);
        lbl_centName.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_centName.setBounds(500,310,150,30);
        add(lbl_centName);


        lbl_pin=new JLabel("Pincode :",JLabel.RIGHT);
        lbl_pin.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_pin.setBounds(500,350,150,30);
        add(lbl_pin);


    
	
        cmb_state.setBounds(670,195,150,25);
        add(cmb_state);
        ApiFun AF=new ApiFun();
        AF.sortedData.forEach((k,v)->cmb_state.addItem(k));

        cmb_state.addItemListener(new ItemListener() {

        	@Override
			public void itemStateChanged(ItemEvent e) {
				cmb_dist.removeAllItems();
				if(e.getStateChange()==ItemEvent.SELECTED) {
					cmb_dist.removeAllItems();

				String state_id=cmb_state.getSelectedItem().toString();
        		int i=AF.sortedData.get(state_id);
        		ApiFun AF1=new ApiFun(i);
        		AF1.sortedDataDist.forEach((k,v)->cmb_dist.addItem(k));
			}
			}
        });
        
        
//        cmb_state.addActionListener(new ActionListener() {
//        	public void actionPerformed(ActionEvent arg0) {
//        		String state_id=cmb_state.getSelectedItem().toString();
//        		int i=AF.sortedData.get(state_id);
//        		ApiFun AF1=new ApiFun(i);
//        		AF1.sortedDataDist.forEach((k,v)->cmb_dist.addItem(k));
//        	}
//        });
//        
        //ApiFun.sortedData.forEach((k,v)->System.out.println(k+"  "+v));
//        for(int i=0;i<stateOption1.length;i++) {
//        	cmb_state.addItem(stateOption1[i]);
//        }
        
        cmb_dist.setBounds(670,235,150,25);
        add(cmb_dist);
//        tf_district=new JTextField();
//        tf_district.setBounds(670,235,150,25);
//        add(tf_district);
        tf_area=new JTextField();
        tf_area.setBounds(670,275,150,25);
        add(tf_area);
        tf_centName=new JTextField();
        tf_centName.setBounds(670,315,150,25);
        add(tf_centName);
        tf_pin=new JTextField();
        tf_pin.setBounds(670,355,150,25);
        add(tf_pin);

        btn_addCentre=new JButton("ADD CENTER");
        btn_addCentre.setBounds(600,425,150,30);
        btn_addCentre.setBackground(new Color(93,173,226));
        btn_addCentre.setOpaque(true);
        
        
        btn_addCentre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Add Center");
				save();
				
				
			}
		});
        
        
       
        
        
        btn_addCentre.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_addCentre.setBackground(new Color(46,134,193));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_addCentre.setBackground(new Color(93,173,226));
            }
        });
        btn_addCentre.setFocusPainted(false);
        add(btn_addCentre);

    }
    
    public void save() {
		try {
			
			String state=cmb_state.getSelectedItem().toString();
			String dist=cmb_dist.getSelectedItem().toString();
			String center_area=tf_area.getText();
			String center_nm=tf_centName.getText();
			int pinCode=Integer.parseInt(tf_pin.getText());
							
			Connection con=MyConnection.getConn();
			IdIncrement idIncrement=new IdIncrement();

			int id=idIncrement.increment(con);
			if(id>100) {
			PreparedStatement ps=con.prepareStatement("insert into addvaccinecenter values(?,?,?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, state);
			ps.setString(3, dist);
			ps.setString(4, center_area);
			ps.setString(5, center_nm);
			ps.setInt(6, pinCode);
			ps.executeUpdate();
			JOptionPane.showMessageDialog(null,"Successfully saved");
			setClearFields();
			}
		}catch(Exception ex) {
			System.out.println(ex);
			JOptionPane.showMessageDialog(this, String.valueOf(ex));
		}
	}
    
    public void setClearFields() {
    	cmb_state.setSelectedIndex(0);
    	//tf_district.setText("");
    	tf_area.setText("");
    	tf_centName.setText("");
    	tf_pin.setText("");
    	}
    
    public String getID(Connection con) {
		String id="1";
		try {
//		Connection con=MyConnection.getConn();
		PreparedStatement ps=con.prepareStatement("select max(center_id)+1 from addvaccinecenter");
		//ps=con.prepareStatement(id);
		ResultSet rs=ps.executeQuery();
		
		if(rs.next())id=rs.getString(1);
		
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(this, String.valueOf(ex));
		}
		finally {
			try {
			}catch(Exception ex) {}
		}
	return id;
	}
   
   
}
