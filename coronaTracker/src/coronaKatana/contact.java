package coronaKatana;

import javax.swing.*;
import javax.swing.border.CompoundBorder;
import java.awt.*;

public class contact extends JPanel {


    public contact()
    {
        setLayout(null);
        setVisible(false);

        setBounds(200,50,1250,670);
        setBackground(new Color(0, 128, 255));
        setBorder(new CompoundBorder(
                BorderFactory.createMatteBorder(70, 0, 0, 0, new Color(0, 128, 255)),
                BorderFactory.createMatteBorder(5, 0, 0, 0, Color.black)));

        JLabel lbl_header=new JLabel("This Application is made by :",JLabel.LEFT);
        add(lbl_header);
        lbl_header.setBounds(100,0,1250,90);
        lbl_header.setFont(new Font("Serif", Font.BOLD, 20));
        lbl_header.setForeground(Color.white);

        JLabel lbl_1 =new JLabel("1. Shishu (2020CA089) | shishus808@gmail.com ",JLabel.LEFT);
        add(lbl_1);
        lbl_1.setBounds(100,100,1250,90);
        lbl_1.setFont(new Font("Serif", Font.BOLD, 20));
        lbl_1.setForeground(Color.white);

        JLabel lbl_2 =new JLabel("2. Manoj (2020CA037)  | manojsingh07010@gmail.com",JLabel.LEFT);
        add(lbl_2);
        lbl_2.setBounds(100,150,1250,90);
        lbl_2.setFont(new Font("Serif", Font.BOLD, 20));
        lbl_2.setForeground(Color.white);
    }
}
