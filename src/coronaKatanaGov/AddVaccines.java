package coronaKatanaGov;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Container;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.Myconnection.MyConnection;

import api.fun.DatePicker;
import api.fun.getTotalVAccine;

import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



public class AddVaccines extends JFrame
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	AddVacPanel vacPanel=new AddVacPanel();
    Container c=getContentPane();
   Container c2=getContentPane();

    public AddVaccines()
    {
        c.add(vacPanel);
        setBounds(0,0,1450,720);
        setVisible(true);
        setLayout(null);
    }

    public static void main(String[] args) {
        new AddVaccines();
    }
}
class AddVacPanel extends JPanel
{
	
    JLabel lbl_header,lbl_search,lbl_dist,lbl_pin,lbl_state,lbl_last2days,lbl_avl,lbl_booked;
    JTextField tf_dist,tf_pin,tf_name;
    JButton btn_search;
    JScrollPane jsp;
    JLabel lbl_addVac,lbl_qty,lbl_date;
    JTextField tf_qty,tf_date;
    JButton btn_add;
    static String []header={"Select Center","State","District","Pincode","Center code","Center Name"};
    static DefaultTableModel tm=new DefaultTableModel(header,0) {
    	public Class<?> getColumnClass(int column){
    		switch (column) {			
            case 0:
                return Boolean.class;
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
    };;
    
   // sorter=new TableRowSorter<>(tm);
    JTable tbl_centers;
   

    
    getTotalVAccine gt=new getTotalVAccine();
    
    public AddVacPanel()
    {
    	
//        String data[][]={ {"101","Amit","670000"},
//                {"102","Jai","780000"},
//                {"101","Sachin","700000"}};
//        String column[]={"ID","NAME","SALARY"};
        setBounds(0,0,1450,550);
        setVisible(true);
        setLayout(null);
        add(new allotVaccine());

        lbl_header=new JLabel("ALOT VACCINES TO THE CENTER",JLabel.CENTER);
        lbl_header.setBounds(0,0,1250,100);
        lbl_header.setFont(new Font("Serif", Font.BOLD, 20));
        lbl_header.setForeground(new Color(247,249,249));
        lbl_header.setBackground(new Color(46, 134, 193));
        lbl_header.setOpaque(true);
        add(lbl_header);



        lbl_search=new JLabel("Search Vaccination Center:",JLabel.LEFT);
        lbl_search.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_search.setBounds(550,150,300,30);
        add(lbl_search);

        lbl_state=new JLabel("By State:",JLabel.RIGHT);
        lbl_state.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_state.setBounds(280,190,150,30);
        add(lbl_state);

        
        
        
        
        
        lbl_dist=new JLabel("By District:",JLabel.RIGHT);
        lbl_dist.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_dist.setBounds(600,190,150,30);
        add(lbl_dist);

        lbl_pin=new JLabel("By Pincode:",JLabel.RIGHT);
        lbl_pin.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_pin.setBounds(920,190,150,30);
        add(lbl_pin);

//        dd(lbl_last2days);
//			lbl_last2days=new JLabel("Last 2 Days Data :");
//        lbl_last2days.setFont(new Font("Georgia", Font.BOLD, 18));
//        lbl_last2days.setBounds(150,510,200,30);
//        a
        /*
            The available data will be shown when the user selects
            any particular center.
         */

//        int avl=200;
//        int waitlist=51;

        lbl_avl=new JLabel("Available : "+gt.getTotalVaccine());
        lbl_avl.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_avl.setBounds(370,510,150,30);
        add(lbl_avl);

//        lbl_booked=new JLabel("Waitlist : "+waitlist);
//        lbl_booked.setFont(new Font("Georgia", Font.BOLD, 18));
//        lbl_booked.setBounds(550,510,120,30);
//        add(lbl_booked);




        tf_name=new JTextField();
        tf_name.setBounds(440,195,150,25);
        add(tf_name);
         
        
//        tf_name.getDocument().addDocumentListener(new DocumentListener() {
//			
//			@Override
//			public void removeUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
//				search(tf_name.getText());
//				
//			}
//			
//			@Override
//			public void insertUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			
//			@Override
//			public void changedUpdate(DocumentEvent e) {
//				// TODO Auto-generated method stub
//				
//			}
//			public void search(String str) {
//	            if (str.length() == 0) {
//	               sorter.setRowFilter(null);
//	            } else {
//	               sorter.setRowFilter(RowFilter.regexFilter(str));
//	            }
//	         }
//		});
//        

        tf_dist=new JTextField();
        tf_dist.setBounds(760,195,150,22);
        add(tf_dist);

        tf_pin=new JTextField();
        tf_pin.setBounds(1080,195,100,22);
        add(tf_pin);

        btn_search=new JButton("Search Center");
        btn_search.setBounds(620,240,150,30);
        btn_search.setBackground(new Color(93,173,226));
        btn_search.setOpaque(true);
        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_search.setBackground(new Color(46,134,193));
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_search.setBackground(new Color(93,173,226));
            }
        });
        btn_search.setFocusPainted(false);
        add(btn_search);
        
        tbl_centers=new JTable(tm);
       // tbl_centers.setRowSorter(sorter);
        add(jsp=new JScrollPane(tbl_centers));
        jsp.setBounds(200,300,500,200);
        
