package coronaKatana;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.*;

import java.awt.Color;
import java.awt.Font;

public class home extends JFrame{
    public static void main(String[] args) {
        new home();
    }
    public home()
    {
        setLayout(null);
        setVisible(true);
        //setSize(w,h);
        setBounds(200,0,1450,720);
        setBackground(new Color(236, 240, 241));

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


        //Fetiching data for the buttons
        HttpClient client=HttpClient.newHttpClient();
        System.out.println("ActionPerformed");
        //Request Setup
        HttpRequest request=HttpRequest.newBuilder().uri(URI.create("https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true")).build();
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenApply(StateWiseUpdate::parse).join();

        //Title for the page
        JLabel title=new JLabel("#UniteToFightCorona",JLabel.CENTER);
        add(title);
        title.setBounds(0,0,1350,100);
        title.setBackground(Color.red);
        title.setForeground(new Color(51,54,69));
        title.setFont(new Font("Serif", Font.BOLD, 32));


        int x=30,y=-30,lx=0,ly=0,bx=0,by=-30;
        //infected case
        JLabel lbl_tInf=new JLabel("Total Infected");
        add(lbl_tInf);
        lbl_tInf.setFont(new Font("Serif", Font.BOLD, 25));
        lbl_tInf.setBounds(0+x,300+y,200,60);
       

        btn_totalInf=new JButton(""+StateWiseUpdate.getTotalInf_case());
        add(btn_totalInf);
        btn_totalInf.setFont(new Font("Serif", Font.BOLD, 30));
        btn_totalInf.setBackground(new Color(46, 134, 193));
        btn_totalInf.setForeground(new Color(247,249,249));
        btn_totalInf.setBounds(0+x,360+y,170+bx,+by+170);
        btn_totalInf.setOpaque(true);
       

        //Today New Infecdet
        JLabel lbl_Tinf=new JLabel("Total Recoverd");
        add(lbl_Tinf);
        lbl_Tinf.setFont(new Font("Serif", Font.BOLD, 25));
        lbl_Tinf.setBounds(0+x,500+y,200,60);
       
        JButton btn_todyInf=new JButton(""+StateWiseUpdate.getTodynewAct());
        add(btn_todyInf);
        btn_todyInf.setFont(new Font("Serif", Font.BOLD, 30));
        btn_todyInf.setBackground(new Color(51,54,69));
        btn_todyInf.setForeground(new Color(247,249,249));
        btn_todyInf.setBounds(0+x,560+y,170+bx,by+170);
        btn_todyInf.setOpaque(true);



        //Active case
        JLabel lbl_Act=new JLabel("Total Active");
        add(lbl_Act);
        lbl_Act.setFont(new Font("Serif", Font.BOLD, 25));
        lbl_Act.setBounds(210+x,300+y,200,60);
       
        JButton btn_totalAct=new JButton(""+StateWiseUpdate.getTotalAct_case());
        add(btn_totalAct);
        btn_totalAct.setFont(new Font("Serif", Font.BOLD, 30));
        btn_totalAct.setBackground(new Color(0,0,0));
        btn_totalAct.setForeground(new Color(247,249,249));
        btn_totalAct.setBounds(210+x,360+y,170+bx,by+170);
        btn_totalAct.setOpaque(true);
        
        //Total Deth
        JLabel lbl_Death=new JLabel("Total Death");
        add(lbl_Death);
        lbl_Death.setFont(new Font("Serif", Font.BOLD, 25));
        lbl_Death.setBounds(210+x,500+y,200,60);
       
        JButton btn_totalDeath=new JButton(""+StateWiseUpdate.getTotalDeth());
        add(btn_totalDeath);
        btn_totalDeath.setFont(new Font("Serif", Font.BOLD, 30));
        btn_totalDeath.setBackground(new Color(46, 134, 193));
        btn_totalDeath.setForeground(new Color(247,249,249));
        btn_totalDeath.setBounds(210+x,560+y,170+bx,by+170);
        btn_totalDeath.setOpaque(true);
       

    }
}
