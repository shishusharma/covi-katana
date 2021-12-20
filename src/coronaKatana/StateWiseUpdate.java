package coronaKatana;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;

import java.awt.Color;
import java.awt.Font;

import org.json.JSONArray;
import org.json.JSONObject;

import WonHeaderRenderer.WonHeaderRenderer;


//class coronaStatus extends JFrame{
//	/**
//	 * 
//	 */
//	private static final long serialVersionUID = 1L;
//	Container c=getContentPane();
//	StatewiseJPanel cSP=new StatewiseJPanel();
//	public coronaStatus() {
//		setVisible(true);
//		setLayout(null);
//		setSize(800,400);
//		c.add(cSP);
//		
//	}
//	
//	
//	///panel start
//	class StatewiseJPanel extends JPanel{
//		
//    	/**
//		 * 
//		 */
//		private static final long serialVersionUID = 1L;
//		
//		JScrollPane jsp;
//		//states,activeCases,totalInfected,recovered
//    	static String []header={"States","Active Case","Total Case","Recovered"};
//    	static DefaultTableModel tm=new DefaultTableModel(header,0);
//    	JTable jt1;
//    	
//    	
//		public StatewiseJPanel() {
//			setLayout(null);
//			setVisible(true);
//			setSize(1650,400);
//			setBackground(Color.red);
//			jt1=new JTable(tm);
//			add(jsp=new JScrollPane(jt1));
//			jsp.setBounds(0,0,1650,400);
//			
//			HttpClient client=HttpClient.newHttpClient();
//			System.out.println("ActionPerformed");
//	        //Request Setup
//	        HttpRequest request=HttpRequest.newBuilder().uri(URI.create("https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true")).build();
//	        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenApply(StatewiseJPanel::parse).join();
//	    
//		}
//		
//		public static String parse(String responseBody)
//	    {
//	        JSONObject session=new JSONObject(responseBody);
//	        System.out.println("sharma");
//
//	        JSONArray arr=session.getJSONArray("regionData");
//
//	        for(int i=0;i<arr.length();i++)
//	        {
//	            JSONObject cdata=arr.getJSONObject(i);
//	            String states=cdata.getString("region");
//	            int totalInfected=cdata.getInt("totalInfected");
//	            int activeCases=cdata.getInt("activeCases");
//	            int recovered=cdata.getInt("recovered");
//	            
//	            Object []obj= {states,activeCases,totalInfected,recovered};
//	            try {
//					tm.addRow(obj);
//				} catch (Exception e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//	        }
//	        return null;
//
//	    }
//		
//	}//panel end
//}









