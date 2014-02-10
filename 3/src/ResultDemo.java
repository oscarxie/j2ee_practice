

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ResultDemo {
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
				String query = "select * from student";
				ResultSet rs=stmt.executeQuery(query);
				while(rs.next())
				{
					System.out.println(rs.getString(1));
					System.out.println(rs.getString("sname"));
				}
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
