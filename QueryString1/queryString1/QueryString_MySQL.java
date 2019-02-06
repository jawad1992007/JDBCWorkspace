package queryString1;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class QueryString_MySQL {

public static void main(String args[]) {

Statement stmt=null;
Connection conn=null;

     //SQL Server Query String for a named instance

     String connectionUrl = "jdbc:mysql://localhost:3306/dbjdbc";
        try {
       // Establish the connection.

      Class.forName("com.mysql.jdbc.Driver");
       conn = DriverManager.getConnection(connectionUrl,"root","apkc");
       System.out.println("Connection made...");

       //Execute SQL statements
    stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("select * from Employees");
    
    ResultSetMetaData rsmd=rs.getMetaData();
    System.out.println("col count="+rsmd.getColumnCount());
    String colNameForCol1=rsmd.getColumnName(1);
    System.out.println("col name for col1="+colNameForCol1);
    

    if (rs != null) {
      System.out.println("rs is not null");
      while (rs.next()) {
    		System.out.println("-------------------------------------------");
        	//1st column starts from ONE.
          System.out.println("Employee Number: "+rs.getInt(1));
          System.out.println("Employee Name: "+rs.getString("eName"));
          System.out.println("Employee Email: "+rs.getString("eMail"));
          System.out.println("-------------------------------------------");
      }
    }
  }



  //   } //try

     catch (Exception e) {
       e.printStackTrace();
     } //catch

     //Get SQL Server 2000 Connection


   } //getSQL2000Connection()


}

