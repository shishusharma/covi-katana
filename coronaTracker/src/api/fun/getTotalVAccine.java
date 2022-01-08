package api.fun;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.Myconnection.MyConnection;

public class getTotalVAccine {

    public getTotalVAccine() {
        getTotalVaccine();
    }

    public int getTotalVaccine() {
        int cnt=0;
        Connection con=(Connection) MyConnection.getConn();

        try {
            PreparedStatement stmt=(PreparedStatement) con.prepareStatement("SELECT Count(*) FROM vaccine where dose=0 and vace_dt>=CURRENT_DATE");
            ResultSet rs=stmt.executeQuery();


            while(rs.next()) {
                cnt=rs.getInt(1);

            }


        }catch(Exception e) {
            e.printStackTrace();
            System.out.println(e);
        }

        return cnt;
    }
//	public static void main(String[] args) {
//		getTotalVAccine gt=new getTotalVAccine();
//		System.out.println(gt.getTotalVaccine());
//	}
}
