package coronaKatana;

import javax.swing.*;
import java.awt.*;

public class contact extends JPanel {


    public contact()
    {
        setLayout(null);
        setVisible(false);

        setBounds(200,50,1250,670);
        setBackground(new Color(0, 128, 255));

        JLabel head=new JLabel("This Application is made by :");
        head.setBounds(100,100,500,30);
        add(head);
    }
}
