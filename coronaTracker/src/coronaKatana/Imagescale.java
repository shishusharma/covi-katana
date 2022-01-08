package coronaKatana;

import java.awt.*;
import java.awt.geom.AffineTransform;
import javax.swing.*;


public class Imagescale implements Icon
{
    private Icon icon;

    public Imagescale(Icon icon)
    {
        this.icon = icon;
    }

    public int getIconWidth()
    {
        return icon.getIconWidth();
    }

    public int getIconHeight()
    {
        return icon.getIconHeight();
    }

    public void paintIcon(Component c, Graphics g, int x, int y)
    {
        Graphics2D g2d = (Graphics2D)g.create();

        AffineTransform at = g2d.getTransform();

        int scaleX = (int)(x * at.getScaleX());
        int scaleY = (int)(y * at.getScaleY());

        int offsetX = (int)(icon.getIconWidth() * (at.getScaleX() - 1) / 2);
        int offsetY = (int)(icon.getIconHeight() * (at.getScaleY() - 1) / 2);

        int locationX = scaleX + offsetX;
        int locationY = scaleY + offsetY;

        //  Reset scaling to 1.0 by concatenating an inverse scale transfom

        AffineTransform scaled = AffineTransform.getScaleInstance(1.0 / at.getScaleX(), 1.0 / at.getScaleY());
        at.concatenate( scaled );
        g2d.setTransform( at );

        icon.paintIcon(c, g2d, locationX, locationY);

        g2d.dispose();
    }

//    public static void main(String[] args)
//    {
//        SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowGUI();
//            }
//        });
//    }
//
//    public static void createAndShowGUI()
//    {
//        JButton button = new JButton( "Button" );
//        Imagescale icon = new Imagescale( new ImageIcon("C:\\Users\\LEO\\Desktop\\close48.png") );
//        button.setIcon( icon );
//
//        JPanel panel = new JPanel( );
//        panel.add( button );
//
//        JFrame f = new JFrame();
//        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        f.getContentPane().add(panel);
//        f.setSize(200, 200);
//        f.setLocationRelativeTo( null );
//        f.setVisible(true);
//    }
}