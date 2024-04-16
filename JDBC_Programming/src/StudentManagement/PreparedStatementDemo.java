package StudentManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

// Using prepared statement to add information to Student database
public class PreparedStatementDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String names[] = {"Tran Thi", "Xuan Xuan", "Trong Nghia"};
		float Math[] = {7, 8, 7};
		float Phys[] = {9, 10, 10};
		float Chem[] = {5, 6, 7};
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(MySqlInfo.url, MySqlInfo.username, MySqlInfo.password);
			
			PreparedStatement ps = conn.prepareStatement("Insert into students (ID, Name, Math, Phys, Chem, Aver) values(?, ?, ?, ?, ?, ?)");
			// Set don't auto send commit
			conn.setAutoCommit(false);
			// Set value for the arguments "?"
			for (int i=0; i<names.length; i++) {
				ps.setInt(1, i+1);
				ps.setString(2, names[i]);
				ps.setFloat(3, Math[i]);
				ps.setFloat(4, Phys[i]);
				ps.setFloat(5, Chem[i]);
				ps.setFloat(6, (Math[i] + Phys[i] + Chem[i]) / 3);
				ps.executeUpdate();
			}
			conn.commit();
			
			// Execute information from student table
			ResultSet rs = ps.executeQuery("Select * from students");
			ResultSetMetaData rsm = (ResultSetMetaData) rs.getMetaData();
			
			int col_num = rsm.getColumnCount();
			
			for (int i=1; i<=col_num; i++) {
				System.out.print(rsm.getColumnLabel(i) + "\t");
			}
			System.out.println("");
			
			while (rs.next()) {
				for (int i=1; i<col_num; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println("");
//				ps.close();
//				conn.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
