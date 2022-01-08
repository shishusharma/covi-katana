package hospitalEnd;

import javax.swing.*;

import java.awt.Font;
import java.awt.Color;

import com.Myconnection.MyConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import coronaKatana.FrontView;
import javax.swing.border.CompoundBorder;

import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;

/*
    class to provide the facility to a vaccinator, who can update
    data after successful vaccination of any user
 */

public class CenterLogin extends JPanel {
    /**
     *
     */
    private static final long serialVersionUID = 1L;



    private JTextField txtName;
    private JTextField txtCenter_id;
    private JTextField txtOtp;
    private JTextField txtAadhaar;
    private JTextField txtPincode;
    private JLabel lblOtpSend;
    static JDialog dialog;
//    public static void main(String[] args) {
//        new CenterLogin();
//    }




    //start Login(int i)
    public CenterLogin() {
        //setting up the layout and the dimensions
        setVisible(false);
        setLayout(null);
        setBackground(new Color(210, 180, 222));
        setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(170, 380, 185, 380, new Color(0, 128, 255)),
                BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black)));
        setBounds(200,50,1250,670);

        //setting up the layout and the dimensions
        JLabel lblHeading=new JLabel("CENTER  LOGIN",JLabel.CENTER);
        add(lblHeading);
        lblHeading.setBackground(Color.red);
        lblHeading.setBounds(380,90,490,70);
        //lbl_header.setBounds(50,50,522,100);
        lblHeading.setFont(new Font("Serif", Font.BOLD, 22));
        lblHeading.setForeground(Color.white);
        lblHeading.setBackground(Color.black);
        lblHeading.setOpaque(true);

        JLabel lblph=new JLabel("Username      :");
        add(lblph);
        lblph.setFont(new Font("Verdana", Font.BOLD, 16));
        lblph.setBounds(450,230,150,28);


        JLabel lblPincode=new JLabel("Password      :");
        add(lblPincode);
        lblPincode.setFont(new Font("Verdana", Font.BOLD, 16));
        lblPincode.setBounds(450,290,150,28);



        txtCenter_id=new JTextField();
        add(txtCenter_id);
        txtCenter_id.setBounds(600,235,195,25);
        txtCenter_id.setFont(new Font("Verdana", Font.PLAIN, 14));
        txtCenter_id.setColumns(10);


        txtPincode=new JTextField();
        add(txtPincode);
        txtPincode.setBounds(600,295,195,25);
        txtPincode.setFont(new Font("Verdana", Font.PLAIN, 14));
        txtPincode.setBackground(Color.white);
        txtPincode.setColumns(10);

//        txtOtp=new JTextField();
//        add(txtOtp);
//        txtOtp.setBounds(100,135,60,20);


        JLabel lbl_msg=new JLabel("");
        add(lbl_msg);
        lbl_msg.setBounds(550,340,200,25);
        lbl_msg.setFont(new Font("Verdana", Font.BOLD, 14));
        lbl_msg.setForeground(Color.red);
        lbl_msg.setBackground(Color.white);



        JButton btnlogin=new JButton("LOGIN");
        add(btnlogin);
        btnlogin.setBounds(550,390,150,30);
        btnlogin.setFont(new Font("Verdana", Font.BOLD, 15));
        btnlogin.setForeground(Color.white);
        btnlogin.setBackground(Color.black);
        btnlogin.setOpaque(true);
        btnlogin.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btnlogin.setBackground(Color.darkGray);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlogin.setBackground(Color.black);
            }
        });
        btnlogin.setFocusPainted(false);



        btnlogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                long centerid=Long.parseLong(txtCenter_id.getText().trim());
                long centerpin=Long.parseLong(txtPincode.getText().trim());

                Connection con=(Connection) MyConnection.getConn();

                try {
                    PreparedStatement stmt=(PreparedStatement) con.prepareStatement("select * from addvaccinecenter where center_id='"+centerid+"' and center_Pincode='"+centerpin+"'");
                    ResultSet rs=stmt.executeQuery();
                    if(rs.next()) {

                        System.out.println(rs.getString("center_Dist"));
                        CenterLoggedin.setCenter_Id(rs.getString(1));
                        CenterLoggedin.setCenter_State(rs.getString(2));
                        CenterLoggedin.setCenter_Dist(rs.getString(3));
                        CenterLoggedin.setCenter_Area(rs.getString(4));
                        CenterLoggedin.setCenter_NM(rs.getString(5));
                        CenterLoggedin.setCenter_PIN(rs.getString(6));
                        FrontView.SWU.setVisible(false);
                       // FrontView.CL.setVisible(false);
                        FrontView.hm.setVisible(false);
                        FrontView.RRR.setVisible(false);
                        FrontView.SB.setVisible(false);

                        JOptionPane jop = new JOptionPane();
                        dialog = jop.createDialog("Center : "+rs.getString(5)+"");
                        dialog.setSize(1250, 730);
                        dialog.setLocationRelativeTo(null);
                        dialog.setContentPane(new CenterLoggedin());
                        dialog.setVisible(true);
                        txtCenter_id.setText("");
                        txtPincode.setText("");

                    }else {
                        lbl_msg.setText("WRONG CREDENTIALS!");
                        System.out.println("worng detatils");

                    }

                }catch(Exception e) {
                    e.printStackTrace();

                    System.out.println(e);
                }






            }



        });




    }



}
