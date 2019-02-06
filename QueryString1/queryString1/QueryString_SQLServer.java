package queryString1;



import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
/**
 * This class demonstrates the use of a database connection using a Query String
 * Database : SQL Server 2000
 * Schema: dbJDBC
 * Table: Employees
 * 
 * @Jar Files: 
 * - msbase.jar
 * - mssqlserver.jar
 * - msutil.jar
 * - sqljdbc.jar
 * 
 * @author Ankur Israni
 *
 */
public class QueryString_SQLServer {

public static void main(String args[]) {

Statement stmt=null;
Connection conn=null;

     //SQL Server Query String for a named instance

//     String connectionUrl = "jdbc:sqlserver://localhost\\SQL_SERVER_INST1:1433;" +
//     "databaseName=JDBC1;" +
//     "userName=sa;" + "password=apkc";


String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
"databaseName=dbJDBC;" +
"userName=sa;" + "password=apkc";

        try {
       // Establish the connection.

      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
       conn = DriverManager.getConnection(connectionUrl);
       System.out.println("Connection made...");

       //Execute SQL statements
    stmt = conn.createStatement();
    ResultSet rs = stmt.executeQuery("select * from Employees");

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

