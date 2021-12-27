package coronaKatana;

import java.awt.*;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.*;

import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.table.DefaultTableModel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.general.DefaultPieDataset;
import org.json.JSONArray;
import org.json.JSONObject;

public class StateWiseUpdate extends JPanel
{
	private static final long serialVersionUID = 1L;
	JScrollPane jsp;
	//states,activeCases,totalInfected,recovered
	static javachart jc;
	static String []header={"States","Active Case","Total Case","Recovered","Deaths"};
	static DefaultTableModel tm=new DefaultTableModel(header,0);
	JTable jt1;
	JButton btn_totalInf;
	static long totalInf_case=0;
	static long totalAct_case=0;
	static long todynewAct=0;
	static long totalDeth=0;

	public static long getTodynewAct() {
		return todynewAct;
	}

	public static void setTodynewAct(long todynewAct) {
		StateWiseUpdate.todynewAct = todynewAct;
	}

	public static long getTotalDeth() {
		return totalDeth;
	}

	public static void setTotalDeth(long totalDeth) {
		StateWiseUpdate.totalDeth = totalDeth;
	}

	public static long getTotalAct_case() {
		return totalAct_case;
	}

	public static void setTotalAct_case(long totalAct_case) {
		StateWiseUpdate.totalAct_case = totalAct_case;
	}

	public static long getTotalInf_case() {
		return totalInf_case;
	}

	public static void setTotalInf_case(long totalInf_case) {
		StateWiseUpdate.totalInf_case = totalInf_case;
	}

