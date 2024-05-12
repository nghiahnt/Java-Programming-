package Management_Programming;

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.TileObserver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Main extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Components
	JLabel nameLabel, passwordLabel, urlLabel, driverLabel;
	JTextField nameTextField, passwordTextField, urlTextField, driverTextField;
	JButton connectBtn, saveXML;
	Container container;
	
	JPanel formPanel;
	
	public static Vector vData, vTitle;
	
	public static Statement statement;
	
	public Main(String tilte) {
		super(tilte);
		container = this.getContentPane();
		
		formPanel = new JPanel();
		formPanel.setLayout(new GridLayout(4, 2));
		
		nameLabel = new JLabel("User name");
		passwordLabel= new JLabel("Password");
		urlLabel = new JLabel("Database URL");
		driverLabel = new JLabel("Driver");
		
		nameTextField = new JTextField("");
		passwordTextField = new JTextField("");
		urlTextField = new JTextField("");
		driverTextField = new JTextField("");
		
		formPanel.add(nameLabel);
		formPanel.add(nameTextField);
		formPanel.add(passwordLabel);
		formPanel.add(passwordTextField);
		formPanel.add(urlLabel);
		formPanel.add(urlTextField);
		formPanel.add(driverLabel);
		formPanel.add(driverTextField);
		
		connectBtn = new JButton("Connect");
		connectBtn.addActionListener(this);
		
		container.add(formPanel, "North");
		container.add(connectBtn);
		
		setSize(500, 150);
		this.setLocation(300, 300);
		this.setVisible(true);
	}
	
	public static Statement connection(String name, String pass, String url, String driver) throws SQLException {
		
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(url, name, pass);
			statement = connection.createStatement();
			System.out.println("Connection successfully");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statement;
	}
	
	public static Vector<Object> getAllStudents() {
		Vector<Object> studentData = new Vector<Object>();
		try {
			vData = new Vector<Object>();
			vTitle = new Vector<Object>();

			ResultSet resultSet = statement.executeQuery("select * from manager");

			ResultSetMetaData rsm = (ResultSetMetaData) resultSet.getMetaData();
			int num_column = rsm.getColumnCount();

			for (int i = 1; i <= num_column; i++) {
				vTitle.add(rsm.getColumnLabel(i));
			}

			while (resultSet.next()) {
				Vector<Object> row = new Vector<Object>();
				for (int i = 1; i <= num_column; i++) {
					row.add(resultSet.getString(i));
				}
				vData.add(row);
			}
//			System.out.println(vTitle);
//			System.out.println(vData);

			studentData.add(vData);
			studentData.add(vTitle);
			System.out.println(studentData);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return studentData;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Main obj = new Main("Connection Information");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String name = nameTextField.getText();
		String pass = passwordTextField.getText();
		String url = urlTextField.getText();
		String driver = driverTextField.getText();
		
		try {
			connection(name, pass, url, driver);
			getAllStudents(); // ok
			new StudentManagement("Infomation", vData, vTitle);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
