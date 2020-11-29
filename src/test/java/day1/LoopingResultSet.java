package day1;

import java.sql.*;

public class LoopingResultSet {

    public static void main(String[] args) throws SQLException {


        String connectionStr = "jdbc:oracle:thin:@54.235.57.249:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmnt = conn.createStatement();
        ResultSet rs = stmnt.executeQuery("SELECT * FROM REGIONS");

        while(rs.next()){

            System.out.println("Region_ID : "+ rs.getString("REGION_ID"));
            System.out.println("REGION_NAME : "+ rs.getString("REGION_NAME"));

        }


        rs = stmnt.executeQuery("SELECT * FROM COUNTRIES");
        while (rs.next()) {

            System.out.print(rs.getString(1)+ "\t");
            System.out.print(rs.getString(2)+ "\t");
            System.out.println(rs.getString(3));


        }


    }
}