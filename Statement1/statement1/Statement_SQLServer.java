package statement1;

import java.sql.*;
/**
 * 
 * This class shows the use of :-
 * Statement.executeQuery() - Use this for select statements.
 * Statement.executeUpdate() - use this for insert, update, delete statements.

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
public class Statement_SQLServer {
	public static void main(String args[]) {
		try {

			// SQL Server Query String
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=dbJDBC;" + "userName=sa;" + "password=apkc";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(connectionUrl);

			//----------------Statement.executeQuery()------------------------------------------
			String querySelect = "select * from dbJDBC.dbo.Employees ";
//			String query2="insert into employees values("+text1.getText();
			Statement stSelect = conn.createStatement();

			//use executeQuery() to execute a select statement
			ResultSet rsSelect = stSelect.executeQuery(querySelect);
			
			while(rsSelect.next())
			{
				System.out.println("-------------------------------------------");
	        	//1st column starts from ONE.
	          System.out.println("Employee Number: "+rsSelect.getInt(1));
	          System.out.println("Employee Name: "+rsSelect.getString("eName"));
	          System.out.println("Employee Email: "+rsSelect.getString("eMail"));
	          System.out.println("-------------------------------------------");
			}
			//------------------Statement.executeUpdate()-----------------------------------------
			String queryUpdate = "update dbJDBC.dbo.Employees " +
					"set eName='Unknown' where eNo=1000" ;
			
			Statement stUpdate = conn.createStatement();
			
			//use executeUpdate() to execute a insert,update or delete statement
			// 1 denotes a sucessful database transaction
			int result=stUpdate.executeUpdate(queryUpdate);
			
			/**
			 * Positive result = Positive no i.e. no of rows affected.
			 * Negative result = Failure (Negative number is the error code)
			 */
			System.out.println("Update Result-->"+result);
			
		
			//---------------------------------------------------------
		} catch (Exception e) {
			System.out.println("Exception in main()-->" + e);
		}

	}

}
