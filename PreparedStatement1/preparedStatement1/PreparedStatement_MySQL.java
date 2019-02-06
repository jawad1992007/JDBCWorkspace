package preparedStatement1;

import java.sql.*;


public class PreparedStatement_MySQL {

	public static void main(String[] args) {
		try {

		     String connectionUrl = "jdbc:mysql://localhost:3306/dbjdbc";

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			Connection conn = DriverManager.getConnection(connectionUrl,"root","apkc");

			PreparedStatement ps = conn.prepareStatement("insert into dbJDBC.Employees values (?,?,?)");
			ps.setInt(1, new Integer(222).intValue());
			ps.setString(2, "ankur");
			ps.setString(3, "ankur@hotmail.com");

			// Positive = Success - no of rows effected
			// Negative Number = Error code --> Failure
			int result = ps.executeUpdate();

			System.out.println("result-->" + result);
		} catch (Exception e) {
			System.out.println("Exception in main()-->" + e);
		}

	}

}
