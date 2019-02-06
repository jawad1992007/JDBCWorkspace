package dsn1;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DSN_MySQL {

  public static void main(String args[])  {
	  Connection con=null;
    try {
		Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
		con = DriverManager.getConnection("jdbc:odbc:dsn_MySQL_dbJDBC", "root", "apkc");
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

