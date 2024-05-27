package TCP_UDP_URLMuticast.Standalone_App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class connection {
	
	@SuppressWarnings("unused")
	static Statement connect() throws SQLException {
		Statement statement = null;
		
		String url = "jdbc:mysql://localhost:3306/studentmanagement";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection(url, "root", "");
			System.out.println("Connection successfully");
			statement = connection.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return statement;
	}
}