public class StateWiseUpdate extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JScrollPane jsp;
	//states,activeCases,totalInfected,recovered
	static String []header={"States","Active Case","Total Case","Recovered"};
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

	public StateWiseUpdate(){
		
		 		
				setLayout(null);
				setVisible(false);
				//setSize(w,h);
				setBounds(200,0,1450,720);
				setBackground(Color.red);
				jt1=new JTable(tm);
				jt1.getTableHeader().setDefaultRenderer(new DrawnHeaderRenderer());
				jt1.getColumnModel().getColumn(1).setHeaderRenderer(new WonHeaderRenderer());
				jt1.getColumnModel().getColumn(2).setHeaderRenderer(new LostHeaderRenderer());
				jt1.getColumnModel().getColumn(3).setHeaderRenderer(new CyanHeaderRenderer());
				JTableHeader header = jt1.getTableHeader();
				header.setDefaultRenderer(new KeepSortIconHeaderRenderer(header.getDefaultRenderer()));
//				for(int i=1;i<=3;i++) {
//		        	   // tbl_centers.setRowSorter(sorter);
//		    		jt1.getColumnModel().getColumn(i).setCellRenderer(new ButtonRenderer());
//		    		
//		    		//set custom editor to teams coulumn
//		    		jt1.getColumnModel().getColumn(i).setCellEditor(new ButtonEditor(new JTextField()));
//		    			
//		        }
			
//			      table.getColumnModel().getColumn(0).setCellRenderer(cellRenderer);
				add(jsp=new JScrollPane(jt1));
				jsp.setBounds(550,300,600,350);
				
				//jsp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
				//jsp.setSize(w,h);
				
				HttpClient client=HttpClient.newHttpClient();
				System.out.println("ActionPerformed");
		        //Request Setup
		        HttpRequest request=HttpRequest.newBuilder().uri(URI.create("https://api.apify.com/v2/key-value-stores/toDWvRj1JpTXiM8FF/records/LATEST?disableRedirect=true")).build();
		        client.sendAsync(request, HttpResponse.BodyHandlers.ofString()).thenApply(HttpResponse::body).thenApply(StateWiseUpdate::parse).join();
		        
		        int x=30,y=-30,lx=0,ly=0,bx=0,by=-30;
		        //infected case
		        JLabel lbl_tInf=new JLabel("Total Infected");
		        lbl_tInf.setFont(new Font("Serif", Font.BOLD, 25));
		        lbl_tInf.setBounds(0+x,300+y,200,60);
		        add(lbl_tInf);
		        btn_totalInf=new JButton(""+getTotalInf_case());
		        btn_totalInf.setFont(new Font("Serif", Font.BOLD, 30));
		        btn_totalInf.setBackground(new Color(46, 134, 193));
		        btn_totalInf.setForeground(new Color(247,249,249));
		        btn_totalInf.setBounds(0+x,360+y,170+bx,+by+170);
		        btn_totalInf.setOpaque(true);
				add(btn_totalInf);
				
		        //Today New Infecdet
		        JLabel lbl_Tinf=new JLabel("Total Recoverd");
		        lbl_Tinf.setFont(new Font("Serif", Font.BOLD, 25));
		        lbl_Tinf.setBounds(0+x,500+y,200,60);
		        add(lbl_Tinf);
		        JButton btn_todyInf=new JButton(""+getTodynewAct());
		        btn_todyInf.setFont(new Font("Serif", Font.BOLD, 30));
		        btn_todyInf.setBackground(new Color(46, 134, 193));
		        btn_todyInf.setForeground(new Color(247,249,249));
		        btn_todyInf.setBounds(0+x,560+y,170+bx,by+170);
		        btn_todyInf.setOpaque(true);
				add(btn_todyInf);
								

				//Active case
				JLabel lbl_Act=new JLabel("Total Active");
				lbl_Act.setFont(new Font("Serif", Font.BOLD, 25));
				lbl_Act.setBounds(210+x,300+y,200,60);
		        add(lbl_Act);
		        JButton btn_totalAct=new JButton(""+getTotalAct_case());
		        btn_totalAct.setFont(new Font("Serif", Font.BOLD, 30));
		        btn_totalAct.setBackground(new Color(46, 134, 193));
		        btn_totalAct.setForeground(new Color(247,249,249));
		        btn_totalAct.setBounds(210+x,360+y,170+bx,by+170);
		        btn_totalAct.setOpaque(true);
				add(btn_totalAct);
				
				//Total Deth
				JLabel lbl_Death=new JLabel("Total Death");
				lbl_Death.setFont(new Font("Serif", Font.BOLD, 25));
				lbl_Death.setBounds(210+x,500+y,200,60);
		        add(lbl_Death);
		        JButton btn_totalDeath=new JButton(""+getTotalDeth());
		        btn_totalDeath.setFont(new Font("Serif", Font.BOLD, 30));
		        btn_totalDeath.setBackground(new Color(46, 134, 193));
		        btn_totalDeath.setForeground(new Color(247,249,249));
		        btn_totalDeath.setBounds(210+x,560+y,170+bx,by+170);
		        btn_totalDeath.setOpaque(true);
				add(btn_totalDeath);
				
				
			}
			
			public static String parse(String responseBody)
		    {
		        JSONObject session=new JSONObject(responseBody);
		        System.out.println("sharma");

		        JSONArray arr=session.getJSONArray("regionData");
		        	long Tinf=0;
		        	long Tactive=0;
		        	long Trecoverd=0;
		        	long Tdeth=0;
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
		            Object []obj= {states,activeCases,totalInfected,recovered};
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

	
	
//	public static void main(String[] args) {
//		new StateWiseUpdate();
//		
//    }
}
