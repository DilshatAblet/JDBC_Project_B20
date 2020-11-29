package day2;

import java.sql.*;

public class GettingMoreInfoAboutResultSetObject {

    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@54.235.57.249:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmnt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmnt.executeQuery("SELECT * FROM EMPLOYEES");


        ResultSetMetaData rsmd = rs.getMetaData();
        int colCount = rsmd.getColumnCount();
        System.out.println("Column count = "+colCount);

        System.out.println("First Column Name is "+rsmd.getColumnLabel(1));
        System.out.println("Second Column Name is "+rsmd.getColumnLabel(2));


        for (int colNum = 1; colNum <= colCount ; colNum++) {
            System.out.println("Column name " + rsmd.getColumnLabel(colNum)   );
        }

        rs.close();
        stmnt.close();
        conn.close();






    }
}
