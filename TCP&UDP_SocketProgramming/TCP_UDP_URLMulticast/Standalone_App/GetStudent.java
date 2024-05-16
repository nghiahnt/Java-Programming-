package TCP_UDP_URLMulticast.Standalone_App;

import java.sql.ResultSet;
import java.sql.Statement;

public class GetStudent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Statement statement = connection.connect();
			String sql = "select * from students";
			
			ResultSet resultSet = statement.executeQuery(sql);
			
			int colNum = resultSet.getMetaData().getColumnCount();
			
			while(resultSet.next()) {
				for (int i=1; i<=colNum; i++) {
					System.out.print(resultSet.getString(i) + "\t");
				}
				System.out.println("");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
