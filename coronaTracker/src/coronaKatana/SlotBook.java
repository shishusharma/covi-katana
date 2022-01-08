package coronaKatana;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.Myconnection.MyConnection;

import api.fun.ApiFun;


/*
    class SlotBook : inherits the JPanel.
                     Displays a table for the available slots for vaccination for the upcoming 5 days and
                     the centers can be filtered on the basis of state, pincode,district or area.

 */

public class SlotBook extends JPanel implements TableCellRenderer {
    static String aadhaar;
    static int stat=0;
    public static void setStat(int stat1){
        stat=stat1;
    }

    public static String getAadhaar() {
        return aadhaar;
    }

    public static void setAadhaar(String aadhaar) {
        SlotBook.aadhaar = aadhaar;
    }



    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
        // TODO Auto-generated method stub
        return null;
    }



    //Adding labels and table and their styling
    JLabel lbl_header,lbl_sort,bg_sort,lbl_centName,lbl_distName,lbl_pin,lbl_area,lbl_stateName;
    JTextField tf_centName,tf_stateName,tf_pin,tf_area,tf_district;
    JButton btn_search;
    JComboBox<String> cmb_state = new JComboBox<String>();
    JComboBox<String> cmb_dist = new JComboBox<String>();

    JScrollPane jsp;
    JLabel lbl_addVac,lbl_qty,lbl_date;
    static Calendar now = Calendar.getInstance();
    // Parses the date
    static LocalDate dt = LocalDate.now();
    // Function call
    static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-YYYY");
    String dtt= formatter.format(dt);

    //Formatting the date
    static String date1 =formatter.format(dt);
    static String date2 =formatter.format(dt.plusDays(1));
    static String date3 =formatter.format(dt.plusDays(2));
    static String date4 =formatter.format(dt.plusDays(3));
    static String date5 =formatter.format(dt.plusDays(4));

    static String []header={"Center Details","Center Code","State","District","pincode",date1,date2,date3,date4,date5};
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
                    return String.class;
                case 4:
                    return String.class;
                case 5:
                    return String.class;
                case 6:
                    return String.class;
                case 7:
                    return String.class;
                case 8:
                    return String.class;
                case 9:
                	return String.class;
                default:
                    return String.class;
            }
        }
    };

    JTable tbl_centers;


    public SlotBook()
    {


        //Setting up the layout and the dimensions
        ButtonRenderer.setAdhar(getAadhaar());
        //System.out.println("date1 -- "+date1);
        setBounds(200,50,1250,670);
        setBackground(new Color(0, 128, 255));
        setVisible(false);
        setLayout(null);
        setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(70, 50, 70, 50, new Color(0, 128, 255)),
                BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black)));

        tbl_centers=new JTable(tm);


        //adding table to table renederer class
        if(stat==1){
            setVisible(true);
        for(int i=5;i<=9;i++) {
            // tbl_centers.setRowSorter(sorter);
            tbl_centers.getColumnModel().getColumn(i).setCellRenderer(new ButtonRenderer());

            //set custom editor to teams coulumn
            tbl_centers.getColumnModel().getColumn(i).setCellEditor(new ButtonEditor(new JTextField()));

        }}else{
            for(int i=5;i<=9;i++) {
                // tbl_centers.setRowSorter(sorter);
                tbl_centers.getColumnModel().getColumn(i).setCellRenderer(new ButtonRenderer1());

                //set custom editor to teams coulumn
                tbl_centers.getColumnModel().getColumn(i).setCellEditor(new ButtonEditor2(new JTextField()));
            }
        }
       // this code is for hide table column
        for(int i=1;i<=4;i++) {
        tbl_centers.getColumnModel().getColumn(i).setMinWidth(0);
        tbl_centers.getColumnModel().getColumn(i).setMaxWidth(0);
        }
        tbl_centers.getColumnModel().getColumn(0).setMinWidth(330);

        add(jsp=new JScrollPane(tbl_centers));
        jsp.setBounds(150,200,950,350);


        lbl_header=new JLabel("Available Vaccination Slots",JLabel.CENTER);
        add(lbl_header);
        lbl_header.setBounds(0,0,1250,80);
        lbl_header.setFont(new Font("Serif", Font.BOLD, 32));
        lbl_header.setForeground(Color.white);
        //lbl_header.setOpaque(true);

        //Adding background to sort buttons
        bg_sort=new JLabel();
        add(bg_sort);
        bg_sort.setBounds(54,75,1142,90);
        bg_sort.setFont(new Font("Serif", Font.BOLD, 32));
        bg_sort.setForeground(new Color(51,54,69));
        bg_sort.setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(1, 1, 0, 1, Color.black),
                BorderFactory.createMatteBorder(70, 5, 70, 5, Color.white)));
        //lbl_sort.setOpaque(true);

        lbl_sort=new JLabel("SORT BY :",JLabel.RIGHT);
        add(lbl_sort);
        lbl_sort.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_sort.setBounds(0,25,150,30);
        bg_sort.add(lbl_sort);

        lbl_stateName=new JLabel("State/District/Pincode :",JLabel.RIGHT);
        add(lbl_stateName);
        lbl_stateName.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_stateName.setBounds(200,25,300,30);
        bg_sort.add(lbl_stateName);

        JTextField tf_state=new JTextField();
        tf_state.setBounds(600,25,150,25);
        add(tf_state);
        bg_sort.add(tf_state);



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


        tm.setRowCount(0);
        showTable();
    }



    // function to fetch data to be shown in the table from the created database
    public void showTable() {
        //Connecting to the database via MyConnection class
        Connection con=(Connection) MyConnection.getConn();

        //A try-catch block to handle the exceptions
                try {
			ResultSet rs= con.prepareStatement("SELECT Center_id FROM ADDVACCINECENTER").executeQuery();
			while(rs.next()) {
				/*"select addv.center_id,concat(addv.center_id,', ',addv.center_name,', ',addv.center_dist,', ',addv.center_state,', ',addv.center_pincode )as center_details,"
						+ "CASE WHEN alv.date=CURRENT_DATE THEN alv.quantity ELSE 'NA' END as currDay,"
						+ "CASE WHEN alv.date=date_add(CURRENT_DATE,INTERVAL 1 day) THEN alv.quantity ELSE 'NA' END as dayTwo, "
						+ "CASE WHEN alv.date=date_add(CURRENT_DATE,INTERVAL 2 day) THEN alv.quantity ELSE 'NA' END as dayThree,"
						+ "CASE WHEN alv.date=date_add(CURRENT_DATE,INTERVAL 3 day) THEN alv.quantity ELSE 'NA' END as dayFour,"
						+ "CASE WHEN alv.date=date_add(CURRENT_DATE,INTERVAL 4 day) THEN alv.quantity ELSE 'NA' END as dayFive"
						+ " from allotedvaccine"+ " alv,addvaccinecenter "
						+ "addv where addv.center_id=alv.center_id and alv.center_id='"+rs.getString("Center_id")+"' and alv.date<date_add(CURRENT_DATE,INTERVAL 5 day) "
						+ "and alv.date>CURRENT_DATE;"
				 *
				 * */

				ResultSet rs1= con.prepareStatement("select addv.center_id,addv.center_state,addv.center_dist,addv.center_pincode,concat(addv.center_id,', ',addv.center_name,', ',addv.center_dist,', ',addv.center_state,', ',addv.center_pincode )as center_details," +
                        "GROUP_CONCAT(CASE WHEN alv.date=CURRENT_DATE THEN alv.quantity END) as currDay,\n" +
                        "GROUP_CONCAT(CASE WHEN alv.date=date_add(CURRENT_DATE,INTERVAL 1 day) THEN alv.quantity END) as dayTwo," +
                        "GROUP_CONCAT(CASE WHEN alv.date=date_add(CURRENT_DATE,INTERVAL 2 day) THEN alv.quantity END) as dayThree," +
                        "GROUP_CONCAT(CASE WHEN alv.date=date_add(CURRENT_DATE,INTERVAL 3 day) THEN alv.quantity END) as dayFour," +
                        "GROUP_CONCAT(CASE WHEN alv.date=date_add(CURRENT_DATE,INTERVAL 4 day) THEN alv.quantity END) as dayFive " +
                        "from allotedvaccine alv,addvaccinecenter addv where alv.center_id=addv.center_id and alv.center_id='"+rs.getString("Center_id")+"' and alv.date<date_add(CURRENT_DATE,INTERVAL 5 day) and alv.date>=CURRENT_DATE").executeQuery();

                Object []obj=new Object[10];
				while(rs1.next()) {

					obj[0]=rs1.getString("center_details");
					obj[1]=rs1.getString("center_id");
					obj[2]=rs1.getString("addv.center_state");
					obj[3]=rs1.getString("addv.center_dist");
					obj[4]=rs1.getString("addv.center_pincode");
					obj[5]=rs1.getString("currDay");
					obj[6]=rs1.getString("DayTwo");
					obj[7]=rs1.getString("DayThree");
					obj[8]=rs1.getString("DayFour");
					obj[9]=rs1.getString("DayFive");

				}
				if(obj[0]!=null)
                    tm.addRow(obj);
                System.out.println(obj[0]);





				}



		}catch(Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

    }



}

