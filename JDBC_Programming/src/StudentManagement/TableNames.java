package StudentManagement;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class TableNames {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(MySqlInfo.url, MySqlInfo.username, MySqlInfo.password);
			
			DatabaseMetaData dmd = conn.getMetaData();
			ResultSet rs = dmd.getTables(null, null, "%", null);
			
			while (rs.next()) {
				System.out.println(rs.getString(3));
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
