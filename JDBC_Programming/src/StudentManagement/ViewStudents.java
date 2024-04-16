package StudentManagement;

import java.sql.*;
import java.util.Vector;
import javax.swing.*;

public class ViewStudents extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@SuppressWarnings({ "null", "unchecked" })
	public static void main(String[] args) {
		@SuppressWarnings("rawtypes")
		Vector vData = null;
		Vector vTitle = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					MySqlInfo.url, MySqlInfo.username, MySqlInfo.password);
			
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("Select * from students");
			ResultSetMetaData rsm = rs.getMetaData();
			
			int num_column = rsm.getColumnCount();
			
			vTitle = new Vector(num_column);
			for (int i=1; i<=num_column; i++) {
				vTitle.add(rsm.getColumnLabel(i));
			}
			
			vData = new Vector(10, 10);
			while (rs.next()) {
				Vector<Object> row = new Vector<Object>(num_column);
				for (int i=1; i<=num_column; i++) {
					row.add(rs.getString(i));
				}
				vData.add(row);
			}
			
			// Close connection
			/**
			 * rs.close();
			 * st.close();
			 * conn.close();
			 */
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
		}
		
		// Interface
		JScrollPane tableResult = new JScrollPane(new JTable(vData, vTitle));
		JFrame f = new JFrame();
		f.setContentPane(tableResult);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setSize(450, 200);
		f.setVisible(true);
 	}
}
