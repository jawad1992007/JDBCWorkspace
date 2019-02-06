package databaseMetaData1;

import java.sql.*;

public class DatabaseMetaData_MySQL {

	public static void main(String args[]) {
		try {

		     String connectionUrl = "jdbc:mysql://localhost:3306/dbjdbc";

	           Class.forName("com.mysql.jdbc.Driver");
	           Connection conn = DriverManager.getConnection(connectionUrl,"root","apkc");

			DatabaseMetaData dbmd = conn.getMetaData();
			// -------------DB Driver----------------------------
			System.out.println("Driver Vesion-->" + dbmd.getDriverVersion());
			System.out.println("----------------------------");
			// -------------DB Roles and Users------------------------
			ResultSet rs = dbmd.getSchemas();
			while (rs.next()) {
				System.out.println(rs.getString(1));
			}
			System.out.println("----------------------------");
			// ------------------------------------------------
			System.out.println("Type Info-->" + dbmd.getTypeInfo());
			System.out.println("----------------------------");
			// ------------------------------------------------
			System.out.println("URL-->" + dbmd.getURL());
			System.out.println("----------------------------");
			// ------------------------------------------------
			System.out.println("UserName-->" + dbmd.getUserName());
			System.out.println("----------------------------");
			// ------------------------------------------------
			System.out.println("Database Product Name-->"
					+ dbmd.getDatabaseProductName());
			System.out.println("----------------------------");
			// ------------------------------------------------
			System.out.println("Driver Name-->" + dbmd.getDriverName());
			System.out.println("----------------------------");
			// ------------------------------------------------
			System.out.println("Database Product Version-->"
					+ dbmd.getDatabaseProductVersion());
			System.out.println("----------------------------");
			// ------------------------------------------------
			System.out.println("Driver Version-->" + dbmd.getDriverVersion());
			System.out.println("----------------------------");
			// ------------------------------------------------
			System.out.println("Catalog Term-->" + dbmd.getCatalogTerm());
			System.out.println("----------------------------");
			// ------------------------------------------------

		} catch (Exception e) {

		}
	}

}
