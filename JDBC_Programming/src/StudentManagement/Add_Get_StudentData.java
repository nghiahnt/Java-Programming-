package StudentManagement;

import java.sql.*;

public class Add_Get_StudentData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/StudentManagement";
			String username = "root";
			String password = "";
			
			Connection conn = DriverManager.getConnection(url, username, password);
			System.out.print("Connection establish! \n");
			
			Statement sm = conn.createStatement();
			
			// Add data
			sm.executeUpdate("Insert into students values(9, \"NTNghia\", 10, 10, 10, (10+10+10)/3)");
			sm.executeUpdate("Insert into students values(8, \"TXXuan\", 10, 10, 9, (10+10+9)/3)");
			
			ResultSet rs = sm.executeQuery("Select * from students");
			ResultSetMetaData rsm = rs.getMetaData(); // Get the number of column
			
			int col_num = rsm.getColumnCount();
			for (int i=1; i<=col_num; i++)
				System.out.print(rsm.getColumnLabel(i) + "\t");
			System.out.println("");
			
			while (rs.next()) {
				for (int i=1; i<=col_num; i++) {
					System.out.print(rs.getString(i) + "\t");
				}
				System.out.println("");
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.print(e);
		}
	}

}

