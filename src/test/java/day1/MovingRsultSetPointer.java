package day1;

import java.sql.*;

public class MovingRsultSetPointer {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@54.235.57.249:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("SELECT * FROM REGIONS");

        while (rs.next()){

            System.out.println("REGION_NAME : "+rs.getString("REGION_NAME"));

        }

//        rs.previous();
//        System.out.println("REGION_NAME : "+rs.getString("REGION_NAME"));

        while (rs.previous()){
            System.out.println("BACKWARD - REGION_NAME " + rs.getString("REGION_NAME") );
        }

        rs.beforeFirst();
        rs.first();
        rs.last();
        rs.afterLast();
        rs.absolute(3);

        rs.last();
        int currentRowNum = rs.getRow();
        System.out.println("Row count : "+ currentRowNum);

    }
}
