package sumi.java.common;

import java.sql.*;

public class ConnUtil {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(

				"jdbc:oracle:thin:@localhost:1521:xe",

				"sumi", "sumi");

	}
}
