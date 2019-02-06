package statement1;

import java.sql.*;

public class Statement_MySQL {
	public static void main(String args[]) {
		try {

		     String connectionUrl = "jdbc:mysql://localhost:3306/dbjdbc";
		      Class.forName("com.mysql.jdbc.Driver");
		     Connection  conn = DriverManager.getConnection(connectionUrl,"root","apkc");

			//----------------Statement.executeQuery()------------------------------------------
			String querySelect = "select * from dbJDBC.Employees ";
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
			String queryUpdate = "update dbJDBC.Employees " +
					"set eName='Unknown' where eNo=111" ;
			
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
