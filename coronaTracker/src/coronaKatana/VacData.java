package coronaKatana;
import org.json.JSONObject;

import com.Myconnection.MyConnection;
import com.mysql.jdbc.ResultSet;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VacData extends JFrame
{
    static String []header={"States","First Dose","Second Dose","Total"};
    static DefaultTableModel tm=new DefaultTableModel(header,0);
    JTable jt1;
    JScrollPane jsp;


    public VacData() {
        setLayout(null);
        setVisible(true);
        setBounds(200,50,1250,670);
        jt1=new JTable(tm);
        add(jsp=new JScrollPane(jt1));
        jsp.setBounds(550,300,600,350);
        //jsp.setSize(w,h);
        //setSize(w,h);

        //Creating the client object
        HttpClient client=HttpClient.newHttpClient();

        //Request Setup
        HttpRequest request=HttpRequest.newBuilder().uri(URI.create("https://data.covid19india.org/v4/min/data.min.json")).build();

        /*
            Now sending the request Asynchronously.
            Here, the first parameter is the request, and the second is the way in which
            the response is required from the Server, here as String.
         */
        /*
            The sendAsync() method returns CompletableFuture type data.
            Then thisApply() is used for the received results.
            Then thisAccept() is used.

            join() is used to basically display the result.

         */
        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
                .thenApply(VacData::parse)
                .join();
    }
    public static void main(String[] args) {
//        //Creating the client object
//        HttpClient client=HttpClient.newHttpClient();
//
//        //Request Setup
//        HttpRequest request=HttpRequest.newBuilder().uri(URI.create("https://data.covid19india.org/v4/min/data.min.json")).build();
//
//        /*
//            Now sending the request Asynchronously.
//            Here, the first parameter is the request, and the second is the way in which
//            the response is required from the Server, here as String.
//         */
//        /*
//            The sendAsync() method returns CompletableFuture type data.
//            Then thisApply() is used for the received results.
//            Then thisAccept() is used.
//
//            join() is used to basically display the result.
//
//         */
//        client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
//                .thenApply(HttpResponse::body)
//                .thenApply(NewJSON::parse)
//                .join();
        new VacData();
    }

    /*
        Parsing the JSON Data
     */
    public static String parse(String responseBody)
    {
        Connection con=(Connection) MyConnection.getConn();
        JSONObject obj=new JSONObject(responseBody);
        long sze=0;
        int i=0;
        for (Object key : obj.keySet()) {
            //based on you key types
            String keyStr = (String)key;
            Object keyvalue = obj.get(keyStr);

            long sum=0;
            JSONObject state= obj.getJSONObject(keyStr);
            JSONObject total=state.getJSONObject("total");
            //System.out.println("state : "+ keyStr+" vac1 :"+total.getInt("vaccinated2"));
            sum=total.getInt("vaccinated1")+total.getInt("vaccinated2");
            i++;
            try {
                ResultSet rs= (ResultSet) con.prepareStatement("select statenm from statename where statewdId='"+keyStr+"'").executeQuery();
                if(rs.next()) {
                    Object []objj= {rs.getString("statenm"),total.getInt("vaccinated1"),total.getInt("vaccinated2"),sum};
                   // System.out.println("state : "+ rs.getString("statenm")+"vac1 : "+total.getInt("vaccinated1")+" vac2  : "+total.getInt("vaccinated2")+" total : "+sum);

                    tm.addRow(objj);
                }
            }catch (Exception e) {
                // TODO: handle exception
            }
            // System.out.println("state : "+ keyStr+"vac1 : "+total.getInt("vaccinated1")+" vac2  : "+total.getInt("vaccinated2")+" total : "+sum);
            //System.out.println(keyStr+": Vac1 : "+total.getInt("vaccinated1")+" | Vac2 : "+total.getInt("vaccinated2"));
            //vaccinated1  "     "vaccinated2  "     "TotalVac
        }




        System.out.println(sze+" "+i);
        return null;


//    	Connection con=(Connection) MyConnection.getConn();
//        JSONObject obj=new JSONObject(responseBody);
//        long sze=0;
//        int i=0;
//        for (Object key : obj.keySet()) {
//            //based on you key types
//            String keyStr = (String)key;
//            Object keyvalue = obj.get(keyStr);
//
//            long sum=0;
//            JSONObject state= obj.getJSONObject(keyStr);
//            JSONObject total=state.getJSONObject("total");
//            //System.out.println("state : "+ keyStr+" vac1 :"+total.getInt("vaccinated2"));
//            sum=total.getInt("vaccinated1")+total.getInt("vaccinated2");
//            i++;
//            System.out.println("state : "+ keyStr+"vac1 : "+total.getInt("vaccinated1")+" vac2  : "+total.getInt("vaccinated2")+" total : "+sum);
//				try {
//
//			ResultSet rs= (ResultSet) con.prepareStatement("select statenm from statename where statewdId="+keyStr+"").executeQuery();
//			if(rs.next()) {
//				System.out.println(rs.getString("statenm"));
////				Object []objj= {rs.getString("statenm"),total.getInt("vaccinated1"),total.getInt("vaccinated2"),sum};
////				System.out.println("state : "+ rs.getString("statenm")+"vac1 : "+total.getInt("vaccinated1")+" vac2  : "+total.getInt("vaccinated2")+" total : "+sum);
////
////				tm.addRow(objj);
//			}
//
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//
//		}
//
//
//            //System.out.println(keyStr+": Vac1 : "+total.getInt("vaccinated1")+" | Vac2 : "+total.getInt("vaccinated2"));
//            //vaccinated1  "     "vaccinated2  "     "TotalVac
//        }
//        System.out.println(sze+" "+i);
//        return null;
//
    }




}
