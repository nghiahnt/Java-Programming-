package TCP_UDP_URLMulticast.Standalone_App;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddStudent {

	static List<String> value(String[] args) {
		List<String> arrList = new ArrayList<String>(Arrays.asList(args));
		return arrList;
	}

	public static void main(String[] args) throws SQLException {
		String[] arguments = { "nghia", "10", "9", "8" };
		ArrayList<String> arrValue = (ArrayList<String>) value(arguments);

		Statement statement = connection.connect();
		String sql = "INSERT INTO students (Name, Math, Phys, Chem, Aver) VALUES ('" + arrValue.get(0) + "', '"
				+ arrValue.get(1) + "', '" + arrValue.get(2) + "', '" + arrValue.get(3) + "', '"
				+ ((Integer.parseInt(arrValue.get(1)) + Integer.parseInt(arrValue.get(2))
						+ Integer.parseInt(arrValue.get(3))) / 3)
				+ "')";
//		System.out.println(sql);
		
		int temp = statement.executeUpdate(sql);
		if (temp == 1) {
			System.out.println("A line was added to the table");
		}

	}

}
