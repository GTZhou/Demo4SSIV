package cn.com.tarena.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static final String DB_DRIVER = "com.mysql.jdbc.Driver";

	private static final String DB_URL = "jdbc:mysql://localhost:3306/test";

	private static final String DB_USER = "root";

	private static final String DB_PSWD = "root";

	public static Connection getConnection() throws ClassNotFoundException,
			SQLException {
		Connection conn;

		Class.forName(DB_DRIVER);

		conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PSWD);
		return conn;
	}

}
