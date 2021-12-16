package coronaKatana;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import com.Myconnection.MyConnection;

import api.fun.ApiFun;



public class SlotBook extends JFrame implements TableCellRenderer {
	

//	SlotBookView SBV=new SlotBookView();
//    Container c=getContentPane();
//	public SlotBook(){
//		c.add(SBV);
//		setBounds(0,0,1450,720);
//        setVisible(true);
//        setLayout(null);
//        
//
//	}
//    	
 	public static void main(String[] args) {
			// TODO Auto-generated method stub
			new SlotBook(null);

		}

	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
			int row, int column) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

//	@Override
//	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
//			int row, int column) {
//		// TODO Auto-generated method stub
//		return null;
//	}


    JLabel lbl_header,lbl_centName,lbl_distName,lbl_pin,lbl_area,lbl_stateName;
    JTextField tf_centName,tf_stateName,tf_pin,tf_area,tf_district;
    JButton btn_search;
    JComboBox<String> cmb_state = new JComboBox<String>();
    JComboBox<String> cmb_dist = new JComboBox<String>();
    
    JScrollPane jsp;
    JLabel lbl_addVac,lbl_qty,lbl_date;
    static Calendar now = Calendar.getInstance();
    static String date1 =(now.get(Calendar.DATE))+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.YEAR);
    static String date2 =(now.get(Calendar.DATE)+1)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.YEAR);
	static String date3 =(now.get(Calendar.DATE)+2)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.YEAR);
    static String date4 =(now.get(Calendar.DATE)+3)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.YEAR);
    static String date5 =(now.get(Calendar.DATE)+4)+"-"+(now.get(Calendar.MONTH)+1)+"-"+now.get(Calendar.YEAR);
     
    static String []header={"Center Details",date1,date2,date3,date4,date5};
    static DefaultTableModel tm=new DefaultTableModel(header,0) {
		public Class<?> getColumnClass(int column){
    		switch (column) {			
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            case 3:
                return Integer.class;
            case 4:
            	return Integer.class;
            default:
                return String.class;
        }
    	}
    };
		
    JTable tbl_centers;
    public SlotBook() {};
     
    public SlotBook(String adhaar)
    {
    	
    	System.out.println("-->>"+adhaar);
    	
    	//System.out.println("date1 -- "+date1);
        setBounds(0,0,1450,720);
        setVisible(true);
        setLayout(null);
        
        tbl_centers=new JTable(tm);
        cmb_dist.setBounds(850,235,150,25);
        add(cmb_dist);

        
        for(int i=1;i<=5;i++) {
        	   // tbl_centers.setRowSorter(sorter);
    		tbl_centers.getColumnModel().getColumn(i).setCellRenderer(new ButtonRenderer());
    		
    		//set custom editor to teams coulumn
    		tbl_centers.getColumnModel().getColumn(i).setCellEditor(new ButtonEditor(new JTextField()));
    			
        }
         add(jsp=new JScrollPane(tbl_centers));
         jsp.setBounds(200,320,900,350);


        lbl_header=new JLabel("SLOT BOOKING",JLabel.CENTER);
        add(lbl_header);
        lbl_header.setBounds(0,0,1450,100);
        lbl_header.setFont(new Font("Serif", Font.BOLD, 20));
        lbl_header.setForeground(new Color(247,249,249));
        lbl_header.setBackground(new Color(46, 134, 193));
        lbl_header.setOpaque(true);
        
        
        

        lbl_stateName=new JLabel("State Name :",JLabel.RIGHT);
        add(lbl_stateName);

        lbl_stateName.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_stateName.setBounds(350,230,150,30);
       
        lbl_distName=new JLabel("District Name :",JLabel.RIGHT);
        add(lbl_distName);
        lbl_distName.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_distName.setBounds(680,230,150,30);
        
	
        cmb_state.setBounds(520,235,150,25);
        
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
        
        

        
       
        btn_search=new JButton("Search");
        add(btn_search);
        btn_search.setBounds(1020,230,150,30);
        btn_search.setBackground(new Color(93,173,226));
        btn_search.setOpaque(true);
        
        
        btn_search.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				System.out.println("Add Center");
				
				
				
			}
		});
        
        
       
        
        
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_search.setBackground(new Color(46,134,193));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_search.setBackground(new Color(93,173,226));
            }
        });
        btn_search.setFocusPainted(false);
       
        
 
        
       
        System.out.println("..ram am khata hai");
      	
         showTable();
    }
    
  
    
 public void showTable() {
 	
 	Connection con=(Connection) MyConnection.getConn();
 	
		try {
			System.out.println("ram am khata hai");
//				PreparedStatement ps=con.prepareStatement("select * from addvaccinecenter");
//				ResultSet rs= ps.executeQuery()) {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement("select * from addvaccinecenter");
//			
			ResultSet rs=stmt.executeQuery();
			while(rs.next()) {
				String date[]=new String[5];
				
			 date[0] =""+now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+(now.get(Calendar.DATE));
			 date[1]  =now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+(now.get(Calendar.DATE)+1);
			 date[2] =now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+(now.get(Calendar.DATE)+2);
			 date[3] =now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+(now.get(Calendar.DATE)+3);
			 date[4] =now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+(now.get(Calendar.DATE)+4);
				//String dateL =now.get(Calendar.YEAR)+"-"+(now.get(Calendar.MONTH)+1)+"-"+(now.get(Calendar.DATE)+5);
				
				PreparedStatement stmt1=(PreparedStatement) con.prepareStatement("select * from allotedvaccine where center_id='"+rs.getString("center_id")+"' and date between '"+date[0]+"' and '"+date[4]+"'");
				
				ResultSet rs1=stmt1.executeQuery();
				String []obj=new String[6];
				int i=1;
				String s=""+rs.getString(1)+" "+rs.getString("center_Name")+" "+rs.getString("center_state")+" "+rs.getString("center_dist")+" "+rs.getInt("center_pincode");
				
				//System.out.println("date1 -->"+date1);
				while(rs1.next()) {
					while(!rs1.getString(2).equals(date[i-1])) {
						obj[i++]="";
					}
					
						obj[i++]=rs1.getString(3);
						
					obj[0]= s;
									

					
				}
				if(obj[1]!=null)
					tm.addRow(obj);
					System.out.println(obj[1]+"  "+obj[2]);
//				

			}	
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
 }



}

