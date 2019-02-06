package dsn1;



import java.sql.*;
import java.util.*;
/**
 * Class demonstrates the use of connenting to a database using a DSN(Database Source Name)
 * DSN Name: dsn_SQLServer_dbJDBC
 * Database : SQL Server 2000
 * Schema: Master
 * Table: dbJDBC.Employees
 * 
 * @author Ankur
 *
 */
public class DSN_SQLServer {

  public static void main(String args[])  {
	  Connection con=null;
    try {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con = DriverManager.getConnection("jdbc:odbc:dsn_SQLServer_dbJDBC", "sa", "apkc");
		System.out.println("Connection made...");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("select * from employees");

		while (rs.next()) {
			System.out.println("-------------------------------------------");
			//1st column starts from ONE.
		  System.out.println("Employee Number: "+rs.getInt(1));
		  System.out.println("Employee Name: "+rs.getString("eName"));
		  System.out.println("Employee Email: "+rs.getString("eMail"));
		  System.out.println("-------------------------------------------");
		  
		}
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	finally{
		try
		{
			if(con!=null)
			{
				con.close();
			}
		}
		catch(SQLException se)
		{
			
		}
	}
    

  }

}