	public StateWiseUpdate()
	{


		//Default bg color : 218,218,218
		setLayout(null);
		setVisible(false);

		//setSize(w,h);
		setBounds(200,50,1250,670);
		setBackground(new Color(0, 128, 255));
		jt1=new JTable(tm);
		jt1.getColumnModel().getColumn(0).setMinWidth(200);

		jt1.setRowHeight(jt1.getRowHeight()+10);
		// tbl_centers.setRowSorter(sorter);
		jt1.getColumnModel().getColumn(0).setCellRenderer(new StateRenderer());

		//set custom editor to teams coulumn
		jt1.getColumnModel().getColumn(0).setCellEditor(new ButtonEditorState(new JTextField()));


		add(jsp=new JScrollPane(jt1));
		jsp.setBounds(80,300,600,350);
		jsp.setBorder(new CompoundBorder(
				BorderFactory.createMatteBorder(3, 3, 3, 3, Color.black),
				BorderFactory.createMatteBorder(0, 0, 0, 0, Color.white)));
		//jsp.setSize(w,h);


		HttpClient client=HttpClient.newHttpClient();
		System.out.println("ActionPerformed");

		//Request Setup
		HttpRequest request=HttpRequest.newBuilder().uri(URI.create("https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true")).build();
		client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenApply(StateWiseUpdate::parse).join();

		JLabel title=new JLabel("Covid-19 : Impact on India",JLabel.CENTER);
		title.setBounds(0,0,1250,80);
		title.setBackground(Color.red);
		title.setForeground(Color.white);
		title.setFont(new Font("Serif", Font.BOLD, 32));
		add(title);

//		ImageIcon icon=new ImageIcon(StateWiseUpdate.class.getResource("/covi.png"));
//		JLabel pic=new JLabel();
//		pic.setBounds(50,100,1094,181);
//		pic.setIcon(icon);
//		add(pic);

		int x=30,y=-30,lx=0,ly=0,bx=0,by=-30;
		//infected case
		JLabel bg_data=new JLabel();
		bg_data.setBackground(new Color(223, 255, 0));
		bg_data.setBounds(80,90,1070,150);
		bg_data.setOpaque(true);
		bg_data.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
		add(bg_data);

		JLabel lbl_tInf=new JLabel("Total Infected");
		lbl_tInf.setFont(new Font("Serif", Font.BOLD, 25));
		lbl_tInf.setBounds(60,10,200,30);
		add(lbl_tInf);
		bg_data.add(lbl_tInf);

		JLabel lbl_trec=new JLabel("Total Recoverd");
		lbl_trec.setFont(new Font("Serif", Font.BOLD, 25));
		lbl_trec.setBounds(310,10,200,30);
		add(lbl_trec);
		bg_data.add(lbl_trec);

		//Active case
		JLabel lbl_Act=new JLabel("Total Active");
		lbl_Act.setFont(new Font("Serif", Font.BOLD, 25));
		lbl_Act.setBounds(575,10,200,30);
		add(lbl_Act);
		bg_data.add(lbl_Act);
		//Total Death
		JLabel lbl_Death=new JLabel("Total Death");
		lbl_Death.setFont(new Font("Serif", Font.BOLD, 25));
		lbl_Death.setBounds(850,10,200,30);
		add(lbl_Death);
		bg_data.add(lbl_Death);

		//Total Cases Data
		JLabel totinf=new JLabel(""+getTotalInf_case(),JLabel.CENTER);
		totinf.setFont(new Font("Serif", Font.BOLD, 30));
		totinf.setBackground(Color.black);
		totinf.setForeground(new Color(247,249,249));
		totinf.setBounds(40,50,180,50);
		totinf.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
		totinf.setOpaque(true);
		add(totinf);
		bg_data.add(totinf);

		//Total Recovered Data
		JLabel totrec=new JLabel(""+getTodynewAct(),JLabel.CENTER);
		totrec.setFont(new Font("Serif", Font.BOLD, 30));
		totrec.setBackground(Color.black);
		totrec.setForeground(new Color(247,249,249));
		totrec.setBounds(295,50,180,50);
		totrec.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
		totrec.setOpaque(true);
		add(totrec);
		bg_data.add(totrec);

		//Total Active Data
		JLabel btn_totalAct=new JLabel(""+getTotalAct_case(),JLabel.CENTER);
		btn_totalAct.setFont(new Font("Serif", Font.BOLD, 30));
		btn_totalAct.setBackground(Color.black);
		btn_totalAct.setForeground(new Color(247,249,249));
		btn_totalAct.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
		btn_totalAct.setBounds(555,50,180,50);
		btn_totalAct.setOpaque(true);
		add(btn_totalAct);
		bg_data.add(btn_totalAct);

		//Total Death Data
		JLabel btn_totalDeath=new JLabel(""+getTotalDeth(),JLabel.CENTER);
		btn_totalDeath.setFont(new Font("Serif", Font.BOLD, 30));
		btn_totalDeath.setBackground(Color.black);
		btn_totalDeath.setForeground(new Color(247,249,249));
		btn_totalDeath.setBounds(830,50,180,50);
		btn_totalDeath.setBorder(BorderFactory.createSoftBevelBorder(BevelBorder.RAISED));
		btn_totalDeath.setOpaque(true);
		add(btn_totalDeath);
		bg_data.add(btn_totalDeath);

		JLabel selData=new JLabel("Select any State/UT to see the visual data.");
		selData.setFont(new Font("Serif", Font.BOLD, 25));
		selData.setBounds(80,250,500,30);
		selData.setForeground(Color.white);
		add(selData);
		add(new JcIndia());
	}
//	public void showPieChart()
//	{
//		DefaultPieDataset dataset = new DefaultPieDataset( );
//		dataset.setValue( "IPhone 5s" ,Double.valueOf( 20 ) );
//		dataset.setValue( "SamSung Grand" , Double.valueOf( 20 ) );
//		dataset.setValue( "MotoG" , Double.valueOf( 40 ) );
//		dataset.setValue( "Nokia Lumia" , Double.valueOf( 10 ) );
//
//		JFreeChart piechart= ChartFactory.createPieChart("Mobile Sale",dataset,false,true,false);
//		PiePlot piePlot=(PiePlot) piechart.getPlot();
//
//		piePlot.setSectionPaint("IPhone",Color.red);
//		piePlot.setSectionPaint("Samsung",Color.pink);
//		piePlot.setSectionPaint("Moto",Color.cyan);
//		piePlot.setSectionPaint("Nokia",Color.green);
//
//		ChartPanel barChartPanel=new ChartPanel(piechart);
//		StateWiseUpdate.add(barChartPanel, BorderLayout.CENTER);
//		StateWiseUpdate.validate();
//	}

	public static String parse(String responseBody)
	{
		JSONObject session=new JSONObject(responseBody);
		System.out.println("sharma");

		JSONArray arr=session.getJSONArray("regionData");
		long Tinf=0;
		long Tactive=0;
		long Trecoverd=0;
		long Tdeth=0;
		tm.setRowCount(0);
		for(int i=0;i<arr.length();i++)
		{
			JSONObject cdata=arr.getJSONObject(i);
			String states=cdata.getString("region");
			int totalInfected=cdata.getInt("totalInfected");
			int activeCases=cdata.getInt("activeCases");
			int recovered=cdata.getInt("recovered");
			//int newInfected=cdata.getInt("newInfected");
			int newDeath=cdata.getInt("deceased");
			Tactive+=activeCases;
			Tinf+=totalInfected;
			Trecoverd+=recovered;
			Tdeth+=newDeath;
			Object []obj= {states,activeCases,totalInfected,recovered,newDeath};
			try {
				tm.addRow(obj);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Tinf);
		setTotalInf_case(Tinf);
		setTotalAct_case(Tactive);
		setTodynewAct(Trecoverd);
		System.out.println("total deth"+Tdeth);
		setTotalDeth(Tdeth);

		return null;

	}
	//panel end
}