        JLabel add_vac=new JLabel("Add Vaccine");
        add_vac.setFont(new Font("Georgia", Font.BOLD, 18));
        add_vac.setBounds(750,270,150,70);
        add(add_vac);
        
        lbl_addVac=new JLabel("Add Vaccine :",JLabel.RIGHT);
        lbl_addVac.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_addVac.setBounds(50,580,250,30);
        add(lbl_addVac);

        lbl_qty=new JLabel("Quantity :",JLabel.RIGHT);
        lbl_qty.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_qty.setBounds(320,580,100,30);
        add(lbl_qty);

        lbl_date=new JLabel("For Date :",JLabel.RIGHT);
        lbl_date.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_date.setBounds(570,580,100,30);
        add(lbl_date);

        tf_qty=new JTextField();
        tf_qty.setBounds(430,585,100,25);
        add(tf_qty);

        
        ///
      
        
        
       
        tf_date=new JTextField();
        tf_date.setBounds(680,585,100,25);
        add(tf_date);
        tf_date.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				final JFrame f = new JFrame();
				tf_date.setText(new DatePicker(f).setPickedDate());
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
        
//        JButton btn_date=new JButton("a");
//        btn_date.setFont(new Font("Georgia", Font.BOLD, 18));
//        btn_date.setBounds(781,580,30,30);
//        btn_date.setBackground(new Color(93,103,226));
//        btn_date.setOpaque(true);
//        add(btn_date);
//        
//        
//        btn_date.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				final JFrame f = new JFrame();
//				tf_date.setText(new DatePicker(f).setPickedDate());
//				
//			}
//        	
//        });

        btn_add=new JButton("ADD");
        btn_add.setFont(new Font("Georgia", Font.BOLD, 18));
        btn_add.setBounds(550,630,80,30);
        btn_add.setBackground(new Color(93,173,226));
        btn_add.setOpaque(true);
        btn_add.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
				System.out.println("add vaccinde");
				int k=0,cnt=0,totalvac=0;
				
				for(int i=0;i<tbl_centers.getRowCount();i++) {
					Boolean chked=Boolean.valueOf(tbl_centers.getValueAt(i, 0).toString());						
					if ((chked)) {
						cnt++;
					}
					
				}
				
				totalvac=cnt*Integer.parseInt(tf_qty.getText());
				if(gt.getTotalVaccine()>=(totalvac)) {
				for(int i=0;i<tbl_centers.getRowCount();i++) {
					Boolean chked=Boolean.valueOf(tbl_centers.getValueAt(i, 0).toString());
					int id = Integer.parseInt(tbl_centers.getValueAt(i, 4).toString());
						
					if ((chked)/*&&(gt.getTotalVaccine()>=Integer.parseInt(tf_qty.getText()))*/) {
						Connection con=MyConnection.getConn();
						PreparedStatement ps;
						try {
							ps = con.prepareStatement("insert into allotedVaccine values(?,?,?)");
							ps.setInt(1, id);
							ps.setString(2, tf_date.getText());
							ps.setInt(3,Integer.parseInt(tf_qty.getText()));
							ps.executeUpdate();
							k=1;
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
							
						}
					}
					
				}
				if(k==1) {
					JOptionPane.showConfirmDialog(null, "Successfully Saved");
					gt.getTotalVaccine();
					
				}
				else {
					JOptionPane.showConfirmDialog(null, "Something went Worng please Try Later");
				}
			}else {
				JOptionPane.showConfirmDialog(null, "Please Checked OR Vaccine is not Availave \n Quntity must be <='"+gt.getTotalVaccine()+"'");
			}
								
			}
        });
    
        
       ///search button
        btn_search.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		String dist=tf_dist.getText();
        	}
        });
        
        
        btn_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btn_add.setBackground(new Color(46,134,193));
                
            }
            

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btn_add.setBackground(new Color(93,173,226));
            }
        });
        btn_add.setFocusPainted(false);
        add(btn_add);
        
        showTable();
        
        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tbl_centers.getModel());
    	tbl_centers.setRowSorter(rowSorter);
    	
        tf_name.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = tf_name.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = tf_name.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

        });
    


    }
    
    
    
    public void showTable() {
    	
    	Connection con=(Connection) MyConnection.getConn();
    	
		try {
			PreparedStatement stmt=(PreparedStatement) con.prepareStatement("select * from addvaccinecenter");
			ResultSet rs=stmt.executeQuery();
			
			while(rs.next()) {
				Object []obj= {false,rs.getString("center_state"),rs.getString("center_dist"),rs.getInt("center_pincode"),rs.getInt("center_id"),rs.getString("center_Name")};
				tm.addRow(obj);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println(e);
		}
    }
    
//    public int getTotalVaccine() {
//    	int cnt=0;
//    	Connection con=(Connection) MyConnection.getConn();
//    	
//		try {
//			PreparedStatement stmt=(PreparedStatement) con.prepareStatement("SELECT sum(IF(alloted_cen=0,1,0)&&IF(vac_status=0,1,0)) FROM `vaccine`");
//			ResultSet rs=stmt.executeQuery();
//			
//			
//			while(rs.next()) {
//				cnt=rs.getInt(1);
//				
//			}
//			
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//			System.out.println(e);
//		}
//		
//		return cnt;
//    }
   
    
    
}
