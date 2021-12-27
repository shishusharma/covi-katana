package com.Myconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class MyConnection {

    public static Connection getConn() {
        Connection con=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/test", "root", "");
        }catch(SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return con;
    }

}