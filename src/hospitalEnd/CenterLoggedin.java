package hospitalEnd;


import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JComponent;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.Myconnection.MyConnection;

import api.fun.DatePicker;
import api.fun.getTotalVAccine;
import coronaKatanaGov.allotVaccine;
import hospitalEnd.CenterLoggedinRenderer.ButtonEditor1;

public class CenterLoggedin extends JPanel{
    static String center_Id,center_State,center_Dist,center_Area,center_NM,center_PIN;
    JScrollPane jsp;
    static String []header={"Name","ID NO.","Dose","Booked Date","Action"};
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
                default:
                    return String.class;
            }
        }
    };

    JTable tbl_centers;



//    public static void main(String[] args) {
//        new CenterLoggedin();
//    }
    //	public class InputDialog {
//	    public static void main(String[] args) {
//	        String input = JOptionPane.showInputDialog("Enter Input:");
//	        System.out.println(input);
//	    }
//	}
    public CenterLoggedin() {
        setLayout(null);
        setBounds(200,50,1250,670);
        setVisible(true);
        setBackground(new Color(202, 219, 253));
        setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(70, 0, 0, 0, new Color(202, 219, 253)),
                BorderFactory.createMatteBorder(5, 0, 0, 0, Color.black)));
        int len=0;
        String nurse="";

        //TODO popup removed for testing
        do {
            nurse = JOptionPane.showInputDialog("Enter Nurse Name:");
            len=nurse.length();
        }while(len<3);

        int x=0,y=0;
        JLabel lbl_header=new JLabel("Vaccinator Dashboard  |  Center : "+getCenter_Id(),JLabel.LEFT);
        add(lbl_header);
        lbl_header.setBounds(100,0,1250,90);
        lbl_header.setFont(new Font("Serif", Font.BOLD, 20));
        lbl_header.setForeground(Color.black);
        //lbl_header.setBackground(new Color(46, 134, 193));
        //lbl_header.setOpaque(true);

