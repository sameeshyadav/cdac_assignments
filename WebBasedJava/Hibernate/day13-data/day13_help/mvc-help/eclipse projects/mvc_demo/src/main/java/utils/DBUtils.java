package utils;

import java.sql.*;

public class DBUtils {
	private static Connection cn;
//add a static method to return FIXED DB connection

	public static Connection getDBConnection() throws ClassNotFoundException, SQLException {
		if (cn == null) {
			System.out.println("db cn opened....");
			// load JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test?useSSL=false&allowPublicKeyRetrieval=true", "root", "root");
		}
		return cn;
	}

	public static void closeConnection() throws SQLException {
		System.out.println("db cn closed...");
		if (cn != null)
			cn.close();
		cn = null;
	}
}
