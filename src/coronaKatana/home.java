package coronaKatana;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

public class home extends JPanel{
    //    public static void main(String[] args) {
//        new home();
//    }
    JLabel l1;
    Thread th;
    JRadioButton r1,r2,r3;
    public home()
    {
        setLayout(null);
        setVisible(true);
        //setSize(w,h);
        setBounds(200,50,1250,670);
        setBackground(new Color(0, 128, 255));

        JButton btn_totalInf;
//        long totalInf_case=0;
//        long totalAct_case=0;
//        long todynewAct=0;
//        long totalDeth=0;
//
//        public static long getTodynewAct() {
//        return todynewAct;
//    }
//
//        public static void setTodynewAct(long todynewAct) {
//        home.todynewAct = todynewAct;
//    }
//
//        public static long getTotalDeth() {
//        return totalDeth;
//    }
//
//        public static void setTotalDeth(long totalDeth) {
//        home.totalDeth = totalDeth;
//    }
//
//        public static long getTotalAct_case() {
//        return totalAct_case;
//    }
//
//        public static void setTotalAct_case(long totalAct_case) {
//        home.totalAct_case = totalAct_case;
//    }
//
//        public static long getTotalInf_case() {
//        return totalInf_case;
//    }
//
//        public static void setTotalInf_case(long totalInf_case) {
//        StateWiseUpdate.totalInf_case = totalInf_case;
//    }
        l1=new JLabel(new ImageIcon(home.class.getResource("/c4.png")));
        l1.setBounds(130,20,1000,400);
        l1.setBorder(BorderFactory.createLineBorder(new Color(	33, 66, 171),5));
        add(l1);
//        BufferedImage image = null;
//        try
//        {
//            image = ImageIO.read(new File("C:\\Users\\LEO\\Desktop\\c4.png"));
//
//        } catch (Exception e)
//        {
//            e.printStackTrace();
//        }
//
//        ImageIcon imageIcon = new ImageIcon(fitimage(image, l1.getWidth(), l1.getHeight()));
//        l1.setIcon(imageIcon);

        r1=new JRadioButton();
        r1.setBounds(553,420,32,32);
        r1.setSelected(true);
        r1.setBackground(new Color(0, 128, 255));
        add(r1);

        r2=new JRadioButton();
        r2.setBounds(603,420,32,32);
        r2.setBackground(new Color(0, 128, 255));
        add(r2);

        r3=new JRadioButton();
        r3.setBounds(653,420,32,32);
        r3.setBackground(new Color(0, 128, 255));
        add(r3);

        setVisible(true);


        th=new Thread(rr);
        th.start();



        //Fetiching data for the buttons
        HttpClient client=HttpClient.newHttpClient();
        System.out.println("ActionPerformed");
        //Request Setup
        HttpRequest request=HttpRequest.newBuilder().uri(URI.create("https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenApply(StateWiseUpdate::parse).join();

        //Title for the page
//        JLabel title=new JLabel("#UniteToFightCorona",JLabel.CENTER);
//        add(title);
//        title.setFont(new Font("Serif", Font.BOLD, 32));
//        title.setBounds(0,0,1250,80);
//        title.setBackground(Color.red);
//        title.setForeground(new Color(51,54,69));
        //title.setOpaque(true);


        int x=30,y=-30,lx=0,ly=0,bx=0,by=-30;
        JLabel lblcowin=new JLabel("India set to defeat Covid-19.",JLabel.CENTER);
        add(lblcowin);
        lblcowin.setForeground(Color.white);
        lblcowin.setBackground(Color.black);
        lblcowin.setFont(new Font("Serif", Font.BOLD, 25));
        lblcowin.setBounds(0+x,340+y,350,60);
        lblcowin.setOpaque(true);
        l1.add(lblcowin);

        JLabel bg_label=new JLabel();
        bg_label.setBackground(new Color(255, 215, 0));
        bg_label.setBounds(130,500,1000,120);
        bg_label.setOpaque(true);
        bg_label.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
        add(bg_label);

        JLabel bg_line=new JLabel();
        bg_line.setBackground(Color.black);
        bg_line.setBounds(488,0,6,120);
        bg_line.setOpaque(true);
        //bg_label.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
        add(bg_line);
        bg_label.add(bg_line);

        JLabel lblvstat=new JLabel("Total Vaccinations Doses ");
        add(lblvstat);
        lblvstat.setForeground(Color.black);
        lblvstat.setBackground(new Color(51,54,69));
        lblvstat.setFont(new Font("Serif", Font.BOLD, 20));
        lblvstat.setBounds(150,10,300,50);
        bg_label.add(lblvstat);

        JLabel img=new JLabel();
        img.setBounds(75,25,64,64);
        img.setForeground(Color.white);
        img.setBackground(new Color(255, 215, 0));
        img.setOpaque(true);
        //l1.setBorder(BorderFactory.createLineBorder(new Color(	51,54,69),5));
      //  Imagescale icon = new Imagescale( new ImageIcon(home.class.getResource("/sy3.png")));
        //img.setIcon( icon );
        //img.setBorder(BorderFactory.createLineBorder(Color.black,2));
        //l1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\LEO\\Desktop\\close48.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
//        add(img);
//        bg_label.add(img);


        JLabel img2=new JLabel();
        img2.setBounds(575,25,64,64);
        img2.setForeground(Color.white);
        img2.setBackground(new Color(255, 215, 0));
        img2.setOpaque(true);
        //l1.setBorder(BorderFactory.createLineBorder(new Color(	51,54,69),5));
//        Imagescale icon2 = new Imagescale( new ImageIcon(home.class.getResource("/sy3.png")));
//        img2.setIcon( icon2 );
//        //img2.setBorder(BorderFactory.createLineBorder(Color.black,2));
        //l1.setIcon(new ImageIcon(new ImageIcon("C:\\Users\\LEO\\Desktop\\close48.png").getImage().getScaledInstance(30, 30, Image.SCALE_DEFAULT)));
//        add(img2);
//        bg_label.add(img2);

        JLabel datavstat=new JLabel("1,41,03,73,188",JLabel.CENTER);
        add(datavstat);
        datavstat.setForeground(Color.black);
        datavstat.setBackground(new Color(51,54,69));
        datavstat.setFont(new Font("Serif", Font.BOLD, 28));
        datavstat.setBounds(150,50,220,50);
        datavstat.setBorder(BorderFactory.createLineBorder(Color.black,4));
        bg_label.add(datavstat);

        JLabel lbltoday=new JLabel("Total Vaccinations Today ");
        add(lbltoday);
        lbltoday.setForeground(Color.black);
        //lbltoday.setBackground(Color.green);
        lbltoday.setFont(new Font("Serif", Font.BOLD, 20));
        lbltoday.setBounds(650,10,300,50);
        //lbltoday.setBorder(BorderFactory.createLineBorder(new Color(	51,54,69),5));
        //LineBorder line = new LineBorder(Color.black, 7, true);
        //lbltoday.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
        //lbltoday.setOpaque(true);
        bg_label.add(lbltoday);

        JLabel datatoday=new JLabel("93,73,188",JLabel.CENTER);
        add(datatoday);
        datatoday.setForeground(Color.black);
        datatoday.setBackground(new Color(51,54,69));
        datatoday.setFont(new Font("Serif", Font.BOLD, 28));
        datatoday.setBounds(650,50,220,50);
        datatoday.setBorder(BorderFactory.createLineBorder(Color.black,4));
        bg_label.add(datatoday);


        //TODO : Get vaccination data from API
        JLabel btn_totalvacc = new JLabel("1390000000",JLabel.CENTER);
        add(btn_totalvacc);
        btn_totalvacc.setFont(new Font("Serif", Font.BOLD, 25));
        btn_totalvacc.setBackground(new Color(46, 134, 193));
        btn_totalvacc.setForeground(new Color(247,249,249));
        btn_totalvacc.setBounds(750+x,560+y,170,50);
        btn_totalvacc.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
        btn_totalvacc.setOpaque(true);




    }


    Runnable rr = ()->{
        try {
            while (true)
            {
                th.sleep(3000); //for 3 seconds
                l1.setIcon(new ImageIcon(home.class.getResource("/c2.jpg")));
                r1.setSelected(false);
                r3.setSelected(false);
                r2.setSelected(true);

                th.sleep(3000);
                l1.setIcon(new ImageIcon(home.class.getResource("/c3.jpg")));
                r1.setSelected(false);
                r2.setSelected(false);
                r3.setSelected(true);

                th.sleep(3000);
                l1.setIcon(new ImageIcon(home.class.getResource("/c4.png")));
                r2.setSelected(false);
                r3.setSelected(false);
                r1.setSelected(true);


            }
        }
        catch (Exception e)
        {

        }
    };
}
