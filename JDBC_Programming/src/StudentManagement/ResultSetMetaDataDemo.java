package StudentManagement;

import java.sql.*;

// ResultSetMetaData include the corresponding information about structure of mysql and ResultSet 
public class ResultSetMetaDataDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Load JDBC MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Connect
			String url = "jdbc:mysql://localhost:3306/StudentManagement";
			String username = "root";
			String password = "";
			Connection conn = DriverManager.getConnection(url, username, password);
			
			// Excute query
			Statement sm = conn.createStatement();
			// ResultSet
			ResultSet rs = sm.executeQuery("Select * from Students");
			// Get data
			ResultSetMetaData rsm = rs.getMetaData();
			
			int col_num = rsm.getColumnCount();
			for (int i=1; i<=col_num; i++) {
				System.out.print(rsm.getColumnLabel(i) + "  ");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
