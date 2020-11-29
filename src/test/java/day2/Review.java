package day2;

import java.sql.*;

public class Review {
    public static void main(String[] args) throws SQLException {

        String connectionStr = "jdbc:oracle:thin:@54.235.57.249:1521:XE";
        String username = "hr";
        String password = "hr";
        Connection conn = DriverManager.getConnection(connectionStr, username, password);
        Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
        ResultSet rs = stmt.executeQuery("SELECT * FROM JOBS");

        rs.next();
        System.out.println("First column value in jobs : "+ rs.getString(1));
        System.out.println("Second column value in jobs : "+ rs.getString(2));


        rs.absolute(7);
        System.out.println("Second column value in jobs in row 7 is: "+ rs.getString(1));
        System.out.println("Second column value in jobs in row 7 is: "+ rs.getString(2));


        rs.last();
        System.out.println("First column value in jobs in last row is: "+ rs.getString(1));
        System.out.println("Second column value in jobs in last row is: "+ rs.getString(2));


        rs.previous();
        System.out.println("First column value in jobs in 2nd row from last is: "+ rs.getString(1));
        System.out.println("Second column value in jobs in 2nd row from last is: "+ rs.getString(2));


        System.out.println("------------Loop from top to bottom");
        rs.beforeFirst();

        while (rs.next()){

            System.out.println("Loop First Column "+rs.getString("JOB_ID"));
        }

        System.out.println("\t ------------ Loop from last row till First row get MIN_SALARY Column as Number ------");


        rs.afterLast();
        while (rs.previous()){
            System.out.println("MIN SALARY AS NUMBER  $ "+rs.getDouble("MIN_SALARY"));
        }

        rs.close();
        stmt.close();
        conn.close();




    }
}
