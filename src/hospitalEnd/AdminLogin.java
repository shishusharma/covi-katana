package hospitalEnd;

import javax.swing.*;

import java.awt.Font;
import java.awt.Color;

import com.Myconnection.MyConnection;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import coronaKatana.FrontView;
import coronaKatana.Imagescale;
import coronaKatanaGov.AddVaccines;


import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.border.CompoundBorder;

import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.security.spec.MGF1ParameterSpec;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.util.Properties;
import java.util.Random;

    public class AdminLogin extends JPanel
    {
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

//        public static void main(String[] args) {
//            new AdminLogin();
//        }




    //start Login(int i)
    public AdminLogin() {
        setVisible(false);
        setLayout(null);
        setBackground(new Color(245, 183, 177));
        setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(170, 380, 185, 380, new Color(0, 128, 255)),
                BorderFactory.createMatteBorder(5, 5, 5, 5, Color.black)));
        setBounds(200,50,1250,670);

        JLabel lblHeading=new JLabel("ADMINISTRATOR  LOGIN",JLabel.CENTER);
        add(lblHeading);
        lblHeading.setBackground(Color.red);
        lblHeading.setBounds(380,90,490,70);
        //lbl_header.setBounds(50,50,522,100);
        lblHeading.setFont(new Font("Serif", Font.BOLD, 22));
        lblHeading.setForeground(Color.white);
        lblHeading.setBorder(BorderFactory.createLineBorder(new Color(	51,54,69),5));
        lblHeading.setOpaque(true);
        //lblHeading.add(l2);

        JLabel lblph=new JLabel("Admin Name  :");
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
        txtCenter_id.setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white),
                BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black)));
        txtCenter_id.setColumns(10);
        txtCenter_id.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtCenter_id.setBorder(new CompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white),
                        BorderFactory.createMatteBorder(2, 2, 2, 2, Color.red)));
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtCenter_id.setBorder(new CompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white),
                        BorderFactory.createMatteBorder(0, 0, 2, 0, Color.red)));

            }
        });

        txtPincode=new JTextField();
        add(txtPincode);
        txtPincode.setBounds(600,295,195,25);
        txtPincode.setFont(new Font("Verdana", Font.PLAIN, 14));
        txtPincode.setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white),
                BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black)));
        txtPincode.setBackground(Color.white);
        txtPincode.setColumns(10);
        txtPincode.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                txtPincode.setBorder(new CompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white),
                        BorderFactory.createMatteBorder(2, 2, 2, 2, Color.blue)));
            }

            @Override
            public void focusLost(FocusEvent e) {
                txtPincode.setBorder(new CompoundBorder(
                        BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white),
                        BorderFactory.createMatteBorder(0, 0, 2, 0, Color.black)));

            }
        });

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
                btnlogin.setBackground(Color.red);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                btnlogin.setBackground(Color.black);
            }
        });
        btnlogin.setFocusPainted(false);



        btnlogin.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent arg0) {
                String adminid=txtCenter_id.getText().trim();
                String adminpass=txtPincode.getText().trim();

                Connection con=(Connection) MyConnection.getConn();

                try {
                    ResultSet rs=con.prepareStatement("select * from admin_tbl where admin_id='"+adminid+"' and password='"+adminpass+"'").executeQuery();

                    if(rs.next()) {
                        FrontView.SWU.setVisible(false);
                        FrontView.RRR.setVisible(false);
                        FrontView.Llogin.setVisible(false);
                        FrontView.hm.setVisible(false);
                        FrontView.SB.setVisible(false);
                        FrontView.AL.setVisible(false);
                        FrontView.CL.setVisible(false);
                        FrontView.LI.setVisible(false);
                        FrontView.cnt.setVisible(false);
                            AddVaccines AV=new AddVaccines();
                            FrontView.f1.add(AV);
                            AV.setVisible(true);
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

