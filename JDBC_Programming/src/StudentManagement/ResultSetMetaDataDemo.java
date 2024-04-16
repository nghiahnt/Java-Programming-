package StudentManagement;

import java.sql.*;

// Url, username, password
class MySqlInfo {
	public static String url = "jdbc:mysql://localhost:3306/StudentManagement";
	public static String username = "root";
	public static String password = "";
}

// ResultSetMetaData include the corresponding information about structure of mysql and ResultSet 
public class ResultSetMetaDataDemo {
	public static String url;
	public static String username;
	public static String password;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Load JDBC MySQL Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Connect
			Connection conn = DriverManager.getConnection(MySqlInfo.url, MySqlInfo.username, MySqlInfo.password);
			
			// Excute query
			Statement sm = conn.createStatement();
			// ResultSet
			ResultSet rs = sm.executeQuery("Select * from Students");
			// Get data
			ResultSetMetaData rsm = rs.getMetaData();
			
			int col_num = rsm.getColumnCount();
			for (int i=1; i<=col_num; i++) {
				System.out.print(rsm.getColumnLabel(i) + "\t");
			}
			System.out.println("");
			
			while (rs.next()) {
				for (int i=1; i<=col_num; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println("");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}

}
