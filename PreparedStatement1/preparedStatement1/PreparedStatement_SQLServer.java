package preparedStatement1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

/**
 * This class demonstrates the use of a PreparedStatement class Database : SQL
 * Server 2000 Schema: dbJDBC Table: Employees
 * 
 * @Jar Files: - msbase.jar - mssqlserver.jar - msutil.jar - sqljdbc.jar
 * 
 * @author Ankur Israni
 * 
 */
public class PreparedStatement_SQLServer {

	public static void main(String[] args) {
		try {

			// SQL Server Query String
			String connectionUrl = "jdbc:sqlserver://localhost:1433;"
					+ "databaseName=dbJDBC;" + "userName=sa;" + "password=apkc";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(connectionUrl);

			PreparedStatement ps = conn.prepareStatement("insert into " +
					""+ "dbJDBC.dbo.Employees values (?,?,?)");
			ps.setInt(1, new Integer(111).intValue());
			ps.setString(2, "kumar");
			ps.setString(3, "kumar@hotmail.com");

			// Positive = Success - no of rows effected
			// Negative Number = Error code --> Failure
			int result = ps.executeUpdate();

			System.out.println("result-->" + result);
		} catch (Exception e) {
			System.out.println("Exception in main()-->" + e);
		}

	}

}
