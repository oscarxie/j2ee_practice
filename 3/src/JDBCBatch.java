

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCBatch {


	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {

			System.out.println("Where is your MySQL JDBC Driver?");
			e.printStackTrace();
			return;
		}

		Connection connection = null;
        PreparedStatement pstmt;

		try {
			connection = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/class3", "root", "123456");
			if (connection != null) {
				
				String query = "insert into sc values (?,?,?)";
				pstmt = connection.prepareStatement(query);
				connection.setAutoCommit(false);
				pstmt.clearBatch();
				pstmt.setString(1,"1");
				pstmt.setString(2,"5");
				pstmt.setString(3,"70");
				pstmt.addBatch();
				
				pstmt.setString(1,"1");
				pstmt.setString(2,"6");
				pstmt.setString(3,"80");
				pstmt.addBatch();
				
				pstmt.executeBatch();
				connection.commit();
				
			} else {
				System.out.println("Failed to make connection!");
			}
		} catch (SQLException e) {
			try {
				connection.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			e.printStackTrace();
		} finally {
			try {
				connection.close();

			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
