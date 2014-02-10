

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UpdateDemo {
	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		Connection connection = null;
		Statement stmt = null;

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/class3", "root", "123456");
			if (connection != null) {

				stmt = connection.createStatement();
				String query = "insert into sc values ('1','3','90')";
				int rows = stmt.executeUpdate(query);
				System.out.println(rows);
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
