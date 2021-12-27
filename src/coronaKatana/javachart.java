package coronaKatana;
import javax.swing.*;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class javachart extends JPanel{
            static double a=0,b=0,c=0,d=0;
            static double a1=0,b1=0,c1=0,d1=0;
            static String statenm;
    public static double getA1() {
        return a1;
    }

    public static void setA1(double a1) {
        javachart.a1 = a1;
    }

    public static double getB1() {
        return b1;
    }

    public static void setB1(double b1) {
        javachart.b1 = b1;
    }

    public static double getC1() {
        return c1;
    }

    public static void setC1(double c1) {
        javachart.c1 = c1;
    }

    public static double getD1() {
        return d1;
    }

    public static void setD1(double d1) {
        javachart.d1 = d1;
    }

    public static String getStatenm() {
        return statenm;
    }

    public static void setStatenm(String statenm) {
        javachart.statenm = statenm;
    }



    public javachart() {
        //System.out.println(s);
        System.out.println("java chart getAT "+getA1());
        setBounds(690,250,500 , 400 );
        setVisible(true);
//        setA1(a);
//        setB1(b);
//        setC1(c);
//        setD1(d);

        a=FrontView.SWU.getTodynewAct();
        b=FrontView.SWU.getTotalAct_case();
        c=FrontView.SWU.getTotalDeth();
        d=FrontView.SWU.getTotalInf_case();
        System.out.println("geet A1 "+getA1());
        add(javachart.createDemoPanel());
        JFreeChart chart = createChart(createDataset( ) );


        //super( title );
        //setContentPane(createDemoPanel( ));
    }

    private static PieDataset createDataset( ) {
        DefaultPieDataset dataset = new DefaultPieDataset( );
//
        dataset.setValue( "Recovered" ,Double.valueOf(getC1()) );
        dataset.setValue( "Total Cases" , Double.valueOf( getB1()) );
        dataset.setValue( "Active Cases" , Double.valueOf(getA1()) );
        dataset.setValue( "Deaths" , Double.valueOf(getD1()));


//        dataset.setValue( "Today Recoverd" ,Double.valueOf(a));//Double.valueOf(a)
//        dataset.setValue( "Total Active" , Double.valueOf(b));//Double.valueOf( b)
//        dataset.setValue( "Total Death" , Double.valueOf(c));//Double.valueOf(c)
//        dataset.setValue( "Total Infected" ,Double.valueOf(d));// Double.valueOf(d)
        return dataset;
    }

    private static JFreeChart createChart( PieDataset dataset ) {
        JFreeChart chart = ChartFactory.createPieChart(
                ""+getStatenm()+"",   // chart title+getStatenm()
                dataset,          // data
                true,             // include legend
                true,
                false);

        return chart;
    }

    public static JPanel createDemoPanel( ) {
        JFreeChart chart = createChart(createDataset( ) );
        return new ChartPanel( chart );
    }


//    public static void main( String[ ] args ) {
//        javachart demo = new javachart( );
//        demo.setSize( 700 , 507 );
//        //RefineryUtilities.centerFrameOnScreen( demo );
//        demo.setVisible( true );
//    }
}