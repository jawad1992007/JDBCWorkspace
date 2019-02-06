package callableStatement1;

import java.sql.*;

public class CallableStatement_MySQL {

	public static void main(String[] args) {

		try {
			String connectionUrl = "jdbc:mysql://localhost:3306/dbjdbc";

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(connectionUrl,
					"root", "apkc");

			String query = "{ call dbjdbc.test_proc(?,?,?,?,?,?)}";

			CallableStatement cstmt = conn.prepareCall(query);
			cstmt.setInt(1, 10);
			cstmt.setInt(2, 20);
			cstmt.setInt(3, 30);
			cstmt.registerOutParameter(4, Types.INTEGER);
			cstmt.registerOutParameter(5, Types.INTEGER);
			cstmt.registerOutParameter(6, Types.INTEGER);

			int result = cstmt.executeUpdate();
			int outputSum = cstmt.getInt(4);
			int outputProduct = cstmt.getInt(5);
			int outputAverage = cstmt.getInt(6);
			System.out.println("Output Sum-->" + outputSum);
			System.out.println("Output Product-->" + outputProduct);
			System.out.println("Output Average-->" + outputAverage);

		} catch (Exception e) {
			System.out.println("Exception in main()-->" + e);
			e.printStackTrace();
		}

	}

}
