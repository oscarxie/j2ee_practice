

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCSimpleDemo {
	public static void main(String[] args) {
		System.out.println("-------- MySQL JDBC Connection Testing ------------");

		try {

			Class.forName("com.mysql.jdbc.Driver");

		} catch (ClassNotFoundException e) {

			System.out.println("Where is your MySQL JDBC Driver?");
			System.out
					.println("Please put MySQL JDBC Driver jar on classpath.");
			e.printStackTrace();
			return;

		}

		System.out.println("MySQL JDBC Driver Registered!");
		Connection connection = null;

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/class3", "root", "123456");

		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return;
		}

		if (connection != null) {
			System.out.println("DB connected!");
		} else {
			System.out.println("Failed to make connection!");
		}

	}

}
