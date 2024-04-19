package StudentManagement_Full;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Controller {
	static Statement statement;
	
	public static Statement connection() {
		String url = "jdbc:mysql://localhost:3306/studentmanagement";
		String username = "root";
		String password = "";
		
		Connection conn;
		Statement st = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);			
			st = conn.createStatement();
			System.out.println("Connection established");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		statement = st;
		return st;
	}
	
	// Get all student data
	public static Vector<Object> getAllStudents() {
		Vector<Object> studentData = new Vector<Object>();
		try {
			Vector<Object> vData = new Vector<Object>();
			Vector<Object> vTitle = new Vector<Object>();
			
			ResultSet resultSet = statement.executeQuery("select * from students");
			
			ResultSetMetaData rsm = (ResultSetMetaData) resultSet.getMetaData();
			int num_column = rsm.getColumnCount();
			
			for (int i=1; i<=num_column; i++) {
				vTitle.add(rsm.getColumnLabel(i));
			}
			
			while (resultSet.next()) {
				Vector<Object> row = new Vector<Object>();
				for (int i=1; i<=num_column; i++) {
					row.add(resultSet.getString(i));
				}
				vData.add(row);
			}
//			System.out.println(vTitle);
//			System.out.println(vData);
			
			studentData.add(vData);
			studentData.add(vTitle);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return studentData;
	}
	
	// Delete function
	public static void deleteStudent(int studentId) throws SQLException {
		String sql = "Delete from students where id = \""+studentId+ "\"";
		statement.executeUpdate(sql);
	}
	
	// Insert 
	public static void insertStudent() {
		
	}
	
	// Update 
	public static void updateStudent() {
		
	}
	
	// Sort
	public static void sortStudent() {
		
	}
	
	// Search student
	public static void searchStudent() {
		
	}
}
