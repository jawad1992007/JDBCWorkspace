package callableStatement1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class CallableStatement_SQLServer {


	public static void main(String[] args) {
		
		try{
//		 SQL Server Query String
		String connectionUrl = "jdbc:sqlserver://localhost:1433;"
				+ "databaseName=dbJDBC;" + "userName=sa;" + "password=apkc";

		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		Connection conn = DriverManager.getConnection(connectionUrl);
		System.out.println("Connection Made!");
		
		String query = "{ call dbJDBC.dbo.usp_dbJDBC_Employees_SQLServer(?,?,?,?)}";
		
		CallableStatement cstmt = conn.prepareCall(query);
		cstmt.setInt(1, 99);
		cstmt.setString(2,"Ajay");
		cstmt.setString(3,"devgan@hotmail.com");
		cstmt.registerOutParameter(4, Types.VARCHAR);
		
		int i=cstmt.executeUpdate();
		String outputMessage = cstmt.getString(4);
		System.out.println("Output Message-->"+outputMessage);
			
		}
		catch(Exception e)
		{
			System.out.println("Exception in main()-->"+e);
			e.printStackTrace();
		}

	}

}
