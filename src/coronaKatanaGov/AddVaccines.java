package coronaKatanaGov;

import javax.swing.*;

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

import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.Myconnection.MyConnection;

import api.fun.DatePicker;
import api.fun.getTotalVAccine;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;



public class AddVaccines extends JPanel
{
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    public static AddVacPanel vacPanel=new AddVacPanel();
//    Container c=getContentPane();
//    Container c2=getContentPane();

    public AddVaccines()
    {
        add(vacPanel);
        setBounds(200,50,1250,670);
        setVisible(true);
        setLayout(null);
       // JOptionPane.showConfirmDialog(null,"lskdjflksjf");
    }

   // public static void main(String[] args) {
//        new AddVaccines();
//    }
}
class AddVacPanel extends JPanel
{

    JLabel lbl_header,bg_allot,bg_table,lbl_search,lbl_allot,lbl_dist,lbl_pin,lbl_state,lbl_last2days,lbl_booked;
    public static JLabel lbl_avl;
    JTextField tf_dist,tf_pin,tf_state;
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



  public static getTotalVAccine gt=new getTotalVAccine();

    public AddVacPanel()
    {
        setBounds(0,0,1250,670);
        setVisible(true);
        setLayout(null);
        setBackground(new Color(202, 219, 253));
        setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(70, 0, 0, 0, new Color(202, 219, 253)),
                BorderFactory.createMatteBorder(5, 0, 0, 0, Color.black)));
        add(new allotVaccine());

        lbl_header=new JLabel("Admin Dashboard",JLabel.LEFT);
        lbl_header.setBounds(100,0,1250,90);
        lbl_header.setFont(new Font("Serif", Font.BOLD, 20));
        lbl_header.setForeground(Color.black);
        //lbl_header.setBackground(new Color(46, 134, 193));
        //lbl_header.setOpaque(true);
        add(lbl_header);

        lbl_allot=new JLabel("Allot Vaccines at the required Centers.",JLabel.LEFT);
        lbl_allot.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_allot.setBounds(100,90,600,30);
        add(lbl_allot);

        bg_allot=new JLabel();
        //bg_allot.setFont(new Font("Georgia", Font.BOLD, 18));
        bg_allot.setBackground(Color.white);
        bg_allot.setBounds(80,140,1070,385);
        bg_allot.setOpaque(true);
        bg_allot.setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 235,0, Color.pink),
                BorderFactory.createMatteBorder(0, 0, 5, 0, Color.black)));
        add(bg_allot);



        lbl_search=new JLabel("Search Vaccination Center:",JLabel.LEFT);
        add(lbl_search);
        lbl_search.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_search.setBounds(50,10,300,30);
        bg_allot.add(lbl_search);

        lbl_state=new JLabel("Search By State/District/Pincode:",JLabel.LEFT);
        lbl_state.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_state.setBounds(80,50,400,30);
        add(lbl_state);
        bg_allot.add(lbl_state);


//        lbl_dist=new JLabel("By District:",JLabel.RIGHT);
//        lbl_dist.setFont(new Font("Georgia", Font.BOLD, 18));
//        lbl_dist.setBounds(330,50,150,30);
//        add(lbl_dist);
//        bg_allot.add(lbl_dist);

//        lbl_pin=new JLabel("By Pincode:",JLabel.RIGHT);
//        lbl_pin.setFont(new Font("Georgia", Font.BOLD, 18));
//        lbl_pin.setBounds(650,50,150,30);
//        add(lbl_pin);
//        bg_allot.add(lbl_pin);

        tf_state=new JTextField();
        tf_state.setBounds(500,55,150,25);
        add(tf_state);
        bg_allot.add(tf_state);


//        tf_dist=new JTextField();
//        tf_dist.setBounds(510,55,150,25);
//        add(tf_dist);
//        bg_allot.add(tf_dist);
//
//        tf_pin=new JTextField();
//        tf_pin.setBounds(820,55,150,25);
//        add(tf_pin);
//        bg_allot.add(tf_pin);