//        JLabel lbl_header=new JLabel( getCenter_NM()+" , "+getCenter_Id()+" , VACCINE CEENTER "+getCenter_Dist(),JLabel.CENTER);
//        add(lbl_header);
//        lbl_header.setBounds(0,0,1450,100);
//        lbl_header.setFont(new Font("Serif", Font.BOLD, 20));
//        lbl_header.setForeground(new Color(247,249,249));
//        lbl_header.setBackground(new Color(46, 134, 193));
//        lbl_header.setOpaque(true);


        JLabel bg_label=new JLabel();
        bg_label.setBackground(new Color(255, 253, 208));
        bg_label.setBounds(80,120,500,500);
        bg_label.setOpaque(true);
        bg_label.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
        add(bg_label);




        JLabel lbl_CenterDtl=new JLabel("Vaccine Center Details",JLabel.CENTER);
        add(lbl_CenterDtl);
        lbl_CenterDtl.setBounds(100,30,280,30);
        lbl_CenterDtl.setFont(new Font("Serif", Font.BOLD, 25));
        lbl_CenterDtl.setForeground(Color.black);
        lbl_CenterDtl.setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(2, 2, 2, 2, Color.black),
                BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white)));
        bg_label.add(lbl_CenterDtl);

        JLabel lbl_CenterNM=new JLabel("Center Name : "+getCenter_NM());
        add(lbl_CenterNM);
        lbl_CenterNM.setBounds(50,110,250,30);
        lbl_CenterNM.setFont(new Font("Serif", Font.BOLD, 20));
        //lbl_CenterNM.setForeground(new Color(26,50,249));
        bg_label.add(lbl_CenterNM);

        JLabel lbl_CenterID=new JLabel("Center ID : "+getCenter_Id());
        add(lbl_CenterID);
        lbl_CenterID.setBounds(50,150,250,30);
        lbl_CenterID.setFont(new Font("Serif", Font.BOLD, 20));
        //lbl_CenterID.setForeground(new Color(26,50,249));
        bg_label.add(lbl_CenterID);

        JLabel lbl_nurse=new JLabel("Vaccinator Name : "+nurse);
        add(lbl_nurse);
        lbl_nurse.setBounds(50,190,250,30);
        lbl_nurse.setFont(new Font("Serif", Font.BOLD, 20));
        //lbl_nurse.setForeground(new Color(247,50,249));
        //lbl_nurse.setOpaque(true);
        bg_label.add(lbl_nurse);



        JLabel lbl_CenterArea=new JLabel("Area : "+getCenter_Area());
        add(lbl_CenterArea);
        lbl_CenterArea.setBounds(50,230,250,30);
        lbl_CenterArea.setFont(new Font("Serif", Font.BOLD, 20));
        //lbl_CenterArea.setForeground(new Color(26,50,249));
        bg_label.add(lbl_CenterArea);

        JLabel lbl_CenterPin=new JLabel("PinCode : "+getCenter_PIN());
        add(lbl_CenterPin);
        lbl_CenterPin.setBounds(50,270,250,30);
        lbl_CenterPin.setFont(new Font("Serif", Font.BOLD, 20));
        //lbl_CenterPin.setForeground(new Color(26,50,249));
        bg_label.add(lbl_CenterPin);

        JLabel lbl_CenterDist=new JLabel("District : "+getCenter_Dist());
        add(lbl_CenterDist);
        lbl_CenterDist.setBounds(50,310,250,30);
        lbl_CenterDist.setFont(new Font("Serif", Font.BOLD, 20));
        //lbl_CenterDist.setForeground(new Color(26,50,249));
        bg_label.add(lbl_CenterDist);

        JLabel lbl_CenterState=new JLabel("State/UT : "+getCenter_State());
        add(lbl_CenterState);
        lbl_CenterState.setBounds(50,350,250,30);
        lbl_CenterState.setFont(new Font("Serif", Font.BOLD, 20));
        //lbl_CenterState.setForeground(new Color(26,50,249));
        bg_label.add(lbl_CenterState);

        JLabel lblinfo=new JLabel("List of Vaccinations to be done.",JLabel.CENTER);
        add(lblinfo);
        lblinfo.setBounds(650,120,500,30);
        lblinfo.setFont(new Font("Serif", Font.BOLD, 20));

        tbl_centers=new JTable(tm);
        tbl_centers.getColumnModel().getColumn(4).setCellRenderer(new CenterLoggedinRenderer());
        tbl_centers.getColumnModel().getColumn(4).setCellEditor(new CenterLoggedinRenderer.ButtonEditor1(new JTextField()));

        add(jsp=new JScrollPane(tbl_centers));
        jsp.setBounds(650,150,500,470);
        jsp.setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black),
                BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white)));
        showTable();


    }


    public void showTable() {

        Connection con=(Connection) MyConnection.getConn();
        System.out.println("get center id -->"+getCenter_Id());
        try {
            ResultSet rs= con.prepareStatement("SELECT flogin.name as name,aadhaar_status.aadhar as aadhaar,CASE WHEN aadhaar_status.status=0 "
                    + "THEN 'First' END as firstdose,"
                    + "aadhaar_status.fDoseBDT as bookDT FROM flogin INNER JOIN aadhaar_status ON flogin.aadhaar=aadhaar_status.aadhar "
                    + "WHERE aadhaar_status.status=0 AND aadhaar_status.fDoseCen='"+getCenter_Id()+"' and DATE(aadhaar_status.fDoseDT)=CURRENT_DATE;").executeQuery();
            Object []obj=new Object[5];
            while(rs.next()) {
                obj[0]=rs.getString("name");
                obj[1]=rs.getString("aadhaar");
                obj[2]=rs.getString("firstdose");
                obj[3]=rs.getString("bookDT");
                obj[4]="DONE";
                tm.addRow(obj);

            }
            System.out.println("centerLoggedin-->"+obj[0]+" "+obj[1]+" "+obj[2]+" "+obj[3]+" ");
            ResultSet rs1= con.prepareStatement("SELECT flogin.name,aadhaar_status.aadhar as aadhaar,CASE WHEN aadhaar_status.status=2 THEN "
                    + "'Second' END as seconddose,"
                    + "aadhaar_status.sDoseBDT as bookDT FROM flogin INNER JOIN aadhaar_status ON flogin.aadhaar=aadhaar_status.aadhar "
                    + "WHERE aadhaar_status.status=2 AND aadhaar_status.sDoseCen='"+getCenter_Id()+"' and DATE(aadhaar_status.sDoseDT)=CURRENT_DATE;").executeQuery();
            //Object []obj=new Object[5];
            while(rs1.next()) {
                obj[0]=rs1.getString("name");
                obj[1]=rs1.getString("aadhaar");
                obj[2]=rs1.getString("seconddose");
                obj[3]=rs1.getString("bookDT");
                obj[4]="DONE";
                tm.addRow(obj);

            }

        }catch(Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }
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
