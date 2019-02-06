package databaseMetaData1;

import java.sql.*;

/**
 * This class demonstrates the use of a DatabaseMetadata class
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

public class DatabaseMetaData_SQLServer {

	public static void main(String args[])
	{
		try{
		
			 //SQL Server Query String
		     String connectionUrl = "jdbc:sqlserver://localhost:1433;" +
		     "databaseName=dbJDBC;" +
		     "userName=sa;" + "password=apkc";
		 
		     Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		 	
		     Connection  conn = DriverManager.getConnection(connectionUrl);
		
			
		     DatabaseMetaData dbmd=conn.getMetaData();
			//-------------DB Driver----------------------------
			System.out.println("Driver Vesion-->"+dbmd.getDriverVersion());
			System.out.println("----------------------------");
			//-------------DB Roles and Users------------------------
			ResultSet rs=dbmd.getSchemas();
			while(rs.next())
			{
					System.out.println(rs.getString(1));
			}
			System.out.println("----------------------------");
			//------------------------------------------------
			System.out.println("Type Info-->"+dbmd.getTypeInfo());
			System.out.println("----------------------------");
			//------------------------------------------------
			System.out.println("URL-->"+dbmd.getURL());
			System.out.println("----------------------------");
			//------------------------------------------------
			System.out.println("UserName-->"+dbmd.getUserName());
			System.out.println("----------------------------");
			//------------------------------------------------
			System.out.println("Database Product Name-->"+dbmd.getDatabaseProductName());
			System.out.println("----------------------------");
			//------------------------------------------------
			System.out.println("Driver Name-->"+dbmd.getDriverName());
			System.out.println("----------------------------");
			//------------------------------------------------
			System.out.println("Database Product Version-->"+dbmd.getDatabaseProductVersion());
			System.out.println("----------------------------");
			//------------------------------------------------
			System.out.println("Driver Version-->"+dbmd.getDriverVersion());
			System.out.println("----------------------------");
			//------------------------------------------------
			System.out.println("Catalog Term-->"+dbmd.getCatalogTerm());
			System.out.println("----------------------------");
			//------------------------------------------------
			
			
		}
		catch(Exception e)
		{
			
		}
	}
	
}