//        btn_search=new JButton("Search Center");
//        btn_search.setBounds(400,100,150,30);
//        btn_search.setBackground(new Color(93,173,226));
//        btn_search.setOpaque(true);
//        btn_search.addMouseListener(new java.awt.event.MouseAdapter() {
//            public void mouseEntered(java.awt.event.MouseEvent evt) {
//                btn_search.setBackground(new Color(46,134,193));
//            }
//
//            public void mouseExited(java.awt.event.MouseEvent evt) {
//                btn_search.setBackground(new Color(93,173,226));
//            }
//        });
//        btn_search.setFocusPainted(false);
//        add(btn_search);
//        bg_allot.add(btn_search);

        tbl_centers=new JTable(tm);
        // tbl_centers.setRowSorter(sorter);
        add(jsp=new JScrollPane(tbl_centers));
        jsp.setBounds(50,195,700,170);
        //bg_table.add(tbl_centers);
        jsp.setOpaque(true);
        jsp.setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 0, 0, Color.pink),
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black)));
        bg_allot.add(jsp);
        JLabel selectlbl=new JLabel("Select the centers to allot the vaccines.",JLabel.LEFT);
        selectlbl.setBackground(Color.pink);
        selectlbl.setFont(new Font("Georgia", Font.BOLD, 18));
        selectlbl.setBounds(50,150,500,50);
        selectlbl.setOpaque(true);
        selectlbl.setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 0, 0, Color.pink),
                BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black)));

        add(selectlbl);
        bg_allot.add(selectlbl);

        bg_table=new JLabel();
        bg_table.setBackground(Color.orange);
        bg_table.setBounds(765,223,300,140);
        bg_table.setOpaque(true);
        bg_table.setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 0, 0, Color.pink),
                BorderFactory.createMatteBorder(1, 1, 1, 1, Color.black)));
        add(bg_table);
        bg_allot.add(bg_table);

//        bg_avl=new JLabel();
//        //bg_allot.setFont(new Font("Georgia", Font.BOLD, 18));
//        bg_avl.setBackground(Color.white);
//        bg_avl.setBounds(890,230,230,165);
//        bg_avl.setOpaque(true);
//        add(bg_avl);



        lbl_avl=new JLabel("Available Vaccines: "+gt.getTotalVaccine(),JLabel.CENTER);
        add(lbl_avl);
        lbl_avl.setBackground(Color.white);
        lbl_avl.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_avl.setBounds(800,180,230,40);
        lbl_avl.setOpaque(true);
        bg_allot.add(lbl_avl);



        lbl_addVac=new JLabel("Allot Vaccines",JLabel.CENTER);
        lbl_addVac.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_addVac.setBounds(20,10,250,30);
        lbl_addVac.setOpaque(true);
        lbl_addVac.setBackground(Color.white);
        lbl_addVac.setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 0, 1, Color.black),
                BorderFactory.createMatteBorder(0, 0, 0, 0, Color.black)));
        add(lbl_addVac);
        bg_table.add(lbl_addVac);

        lbl_qty=new JLabel("Quantity :",JLabel.LEFT);
        lbl_qty.setFont(new Font("Georgia", Font.BOLD, 16));
        lbl_qty.setBounds(40,45,100,30);
        //lbl_qty.setBackground(Color.white);
//        lbl_qty.setBorder(new CompoundBorder(
//                BorderFactory.createMatteBorder(0, 1, 0, 1, Color.black),
//                BorderFactory.createMatteBorder(0, 30, 0, 0, Color.white)));

//        lbl_qty.setOpaque(true);
        add(lbl_qty);
        bg_table.add(lbl_qty);

        lbl_date=new JLabel("For Date :",JLabel.LEFT);
        lbl_date.setFont(new Font("Georgia", Font.BOLD, 16));
        lbl_date.setBounds(40,80,250,35);
        lbl_date.setBackground(Color.white);
//        lbl_date.setBorder(new CompoundBorder(
//                BorderFactory.createMatteBorder(0, 1, 1, 1, Color.black),
//                BorderFactory.createMatteBorder(0, 30, 0, 0, Color.white)));
//        lbl_date.setOpaque(true);
        add(lbl_date);
        bg_table.add(lbl_date);

        tf_qty=new JTextField();
        tf_qty.setBounds(150,50,100,23);
        add(tf_qty);
        bg_table.add(tf_qty);

        tf_date=new JTextField();
        tf_date.setBounds(150,85,100,23);
        add(tf_date);
        bg_table.add(tf_date);
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

        btn_add=new JButton("ALLOT");
        btn_add.setFont(new Font("Georgia", Font.BOLD, 16));
        btn_add.setBounds(110,110,120,23);
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
//        btn_search.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent arg0) {
//                String dist=tf_dist.getText();
//            }
//        });


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
        bg_table.add(btn_add);

        showTable();

        TableRowSorter<TableModel> rowSorter = new TableRowSorter<>(tbl_centers.getModel());
        tbl_centers.setRowSorter(rowSorter);

        tf_state.getDocument().addDocumentListener(new DocumentListener(){

            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = tf_state.getText();

                if (text.trim().length() == 0) {
                    rowSorter.setRowFilter(null);
                } else {
                    rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = tf_state.getText();

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
