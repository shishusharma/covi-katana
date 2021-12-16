package coronaKatanaGov;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.awt.Container;

public class TotalBooked extends JFrame {
    Heading heading=new Heading();

    Container c=getContentPane();

    public TotalBooked()
    {
        c.add(heading);
        setLayout(null);
        setBounds(0,0,1450,720);
        setVisible(true);
       
    }

    public static void main(String[] args) {
        new TotalBooked();
    }
}
class Heading extends JPanel
{
    JLabel lbl_header,lbl_totbooked,lbl_waitlist;
    JTable tbl_booked;
    public Heading()
    {
        String data[][]={ {"101","Amit","670000"},
                {"102","Jai","780000"},
                {"101","Sachin","700000"}};
        String column[]={"ID","NAME","SALARY"};

        setBounds(0,0,1450,720);
        setBackground(new Color(248,196,113));
        setVisible(true);
        setLayout(null);

        lbl_header=new JLabel("TOTAL SLOTS BOOKED TODAY",JLabel.CENTER);
        lbl_header.setBounds(0,0,1450,100);
        lbl_header.setFont(new Font("Serif", Font.BOLD, 20));
        lbl_header.setForeground(new Color(247,249,249));
        lbl_header.setBackground(new Color(46, 134, 193));
        lbl_header.setOpaque(true);
        add(lbl_header);

        tbl_booked=new JTable(data,column);
        tbl_booked.setBounds(200,180,500,400);
        JScrollPane sp=new JScrollPane(tbl_booked);
        add(tbl_booked);

        int booked=200;
        int waitlist=51;

        lbl_totbooked=new JLabel("Total Booked : "+booked);
        lbl_totbooked.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_totbooked.setBounds(200,600,200,30);
        add(lbl_totbooked);

        lbl_waitlist=new JLabel("Total Waitlist : "+waitlist);
        lbl_waitlist.setFont(new Font("Georgia", Font.BOLD, 18));
        lbl_waitlist.setBounds(430,600,200,30);
        add(lbl_waitlist);
    }
}

